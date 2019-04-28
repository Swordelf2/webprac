import org.hibernate.Session;
import utils.HibernateUtils;

public class Main {

    public static void main(final String[] args) throws Exception {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        session.getTransaction().commit();
        session.close();
    }
}