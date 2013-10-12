import java.util.ArrayList;
import java.util.List;

public class Account {
    String name;
    List<Transaction> debit = new ArrayList<>();
    List<Transaction> credit = new ArrayList<>();

    Account(String name)
    {
            this.name = name;
    }

}
