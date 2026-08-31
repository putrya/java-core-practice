public class BankAccount {

    private final String name;
    private final String accountNumber;
    private long currentBalance;


    public BankAccount(String name, String accountNumber, long currentBalance) {
        if (name == null || name.isBlank() || accountNumber == null || accountNumber.isBlank() || currentBalance < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
    }

    public void deposit(long value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
        currentBalance += value;
    }

    public void withdraw(long value) {
        if (value <= 0 || currentBalance < value) {
            throw new IllegalArgumentException();
        }
        currentBalance -= value;
    }

    public void printAccountInfo() {
        System.out.println("Владелец: " + name + "\nНомер счета: " + accountNumber + "\nБаланс: " + currentBalance);
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }

}

