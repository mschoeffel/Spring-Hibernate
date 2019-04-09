package spring.Hibernate.LazyLoading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main2 {

    public static void main(String[] args){

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //start transaction
            session.beginTransaction();

            //instructor id
            int id = 1;
            //create HQL query
            Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i " +
                            "JOIN FETCH i.courses " +
                            "WHERE i.id = :theInstructorId"
                    , Instructor.class);

            //set parameter on query
            query.setParameter("theInstructorId", id);

            //get the instructor
            Instructor instructor = query.getSingleResult(); //this loads everything at once -> lazy loading session problem solved

            System.out.println("Courses: " + instructor.getCourses()); //Courses will be loaded here when they are requested

            //commit transaction
            session.getTransaction().commit();

        } catch(Exception e){
            e.printStackTrace();
        } finally{
            //close session if exception is thrown
            session.close();

            factory.close();
        }
    }
}
