import java.util.ArrayList;

class Book {
    String title;
    String author;
    boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Member {
    String name;
    int memberId;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }
}

class Library {
    ArrayList<Book> books;
    ArrayList<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void borrowBook(Member member, Book book) {
        if (members.contains(member) && books.contains(book) && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Unable to borrow the book. Please check availability and membership.");
        }
    }

    public void returnBook(Member member, Book book) {
        if (members.contains(member) && books.contains(book) && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println(member.getName() + " returned " + book.getTitle());
        } else {
            System.out.println("Unable to return the book. Please check membership and book status.");
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Naruto : The boy with ten tails", "Kishimoto");
        Book book2 = new Book("Mockingbird", "Eminem");

        Member member1 = new Member("Rahul", 1);
        Member member2 = new Member("Deva", 2);

        library.addBook(book1);
        library.addBook(book2);

        library.addMember(member1);
        library.addMember(member2);

        library.borrowBook(member1, book1);
        library.borrowBook(member2, book2);

        library.displayAvailableBooks();

        library.returnBook(member1, book1);

        library.displayAvailableBooks();
    }
}
