public class Main {

    static void main() {

        BankAccount eugene = new BankAccount("Eugene", "1", 6660);
        eugene.printAccountInfo();
        eugene.deposit(500.4);
        eugene.printAccountInfo();
        eugene.withdraw(100);
        eugene.printAccountInfo();
    }
}
