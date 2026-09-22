public class Main {
    static void main() {
        Owner owner = new Owner("Eugene", "AWs3300");
        BankAccount bankAccount = new BankAccount(owner, 10000);
        bankAccount.deposit(5000);
        double balanceAfterDeposit = bankAccount.getBalance();
        System.out.println("Balance: " + balanceAfterDeposit);
        bankAccount.withdraw(7000);
        double balanceAfterWithdraw = bankAccount.getBalance();
        System.out.println(balanceAfterWithdraw);

        BankAccount bankAccount1 = new BankAccount(owner, 300);
        bankAccount1.transferTo(bankAccount, 150);
        double balanceAfterTransfer = bankAccount1.getBalance();
        double balanceAfterTransfer2 = bankAccount.getBalance();
        System.out.println(balanceAfterTransfer);
        System.out.println(balanceAfterTransfer2);

        try {
            BankAccount bankAccount2 = new BankAccount(null, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("BankAccount must be != null");
        }

        try {
            Owner owner1 = new Owner("Max", "dfsfs");
            BankAccount bankAccount2 = new BankAccount(owner, -100);
        } catch (IllegalArgumentException e) {
            System.out.println("InitialBalance must be >= 0");
        }

        try {
            Owner owner1 = new Owner("Max", "dfsfs");
            BankAccount bankAccount2 = new BankAccount(owner1, 0);
            bankAccount2.deposit(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit must be > 0");
        }

        try {
            Owner owner1 = new Owner("Max", "dfsfs");
            BankAccount bankAccount2 = new BankAccount(owner1, 0);
            bankAccount2.deposit(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit must be > 0");
        }

        try {
            Owner owner1 = new Owner("Max", "dfsfs");
            BankAccount bankAccount2 = new BankAccount(owner1, 100);
            bankAccount2.withdraw(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Withdraw must be > 0");
        }

        try {
            bankAccount.withdraw(10000000);
        } catch (IllegalStateException e) {
            System.out.println("Insufficient funds");
            double balance = bankAccount.getBalance();
            System.out.println(balance);
        }

        try {
            Owner owner1 = new Owner("Max", "dfsfs");
            BankAccount bankAccount2 = new BankAccount(owner, 100);
            bankAccount2.withdraw(-50);
        } catch (IllegalArgumentException e) {
            System.out.println("Withdraw must be > 0");
        }

        try {
            Owner owner1 = new Owner("Max", "dfsfs");
            BankAccount bankAccount2 = new BankAccount(owner, 100);
            bankAccount2.transferTo(bankAccount, 10000);
        } catch (IllegalStateException e) {
            System.out.println("Insufficient funds for the transfer");
        }

        try {
            Owner owner1 = new Owner("Max", "dfsfs");
            BankAccount bankAccount2 = new BankAccount(owner, 100);
            bankAccount2.transferTo(bankAccount2, 50);
        } catch (IllegalStateException e) {
            System.out.println("Self-translation is prohibited");
        }

        try {
            Owner owner1 = new Owner("Max", "dfsfs");
            BankAccount bankAccount2 = new BankAccount(owner, 100);
            bankAccount2.transferTo(null, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Target must be != null");
        }

    }
}
