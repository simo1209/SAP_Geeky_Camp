package bg.simo1209.university;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class Faculty extends Connectable {
    private int id;
    private String name;
    private Set<Student> students;


    //SQL methods

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) throws SQLException {
        int id = student.getId();
        this.removeStudentById(id);
    }

    public void removeStudentById(int id) throws SQLException {
//        (connection.prepareStatement("DELETE FROM students WHERE student_id=?").setInt(1,id));
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students WHERE student_id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        students.remove(id);
    }

    //No-SQL methods


    public Faculty(int id, String name) {
        this.id = id;
        this.name = name;
        this.students = new HashSet<Student>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE student_faculty_id=?");
            statement.setInt(1, this.id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                this.students.add(new Student(
                        result.getInt("student_id"),
                        result.getString("student_first_name"),
                        result.getString("student_last_name"),
                        this,
                        result.getInt("student_credits")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Faculty(String name) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO faculties(faculty_name) VALUES (?)"
                    , Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next() && resultSet != null) {
                this.id = resultSet.getInt(1);
//                System.out.println("hasId");
            }
        } catch (SQLException e) {
            System.out.println("faculty insert exception");
            e.printStackTrace();
        }
        this.name = name;
        this.students = new HashSet<Student>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE student_faculty_id=?");
            statement.setInt(1, this.id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                this.students.add(new Student(
                        result.getInt("student_id"),
                        result.getString("student_first_name"),
                        result.getString("student_last_name"),
                        this,
                        result.getInt("student_credits")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students.toString() +
                '}';
    }

    public static Faculty getById(int id) throws SQLException {

        PreparedStatement statement = connection.prepareStatement("SELECT faculty_name FROM faculties WHERE faculty_id=? LIMIT 1");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        result.next();
        return new Faculty(id, result.getString("faculty_name"));
    }

    public static void deleteFaculty(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM faculties WHERE  faculty_id=?");
        statement.setInt(1, id);
        statement.executeUpdate();
        getById(id).students.forEach(student -> {
            try {
                student.delete();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
