public class Owner {

    private final int id;
    private final String name;
    private final String passportNumber;
    private static int counter;

    public Owner(String name, String passportNumber) {
        if (name == null || name.isBlank() || passportNumber == null || passportNumber.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.passportNumber = passportNumber;
        counter++;
        id = counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getOwnerInfo() {
        return "ID: " + id + "\nName: " + name + "\nPassportNumber: " + passportNumber;
    }
}
