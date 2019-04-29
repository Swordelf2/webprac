package dao;

import entities.Client;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.io.Serializable;
import java.util.List;

public class ClientDao {
    public Client get(int id)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.getTransaction().commit();
        session.close();
        return client;
    }

    public List<Client> getAll()
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Client> clients = session.createQuery("from Client").getResultList();
        session.getTransaction().commit();
        session.close();
        return clients;
    }

    public int add(Client client)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Serializable id = session.save(client);
        session.getTransaction().commit();
        session.close();
        return (Integer) id;
    }

    public void update(Client client)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.update(client);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Client client)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.delete(client);
        session.getTransaction().commit();
        session.close();
    }
}
