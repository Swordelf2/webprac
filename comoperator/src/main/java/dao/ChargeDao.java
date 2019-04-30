package dao;

import entities.Charge;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.io.Serializable;
import java.util.List;

public class ChargeDao {
    public Charge get(int id)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Charge charge = session.get(Charge.class, id);
        session.getTransaction().commit();
        session.close();
        return charge;
    }

    public List<Charge> getAll()
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Charge> charges = session.createQuery("from Charge").getResultList();
        session.getTransaction().commit();
        session.close();
        return charges;
    }

    public int add(Charge charge)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Serializable id = session.save(charge);
        session.getTransaction().commit();
        session.close();
        return (Integer) id;
    }

    public void update(Charge charge)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.update(charge);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Charge charge)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.delete(charge);
        session.getTransaction().commit();
        session.close();
    }
}
