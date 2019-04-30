package dao;

import entities.Client;
import entities.Contact;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.io.Serializable;
import java.util.List;

public class ContactDao {
    public Contact get(int id)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Contact contact = session.get(Contact.class, id);
        session.getTransaction().commit();
        session.close();
        return contact;
    }

    public List<Contact> getAll()
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Contact> contacts = session.createQuery("from Contact").getResultList();
        session.getTransaction().commit();
        session.close();
        return contacts;
    }

    public int add(Contact contact)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Serializable id = session.save(contact);
        session.getTransaction().commit();
        session.close();
        return (Integer) id;
    }

    public void update(Contact contact)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.update(contact);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Contact contact)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.delete(contact);
        session.getTransaction().commit();
        session.close();
    }
}
