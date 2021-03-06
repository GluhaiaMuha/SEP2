package server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseFront{

    private static DatabaseFront instance;
    public final String URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=\"libraryhorsens\"";
    public final String USER = "postgres";
    public final String PASSWORD = "password"; //@TODO make sure the password is the same for everyone

    private DatabaseFront() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseFront getInstance() {
        if(instance == null) {
            instance = new DatabaseFront();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

}
