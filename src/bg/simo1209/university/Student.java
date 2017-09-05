package bg.simo1209.university;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class Student extends Connectable {


    private int id;
    private String first_name;
    private String last_name;
    private Faculty faculty;
    private int credits;
    private Set<Course> courses;


    public Student(int id, String first_name, String last_name, Faculty faculty, Set<Course> courses) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.faculty = faculty;
        this.credits = 0;
        this.courses = courses;
        this.courses.forEach(course -> this.credits+=course.getCredits());
    }

    public Student(int id, String first_name, String last_name, Faculty faculty, int credits) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.faculty = faculty;
        this.credits = credits;
    }

    public Student(String first_name, String last_name, Faculty faculty) {


        this.first_name = first_name;
        this.last_name = last_name;
        this.faculty = faculty;


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO students(student_first_name, student_last_name, student_faculty_id) VALUES (?,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setInt(3, faculty.getId());
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next() && keys != null) {
                this.id = keys.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("student insert exception");
        }

        faculty.addStudent(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
        this.updateProperty("first_name", first_name);
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
        this.updateProperty("last_name", last_name);
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        updateProperty("faculty_id",faculty.getId());
        this.faculty = faculty;
    }


    private <T> void updateProperty(String property, T value) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE students SET student_?=? WHERE student_id=?"
            );
            statement.setString(1, property);
            statement.setString(2, value.toString());
            statement.setInt(3, this.id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("update exception");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    public static Student getById(int id) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM students WHERE student_id=? LIMIT 1;"
        );
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return new Student(
                id,
                resultSet.getString("student_first_name"),
                resultSet.getString("student_last_name"),
                Faculty.getById(resultSet.getInt("student_faculty_id")),
                resultSet.getInt("student_credits")

        );

    }

    public static void deleteStudent(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM students WHERE  student_id=?");
        statement.setInt(1,id);
        statement.executeUpdate();
    }

    public void delete() throws SQLException {
        deleteStudent(this.id);
    }

    public static Set<Student> getAll() throws SQLException {
        Set<Student> students = new HashSet<>();

        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM students");
        while (resultSet.next()){
            students.add(new Student(
                    resultSet.getInt("student_id"),
                    resultSet.getString("student_first_name"),
                    resultSet.getString("student_last_name"),
                    Faculty.getById(resultSet.getInt("student_faculty_id")),
                    resultSet.getInt("student_credits")
            ));
        }
        return students;
    }

    public void joinCourse(Course course) throws SQLException {
        this.courses.add(course);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO students_courses VALUES (?,?)");
        statement.setInt(1,this.id);
        statement.setInt(2,course.getId());

    }

}
