public class Customer {
    private final int id;
    private final String name;
    private final String email;
    private static int counter;


    public Customer(String name, String email) {
        if (name == null || name.isBlank() || email == null || email.isBlank()) {
            throw new IllegalStateException();
        }
        this.name = name;
        this.email = email;
        counter++;
        id = counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCustomerInfo() {
        return "ID: " + id + "\nName: " + name + "\nEmail " + email;
    }


}
