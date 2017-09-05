package bg.simo1209.university;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
    static Connection connection;

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/geeky_camp","simo09",System.getProperty("pass"));

            University.setConnection(connection);
            Faculty.setConnection(connection);
            Student.setConnection(connection);


            System.out.println(Student.getById(15).getFaculty());

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
}
