package bg.simo1209.university;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class University extends Connectable{
    private static University ourInstance = new University();

    private Set<Faculty> faculties;
    private Set<Course> courses;

    public static University getInstance() {
        return ourInstance;
    }



    private University() {
        if(this.faculties==null){
            this.faculties=new HashSet<Faculty>();
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM faculties");
                while (resultSet.next()){
                    this.faculties.add(new Faculty(resultSet.getInt("faculty_id"),resultSet.getString("faculty_name")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (courses == null) {
            this.faculties=new HashSet<Faculty>();
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM courses");
                while (resultSet.next()){
                    this.faculties.add(new Faculty(
                            resultSet.getInt("course_id"),
                            resultSet.getString("faculty_name")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
