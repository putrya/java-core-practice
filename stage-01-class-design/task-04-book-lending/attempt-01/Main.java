public class Main {
    static void main() {

        Author shakespeare = new Author("William Shakespeare", "England");
        Book hamlet = new Book("Hamlet", shakespeare, 500, 350);
        Book macbeth = new Book("Macbeth", shakespeare, 350, 400);

        Reader alex = new Reader("Alex");
        Reader mike = new Reader("Mike");
        alex.borrowBook(hamlet);
        mike.borrowBook(macbeth);

        String authorInfo = shakespeare.getAuthorInfo();
        String bookInfo = hamlet.getBookInfo();
        String bookInfo1 = macbeth.getBookInfo();
        String readerInfo = alex.getReaderInfo();
        String readerInfo1 = mike.getReaderInfo();


        System.out.println(authorInfo);
        System.out.println(bookInfo);
        System.out.println(bookInfo1);
        System.out.println(readerInfo);
        System.out.println(readerInfo1);

        try {
            alex.borrowBook(null);
        } catch (IllegalStateException e) {
            System.out.println("borrowBook must not be null ");
        }

        try {
            alex.borrowBook(hamlet);
        } catch (IllegalStateException e) {
            System.out.println("The book has already been taken away");
        }

        try {
            alex.borrowBook(macbeth);
        } catch (IllegalStateException e) {
            System.out.println("It is impossible to take the second book without returning the first one.");
        }

        try {
            Reader denis = new Reader("Denis");
            denis.returnBook();
        } catch (IllegalStateException e) {
            System.out.println("The reader has no book to return to");
        }

        try {
            alex.returnBook();
            alex.returnBook();
        } catch (IllegalStateException e) {
            System.out.println("repeat call returnBook");
        }

    }
}
