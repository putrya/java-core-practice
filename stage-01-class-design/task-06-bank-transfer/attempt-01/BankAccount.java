public class BankAccount {
    private final int id;
    private final Owner owner;
    private double balance;
    private static int counter;


    public BankAccount(Owner owner, double balance) {
        if (owner == null || balance < 0) {
            throw new IllegalArgumentException();
        }
        this.owner = owner;
        this.balance = balance;
        counter++;
        id = counter;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        } else if (balance < amount) {
            throw new IllegalStateException();
        }
        balance -= amount;
    }

    public void transferTo(BankAccount target, double amount) {
        if (target == null || amount <= 0) {
            throw new IllegalArgumentException();
        } else if (balance < amount || id == target.id) {
            throw new IllegalStateException();
        }
        balance -= amount;
        target.balance += amount;
    }

    public String getAccountInfo() {
        return "Account ID: " + id + "\nOwner: " + owner.getName() + "\nBalance: " + balance;
    }

    public double getBalance() {
        return balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public int getId() {
        return id;
    }
}
