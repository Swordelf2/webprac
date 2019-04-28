import entities.Author;
import entities.Book;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(final String[] args) throws Exception {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        Author author = new Author();
        author.setName("Donatello");

        Book book1 = new Book();
        book1.setTitle("Ddd1");
        Book book2 = new Book();
        book2.setTitle("Ddd2");

        book1.setAuthor(author);
        book2.setAuthor(author);

        session.save(author);
        session.save(book1);
        session.save(book2);


        /*
        System.out.println("Author.books size before: " + author.getBooks().size());
        System.out.println("book author before" + (book.getAuthor() == null));
        System.out.println("Author.books size after: " + author.getBooks().size());
        System.out.println("book author after" + (book.getAuthor() == null));
         */

        session.getTransaction().commit();
        session.close();
    }
}