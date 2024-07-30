import java.util.*;
class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagement {

    public static Book linearSearch(Book[] books, String target) {
        for (Book book : books) {
            if (book.title.equals(target)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String target) {
        int left = 0;
        int right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (books[mid].title.equals(target)) {
                return books[mid];
            } else if (books[mid].title.compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Catcher in the Rye", "J.D. Salinger"),
            new Book(2, "To Kill a Mockingbird", "Harper Lee"),
            new Book(3, "1984", "George Orwell")
        };

        // Sort books for binary search
        Arrays.sort(books, Comparator.comparing(b -> b.title));

        System.out.println(linearSearch(books, "1984"));
        System.out.println(binarySearch(books, "1984"));
    }
}
