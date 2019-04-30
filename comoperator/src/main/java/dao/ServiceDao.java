package dao;

import entities.Service;
import org.hibernate.Session;
import utils.HibernateUtils;

import java.io.Serializable;
import java.util.List;

public class ServiceDao {
    public Service get(int id)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Service service = session.get(Service.class, id);
        session.getTransaction().commit();
        session.close();
        return service;
    }

    public List<Service> getAll()
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Service> services = session.createQuery("from Service").getResultList();
        session.getTransaction().commit();
        session.close();
        return services;
    }

    public int add(Service service)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Serializable id = session.save(service);
        session.getTransaction().commit();
        session.close();
        return (Integer) id;
    }

    public void update(Service service)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.update(service);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Service service)
    {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.delete(service);
        session.getTransaction().commit();
        session.close();
    }
}
