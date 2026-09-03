public class Author {
    private final int id;
    private final String name;
    private final String country;
    private static int counter = 0;

    public Author(String name, String country) {
        if (name == null || name.isBlank() || country == null || country.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.country = country;
        counter++;
        this.id = counter;

    }

    public String getAuthorInfo() {
        return "ID: " + id + "\nAuthor: " + name + "\nCountry: " + country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }
}
