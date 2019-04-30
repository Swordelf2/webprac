package dao;

import entities.Deposit;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.io.Serializable;
import java.util.List;

public class DepositDao {
    public Deposit get(int id)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Deposit deposit = session.get(Deposit.class, id);
        session.getTransaction().commit();
        session.close();
        return deposit;
    }

    public List<Deposit> getAll()
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Deposit> deposits = session.createQuery("from Deposit").getResultList();
        session.getTransaction().commit();
        session.close();
        return deposits;
    }

    public int add(Deposit deposit)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Serializable id = session.save(deposit);
        session.getTransaction().commit();
        session.close();
        return (Integer) id;
    }

    public void update(Deposit deposit)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.update(deposit);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Deposit deposit)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.delete(deposit);
        session.getTransaction().commit();
        session.close();
    }
}
