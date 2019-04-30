package dao;

import entities.Credit;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.io.Serializable;
import java.util.List;

public class CreditDao {
    public Credit get(int id)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Credit credit = session.get(Credit.class, id);
        session.getTransaction().commit();
        session.close();
        return credit;
    }

    public List<Credit> getAll()
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Credit> credits = session.createQuery("from Credit").getResultList();
        session.getTransaction().commit();
        session.close();
        return credits;
    }

    public int add(Credit credit)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Serializable id = session.save(credit);
        session.getTransaction().commit();
        session.close();
        return (Integer) id;
    }

    public void update(Credit credit)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.update(credit);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Credit credit)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.delete(credit);
        session.getTransaction().commit();
        session.close();
    }
}
