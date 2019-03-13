package spring.Hibernate.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class HibernateTest {
    public static void main(String[] args){
        String jdbcurl = "jdbc:mysql://localhost:3306/springhibernate?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";

        try{
            System.out.println("Connection to Database...");

            Connection myConn = DriverManager.getConnection(jdbcurl, user, pass);

            System.out.println("Connection successful");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
