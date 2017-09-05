package bg.simo1209.university;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Course extends Connectable{
    private int id;
    private String name;
    private String desc;
    private int credits;

    public Course(int id, String name, String desc, int credits) throws SQLException {



        this.id = id;
        this.name = name;
        this.desc = desc;
        this.credits = credits;
    }

    public Course(String name, String desc, int credits) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO courses(course_name, course_desc, course_credits) VALUES (?,?,?)"
        , Statement.RETURN_GENERATED_KEYS);




        statement.setString(1,name);
        statement.setString(2,desc);
        statement.setInt(3,credits);

        ResultSet result = statement.executeQuery();
        result.next();

        this.id = result.getInt("course_id");
        this.name = name;
        this.desc = desc;
        this.credits = credits;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }


}
