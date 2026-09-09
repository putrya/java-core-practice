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
            Reader reader = new Reader("Mike");
            reader.borrowBook(null);
        } catch (IllegalArgumentException e) {
            System.out.println("borrowBook must not be null ");
        }

        try {
            Reader reader2 = new Reader("Fedor");
            reader2.borrowBook(macbeth);
        } catch (IllegalStateException e) {
            System.out.println("The book has already been taken away");
        }

        try {
            Reader reader3 = new Reader("Dmitriy");
            Book othello = new Book("Othello", shakespeare, 500, 350);
            Book kingLear = new Book("King Lear", shakespeare, 350, 400);
            reader3.borrowBook(othello);
            reader3.borrowBook(kingLear);
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
            if (hamlet.isAvailable()) {
                System.out.println("Hamlet is available");
            }
            alex.returnBook();
        } catch (IllegalStateException e) {
            System.out.println("repeat call returnBook");
        }

    }
}
