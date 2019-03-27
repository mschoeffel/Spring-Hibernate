package spring.Hibernate.OneToOneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args){

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //start transaction
            session.beginTransaction();

            //get object from DB
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);

            //get the instructor from the bidirectional connection
            Instructor instructor = instructorDetail.getInstructor();

            //print some information
            System.out.println(instructor.getFirstName());

            //commit transaction
            session.getTransaction().commit();

        } catch(Exception e){
            e.printStackTrace();
        } finally{
            factory.close();
        }
    }
}
