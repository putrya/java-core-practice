public class Main {
    static void main() {
        Customer alex = new Customer("Alex", "alex@gmail.com");
        Order order = new Order(alex, 10);
        if (order.getStatus() != OrderStatus.NEW) {
            throw new IllegalStateException();
        }
        String orderBeforePay = order.getOrderInfo();
        System.out.println(orderBeforePay);
        order.pay();
        if (order.getStatus() != OrderStatus.PAID) {
            throw new IllegalStateException();
        }
        String orderAfterPay = order.getOrderInfo();
        System.out.println(orderAfterPay);
        order.ship();
        if (order.getStatus() != OrderStatus.SHIPPED) {
            throw new IllegalStateException();
        }
        String orderAfterShip = order.getOrderInfo();
        System.out.println(orderAfterShip);
        order.deliver();
        if (order.getStatus() != OrderStatus.DELIVERED) {
            throw new IllegalStateException();
        }
        String orderAfterDelivery = order.getOrderInfo();
        System.out.println(orderAfterDelivery);
        Order order1 = new Order(alex, 5000);
        order1.cancel();
        if (order1.getStatus() != OrderStatus.CANCELLED) {
            throw new IllegalStateException();
        }
        String orderAfterCansel = order1.getOrderInfo();
        System.out.println(orderAfterCansel);

        Order order2 = new Order(alex, 10000);
        order2.pay();
        order2.cancel();
        if (order2.getStatus() != OrderStatus.CANCELLED) {
            throw new IllegalStateException();
        }
        String orderAfterPayAndCansel = order2.getOrderInfo();
        System.out.println(orderAfterPayAndCansel);

        try {
            Order order3 = new Order(null, 300);
        } catch (IllegalArgumentException e) {
            System.out.println("It is not possible to create an order with a customer = null");
        }

        try {
            Order order3 = new Order(alex, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("It is not possible to create an order with amount = 0");
        }

        try {
            Order order3 = new Order(alex, -100);
        } catch (IllegalArgumentException e) {
            System.out.println("It is not possible to create an order with a negative amount");
        }

        try {
            Order order3 = new Order(alex, 5000);
            order3.pay();
            order3.pay();
        } catch (IllegalStateException e) {
            System.out.println("Unable to call pay() a second time");
        }

        try {
            Order order3 = new Order(alex, 5000);
            order3.ship();
        } catch (IllegalStateException e) {
            System.out.println("Unable to call ship() before pay();");
        }

        try {
            Order order3 = new Order(alex, 5000);
            order3.pay();
            order3.deliver();
        } catch (IllegalStateException e) {
            System.out.println("Unable to call deliver() before ship();");
        }

        try {
            Order order3 = new Order(alex, 5000);
            order3.pay();
            order3.ship();
            order3.cancel();
        } catch (IllegalStateException e) {
            System.out.println("It is not possible to cancel the order after shipment.");
        }

        try {
            Order order3 = new Order(alex, 5000);
            order3.pay();
            order3.ship();
            order3.deliver();
            order3.cancel();
        } catch (IllegalStateException e) {
            System.out.println("It is not possible to cancel an order after delivery");
        }

        try {
            Order order3 = new Order(alex, 5000);
            order3.pay();
            order3.cancel();
            order3.cancel();
        } catch (IllegalStateException e) {
            System.out.println("It is not possible to cancel the order again");
        }

    }
}
