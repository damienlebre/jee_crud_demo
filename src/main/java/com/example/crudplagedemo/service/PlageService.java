package com.example.crudplagedemo.service;

import com.example.crudplagedemo.models.Plage;
import com.example.crudplagedemo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PlageService {
    public List<Plage> getAll(){
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<Plage> plages = session.createQuery("FROM Plage", Plage.class).getResultList();
        tx.commit();
        session.close();

        return plages;
    }

    public Plage getOne(Long id){
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Plage plage = session.get(Plage.class,id);


        tx.commit();
        session.close();

        return plage;
    }

    public void add(Plage plage){
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.persist(plage);

        tx.commit();
        session.close();
    }

    public Plage update(Plage plage){
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.merge(plage);


        tx.commit();
        session.close();

        return plage;
    }

    public Plage removePLage(Plage plage){
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();

        session.remove(plage);


        tx.commit();
        session.close();

        return plage;
    }

}
