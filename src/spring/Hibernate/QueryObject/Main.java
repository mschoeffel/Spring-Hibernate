package spring.Hibernate.QueryObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            //create new student
            Student student = new Student("Josef", "JonNoe", "jonnoe@jon.com");

            //start the transaction
            session.beginTransaction();

            //Save the student
            session.save(student);

            //Get the student from the database
            List<Student> students = session.createQuery("FROM spring.Hibernate.QueryObject.Student").getResultList();

            List<Student> students2 = session.createQuery("FROM spring.Hibernate.QueryObject.Student s WHERE s.firstName = 'Josef'").getResultList();

            //output some information
            System.out.println("Results found: " + students.size());

            System.out.println("Results of 2 found: " + students2.size());

            //Commit Transaction
            session.getTransaction().commit();


        } catch(Exception e){
            e.printStackTrace();
        } finally{
            factory.close();
        }
    }
}
