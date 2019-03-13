package spring.Hibernate.AnnotationBasic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            //create new student
            Student student = new Student("Jonny", "JonJon", "jonjon@jon.com");

            //start the transaction
            session.beginTransaction();

            //Save the student
            session.save(student);

            //Commit Transaction
            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            factory.close();
        }
    }
}
