public class BankApplication {

    private int balance;

    public BankApplication(int balance) {
        if(balance < 0)
            throw new IllegalArgumentException("Balance cannot be negative");
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public boolean credit(int creditAmount) {
        if(creditAmount >= 0) {
            balance += creditAmount;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean withdraw(int withdrawAmount) {
        if(withdrawAmount > 0 && withdrawAmount <= balance) {
            balance = balance - withdrawAmount;
            return true;
        }
        else {
            return false;
        }
    }
}
