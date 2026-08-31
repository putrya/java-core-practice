public class Main {

    static void main() {

        BankAccount eugene = new BankAccount("Eugene", "1", 0);
        eugene.deposit(100);
        eugene.withdraw(50);
        try {
            eugene.withdraw(500);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            eugene.deposit(-200);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            BankAccount max = new BankAccount("   ", "2", 0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            BankAccount max = new BankAccount("", "2", 0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


    }
}

