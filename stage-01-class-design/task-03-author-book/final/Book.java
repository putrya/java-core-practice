public class Book {

    private final int id;
    private final String title;
    private final Author author;
    private final long price;
    private final int pages;
    private static int counter;

    public Book(String title, Author author, long price, int pages) {
        if (title == null || title.isBlank() || author == null || price <= 0 || pages <= 0) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
        counter++;
        id = counter;
    }

    public double calculateReadingTime(int pagesPerHour) {
        if (pagesPerHour <= 0) {
            throw new IllegalArgumentException();
        }
        return (double) pages / pagesPerHour;
    }


    public String getBookInfo() {
        return "ID: " + id + "\nTitle: " + title + "\nAuthor: " + author.getName()
                + "\nCountry: " + author.getCountry() + "\nPrice: " + price + "\nPages: " + pages;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public long getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public int getPages() {
        return pages;
    }
}
