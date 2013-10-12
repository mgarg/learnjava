public class journalEntry {
    String date;
    String drAccount;
    String crAccount;
    double amount;

    journalEntry(String date,String drAccount,String crAccount,double amount)
    {
        this.date = date;
        this.drAccount = drAccount;
        this.crAccount = crAccount;
        this.amount = amount;
    }
}
