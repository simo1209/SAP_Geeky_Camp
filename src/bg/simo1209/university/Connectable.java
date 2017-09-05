package bg.simo1209.university;

import java.sql.Connection;

public abstract class Connectable {
    protected static Connection connection;

    public static void setConnection(Connection c){
        connection=c;
    }
}
