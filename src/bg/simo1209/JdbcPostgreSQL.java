package bg.simo1209;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Map;

public class JdbcPostgreSQL {
    public static void main(String args[]) {


        Connection c = null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/geeky_camp",
                            "postgres", System.getProperty("pass"));

            /*PreparedStatement statement = c.prepareStatement("INSERT INTO student(firstname, lastname) VALUES (?,?)");
            statement.setString(1,"Georgi");
            statement.setString(2,"Ivanov");*/
            c.createStatement().execute("CREATE TABLE students(id int)");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }



}
