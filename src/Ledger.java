import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.math.*;
import java.sql.*;

/////features so far..
//1. makes ledger accounts for all accounts from journal entries
//2. prepares the trial balance
////later ambitions...
//1. attach a database
//2. add a fancy UI
//3. prepare balance sheets from trial balances and add more features of accounts..




public class Ledger {

    List<Account> openedAccounts = new ArrayList<>();
    List<journalEntry> journalEntries = new ArrayList<>();
    Map<Account,Double> trialBalance = new HashMap<>(); //final balances of all accounts...
    boolean accountExists(String name)
    {
             for (Account openedAccount : openedAccounts) {
                if(name == openedAccount.name) return true;
             }
             return false;
    }
    Account findAccount(String ac)
    {
        for (Account openedAccount : openedAccounts) {
            if(ac == openedAccount.name) return openedAccount;
        }
        return null;
    }
    Account openAccount(String name)
    {   if (accountExists(name)) return findAccount(name);

        else
        {
            Account ac = new Account(name);
            openedAccounts.add(ac);
            return ac;
        }
    }

    void addDebitTransaction(Account ac,Transaction transaction)
    {
        ac.debit.add(transaction);
    }
    void addCreditTransaction(Account ac,Transaction transaction)
    {
        ac.credit.add(transaction);
    }
    double sumDebitTransactions(Account ac)
    {
        int s = 0;
        for (Transaction dr: ac.debit)
            s += dr.amount;
        return s;
    }
    double sumCreditTransactions(Account ac)
    {
        int s = 0;
        for (Transaction cr: ac.credit)
            s += cr.amount;
        return s;
    }
    ////balance is now a new datatype....make appropriate changes..
    double calculateBalance(Account ac)
    {
        double bal;
        double cr = sumCreditTransactions(ac);
        double dr = sumDebitTransactions(ac);
        bal = (dr>cr)?dr-cr:cr-dr;
        Transaction t = new Transaction("end of month","by balance b/d",bal);
        return bal;
    }
    void calculateTrialBalance()
    {
        for (Account account:openedAccounts)
            trialBalance.put(account,calculateBalance(account));
    }
    void printTransaction(Transaction t)
    {
        System.out.println(t.date+"\t\t"+t.particulars+"\t\t"+t.amount);
    }
    void printAccount(Account ac)
    {
        System.out.println("-------"+ac.name+"--------");
        System.out.println("debit");
        for (Transaction t1:ac.debit)
            printTransaction(t1);

        System.out.println("credit");
        for (Transaction t2:ac.credit)
            printTransaction(t2);

        System.out.println("balance c/d"+calculateBalance(ac));
    }
    void printLedger()
    {
        for (Account ac:openedAccounts)
            printAccount(ac);
    }
    void printTrialBalance()
    {
        calculateTrialBalance();
        for (Account account:openedAccounts)
            System.out.println(account.name+"----"+trialBalance.get(account));
    }
    void pseudoInput()
    {
        journalEntries.add(new journalEntry("1/1","cash","capital",1000));
        journalEntries.add(new journalEntry("3/1","A","cash",500));
        journalEntries.add(new journalEntry("5/1","B","A",1500));

    }
    public static void main(String args[])
    {
        Ledger ledger = new Ledger();
        ledger.pseudoInput();
        for (journalEntry jornal: ledger.journalEntries)
        {
            Account drAccount = ledger.openAccount(jornal.drAccount);
            Account crAccount = ledger.openAccount(jornal.crAccount);
            Transaction t1 = new Transaction(jornal.date,jornal.drAccount,jornal.amount);
            Transaction t2 = new Transaction(jornal.date,jornal.crAccount,jornal.amount);
            ledger.addCreditTransaction(drAccount,t2);
            ledger.addDebitTransaction(crAccount,t1);
        }
//        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//        }
//        catch(ClassNotFoundException ex) {
//            System.out.println("Error: unable to load driver class!");
//            System.exit(1);
//        }


       // ledger.printLedger();
        ledger.printTrialBalance();
    }


}

