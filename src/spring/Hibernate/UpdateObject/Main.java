package spring.Hibernate.UpdateObject;

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
            //start the transaction
            session.beginTransaction();


            //Get the student from the database
            Student student = session.get(Student.class, 1);

            //output some information
            System.out.println(student.getFirstName() + " " + student.getLastName());

            //update object
            student.setFirstName("Jooo");

            session.createQuery("update spring.Hibernate.UpdateObject.Student set email = 'TheNewEmail@test.com'").executeUpdate();

            //Commit Transaction
            session.getTransaction().commit();

        } catch(Exception e){
            e.printStackTrace();
        } finally{
            factory.close();
        }
    }
}
