import dao.ClientDao;
import entities.Client;
import org.hibernate.Session;
import utils.HibernateUtils;

public class Main {

    public static void main(final String[] args) throws Exception {
        ClientDao clientDao = new ClientDao();
        Client client = clientDao.get(1);
        client.setName("Tralivali name");

        clientDao.update(client);
    }
}