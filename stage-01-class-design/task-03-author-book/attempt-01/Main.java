public class Main {
    static void main() {
        Author Shakespeare = new Author("William Shakespeare", "England");
        Book Hamlet = new Book("Hamlet", Shakespeare, 500, 350);
        Book Macbeth = new Book("Macbeth", Shakespeare, 350, 400);
        boolean result = Hamlet.getAuthor() == Macbeth.getAuthor();
        System.out.println(result);
        String authorInfo = Shakespeare.getAuthorInfo();
        System.out.println(authorInfo);
        String bookInfo = Hamlet.getBookInfo();
        System.out.println(bookInfo);
        double readingTime = Hamlet.calculateReadingTime(10);
        System.out.println(readingTime);

        try {
            Author Twain = new Author(null, "USA");
        } catch (IllegalArgumentException e) {
            System.out.println("name must not be null.");
        }

        try {
            Author Fitzgerald = new Author("", "USA");
        } catch (IllegalArgumentException e) {
            System.out.println("name must not be blank.");
        }

        try {
            Book book = new Book(null, Shakespeare, 200, 200);
        } catch (IllegalArgumentException e) {
            System.out.println("title must not be null.");
        }

        try {
            Book book2 = new Book("", Shakespeare, 600, 500);
        } catch (IllegalArgumentException e) {
            System.out.println("title must not be blank.");
        }

        try {
            Book Othello = new Book("Othello", null, 450, 350);
        } catch (IllegalArgumentException e) {
            System.out.println("author must not be null.");
        }

        try {
            Book kingLear = new Book("King Lear", Shakespeare, 0, 700);
        } catch (IllegalArgumentException e) {
            System.out.println("price must be > 0.");
        }

        try {
            Book JuliusCaesar = new Book("Julius Caesar", Shakespeare, 400, -100);
        } catch (IllegalArgumentException e) {
            System.out.println("pages must be > 0");
        }

    }
}
