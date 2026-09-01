public class Product {

    private final int id;
    private final String name;
    private final long price;
    private int count;
    private static int counter = 0;

    public Product(String name, int price, int count) {
        if (name == null || name.isBlank() || price <= 0 || count < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.price = price;
        this.count = count;
        counter += 1;
        id = counter;
    }

    public void addStock(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
        count += value;
    }

    public void removeStock(int value) {
        if (value <= 0 || value > count) {
            throw new IllegalArgumentException();
        }
        count -= value;
    }

    public long calculateTotalValue() {
        return price * count;
    }

    public String getProductInfo() {
        return "ID: " + getId() + "\n" + "Название: " + this.name + "\n" + "Цена: " + this.price + "\n" + "Количество: " + this.count + "\n" + "Общая стоимость: " + calculateTotalValue();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
