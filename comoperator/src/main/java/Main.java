import dao.ClientDao;
import dao.ContactDao;
import entities.Client;
import entities.Contact;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.util.List;

public class Main {

    public static void main(final String[] args) throws Exception {
        ContactDao dao = new ContactDao();
        List<Contact> list = dao.getAll();
        for (Contact c : list) {
            System.out.println(c.getClient().getName() + ": " + c.getDescription());
        }
    }
}