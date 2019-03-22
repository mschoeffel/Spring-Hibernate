package spring.Hibernate.OneToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring.Hibernate.QueryObject.Student;

public class Main {

    public static void main(String[] args){

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            //create the objects
            Instructor instructor = new Instructor("Jonny", "JonJon");

            InstructorDetail tempInstructorDetail = new InstructorDetail("'JonnyJon@mail.com", "surfing");

            //associate the objects
            instructor.setInstructorDetail(tempInstructorDetail);

            //start transaction
            session.beginTransaction();

            session.save(instructor);

            //commit transaction
            session.getTransaction().commit();

        } catch(Exception e){
            e.printStackTrace();
        } finally{
            factory.close();
        }
    }
}
