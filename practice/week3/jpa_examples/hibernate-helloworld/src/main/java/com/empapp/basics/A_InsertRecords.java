package com.empapp.basics;

import com.util.factory.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class A_InsertRecords {
    public static void main(String[] args) {
        //hello world of hibernate
        // Obtain sessionfactory
        SessionFactory sessionFactory= SessionFactoryUtil.getSessionFactory();

        // Create session object from sessionfactory
        Session session=sessionFactory.openSession();

        // Create employee object
        Employee emp1=new Employee("Ravi",5000,"IT");
        Employee emp2=new Employee("Rohit",6000,"HR");
        Employee emp3=new Employee("Vijay",7000,"IT");

        //Transaction creation
        Transaction tx=session.getTransaction();
        try{
            tx.begin();
            //save the object
            session.persist(emp1);
            session.persist(emp2);
            session.persist(emp3);
            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        session.close();
        sessionFactory.close();
    }
}
