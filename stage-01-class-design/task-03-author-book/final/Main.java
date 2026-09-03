public class Main {
    static void main() {
        Author shakespeare = new Author("William Shakespeare", "England");
        Book hamlet = new Book("Hamlet", shakespeare, 500, 350);
        Book macbeth = new Book("Macbeth", shakespeare, 350, 400);
        boolean result = hamlet.getAuthor() == macbeth.getAuthor();
        System.out.println(result);
        String authorInfo = shakespeare.getAuthorInfo();
        System.out.println(authorInfo);
        String bookInfo = hamlet.getBookInfo();
        String bookInfo2 = macbeth.getBookInfo();
        System.out.println(bookInfo);
        System.out.println(bookInfo2);
        double readingTime = hamlet.calculateReadingTime(10);
        System.out.println(readingTime);

        try {
            Author twain = new Author(null, "USA");
        } catch (IllegalArgumentException e) {
            System.out.println("name must not be null.");
        }

        try {
            Author fitzgerald = new Author("", "USA");
        } catch (IllegalArgumentException e) {
            System.out.println("name must not be blank.");
        }

        try {
            Book book = new Book(null, shakespeare, 200, 200);
        } catch (IllegalArgumentException e) {
            System.out.println("title must not be null.");
        }

        try {
            Book book2 = new Book("", shakespeare, 600, 500);
        } catch (IllegalArgumentException e) {
            System.out.println("title must not be blank.");
        }

        try {
            Book othello = new Book("Othello", null, 450, 350);
        } catch (IllegalArgumentException e) {
            System.out.println("author must not be null.");
        }

        try {
            Book kingLear = new Book("King Lear", shakespeare, 0, 700);
        } catch (IllegalArgumentException e) {
            System.out.println("price must be > 0.");
        }

        try {
            Book juliusCaesar = new Book("Julius Caesar", shakespeare, 400, -100);
        } catch (IllegalArgumentException e) {
            System.out.println("pages must be > 0");
        }

        try {
            hamlet.calculateReadingTime(0);
        } catch (IllegalArgumentException e) {
            System.out.println("pagesPerHour must be > 0");
        }

        try {
            hamlet.calculateReadingTime(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("pagesPerHour must be > 0");
        }

    }
}
