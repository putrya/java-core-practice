public class Reader {

    private final int id;
    private final String name;
    private Book borrowedBook;
    private static int counter;

    public Reader(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        counter++;
        id = counter;
        this.borrowedBook = null;
    }

    public void borrowBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException();
        }

        if (borrowedBook != null || !book.isAvailable()) {
            throw new IllegalStateException();
        }

        book.borrow();
        this.borrowedBook = book;
    }

    public void returnBook() {
        if (borrowedBook == null) {
            throw new IllegalStateException();
        }

        borrowedBook.returnBook();
        borrowedBook = null;
    }

    public String getReaderInfo() {
        if (borrowedBook == null) {
            return "ID: " + id + "\nName: " + name + "\n\nBorrowed:\nnone";
        }
        return "ID: " + id + "\nName: " + name + "\n\nBorrowed:\n" + borrowedBook.getTitle();
    }

}
