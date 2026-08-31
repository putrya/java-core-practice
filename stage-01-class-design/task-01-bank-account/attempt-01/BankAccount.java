public class BankAccount {

    private String name;
    private final String accountNumber;
    private double currentBalance;


    public BankAccount(String name, String accountNumber, long currentBalance) {
        if (name.isBlank() | name.isEmpty() | accountNumber.isEmpty() | accountNumber.isBlank() | currentBalance < 0) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.accountNumber = accountNumber;
            this.currentBalance = currentBalance;
        }
    }

    public void deposit(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        } else {
            currentBalance += value;
        }

    }

    public void withdraw(long value) {
        if (value <= 0 | currentBalance < value) {
            throw new IllegalArgumentException();
        } else {
            currentBalance -= value;
        }
    }

    public void printAccountInfo() {
        System.out.println("Владелец: " + name + "\nНомер счета: " + accountNumber + "\nБаланс: " + currentBalance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

}
