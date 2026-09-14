public class Order {

    private final int id;
    private final Customer customer;
    private final int amount;
    private OrderStatus status;
    private static int counter;


    public Order(Customer customer, int amount) {
        if (customer == null || amount <= 0) {
            throw new IllegalArgumentException();
        }
        this.customer = customer;
        this.amount = amount;
        counter++;
        id = counter;
        status = OrderStatus.NEW;
    }

    public void pay() {
        if (status != OrderStatus.NEW) {
            throw new IllegalStateException();
        }
        status = OrderStatus.PAID;
    }

    public void ship() {
        if (status != OrderStatus.PAID) {
            throw new IllegalStateException();
        }
        status = OrderStatus.SHIPPED;
    }

    public void deliver() {
        if (status != OrderStatus.SHIPPED) {
            throw new IllegalStateException();
        }
        status = OrderStatus.DELIVERED;
    }

    public void cancel() {
        if (status != OrderStatus.NEW && status != OrderStatus.PAID) {
            throw new IllegalStateException();
        }

        status = OrderStatus.CANCELLED;
    }

    public String getOrderInfo() {
        return "Order ID: " + id + "\nCustomer: " + customer.getName() +
                "\nAmount: " + amount + "\nStatus: " + status.toString();
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getAmount() {
        return amount;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
