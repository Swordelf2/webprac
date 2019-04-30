package dao;

import entities.Activatedservice;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.io.Serializable;
import java.util.List;

public class ActivatedserviceDao {
    public Activatedservice get(int id)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Activatedservice activatedservice = session.get(Activatedservice.class, id);
        session.getTransaction().commit();
        session.close();
        return activatedservice;
    }

    public List<Activatedservice> getAll()
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Activatedservice> activatedservices = session.createQuery("from Activatedservice").getResultList();
        session.getTransaction().commit();
        session.close();
        return activatedservices;
    }

    public int add(Activatedservice activatedservice)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Serializable id = session.save(activatedservice);
        session.getTransaction().commit();
        session.close();
        return (Integer) id;
    }

    public void update(Activatedservice activatedservice)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.update(activatedservice);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Activatedservice activatedservice)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.delete(activatedservice);
        session.getTransaction().commit();
        session.close();
    }
}
