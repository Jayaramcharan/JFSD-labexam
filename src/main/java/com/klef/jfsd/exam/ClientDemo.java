package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        try {
            // Configure and build SessionFactory
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            
            // Open a session
            Session session = sessionFactory.openSession();
            
            // Begin transaction
            Transaction transaction = session.beginTransaction();

            // Example Update Operation
            String hql = "UPDATE Department SET name = :name, location = :location WHERE departmentId = :id";
            int updated = session.createQuery(hql)
                                 .setParameter("name", "Charan")
                                 .setParameter("location", "Kl University")
                                 .setParameter("id", 1)
                                 .executeUpdate();

            // Commit transaction
            transaction.commit();

            System.out.println(updated + " record(s) updated successfully.");
            
            // Close the session and factory
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
