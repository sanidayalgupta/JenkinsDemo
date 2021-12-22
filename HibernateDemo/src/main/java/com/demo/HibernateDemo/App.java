package com.demo.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student obj=new Student();
        
        Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
        
        ServiceRegistry registry=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf=con.buildSessionFactory(registry);
        
        Session session=sf.openSession();
        
        Transaction tx=session.beginTransaction();
        //obj.setEmail("veeru@gmail.com");
        
        //obj.setName("veeru");
        
        //session.save(obj);
        for(int i=1;i<=4;i++) {
        	obj=(Student) session.get(Student.class,i);
        	System.out.println(obj.getId()+" "+obj.getName()+" "+obj.getEmail());
        }
        tx.commit();
        System.out.println("Succesfully Added!!!!!!!!!!!!!!!!!");
    }
}
