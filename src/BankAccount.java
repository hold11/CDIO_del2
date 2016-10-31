/**
 * Created by awo on 31/10/16.
 */
public class BankAccount {
    private int balance;
    private int id = 0;
    
    private static int idCount;

    public BankAccount(int balance) {
        this.balance = balance;
        id = idCount;
        idCount++;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int value) {
        if (value > 0)
            this.balance += value;
    }

    public void withdraw(int value) {
        if (value > 0)
            this.balance -= value;
    }
}
