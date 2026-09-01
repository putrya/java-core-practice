public class Main {
    static void main() {
        Product apple = new Product("Apple", 100, 20);
        Product orange = new Product("Orange", 200, 50);
        System.out.println("ID apple: " + apple.getId() + "\n" + "Id orange: " + orange.getId());
        apple.addStock(100);
        System.out.println("Info after added stock\n" + apple.getProductInfo());
        apple.removeStock(100);
        System.out.println("Info after remove stock\n" + apple.getProductInfo());
        apple.removeStock(20);
        System.out.println("Info after remove all stock\n" + apple.getProductInfo());
        System.out.println("Full price orange: " + orange.calculateTotalValue());
        String orangeInfo = orange.getProductInfo();
        System.out.println(orangeInfo);

        try {
            Product lemon = new Product(null, 100, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Name must not be null.");
        }

        try {
            Product watermelon = new Product("   ", 200, 200);
        } catch (IllegalArgumentException e) {
            System.out.println("Name must not be blank.");
        }


        try {
            Product cherry = new Product("Cherry", 0, 300);
        } catch (IllegalArgumentException e) {
            System.out.println("Price must be > 0.");
        }

        try {
            Product peach = new Product("Peach", 400, -400);
        } catch (IllegalArgumentException e) {
            System.out.println("Count must be positive");
        }


        try {
            apple.addStock(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Argument addStock must be > 0");
        }

        try {
            apple.removeStock(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Argument removeStock must be positive");
        }

        try {
            apple.removeStock(1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Argument removeStock must be <= count");
        }

        System.out.println("The state of the object before removeStock()");
        System.out.println(orange.getProductInfo());
        try {
            orange.removeStock(10000);
        } catch (IllegalArgumentException e) {
            System.out.println("argument removeStock must be >= count");
        }
        System.out.println("The state of the object after removeStock()");
        System.out.println(orange.getProductInfo());

    }
}
