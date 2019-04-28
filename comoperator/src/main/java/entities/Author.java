package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<Book>();

    public void addBook(Book book)
    {
        books.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book)
    {
        books.remove(book);
        book.setAuthor(this);
    }

    /* Getters and Setters */
    public int getId() {
        return id;
    }

    public void setId(int authorid) {
        this.id = authorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
