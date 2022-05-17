package server.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager implements DatabaseInterface{

    private final DatabaseFront database = DatabaseFront.getInstance();

    @Override //@TODO make this work for tables where one of the values is "SERIAL" type
    public void insert(String tableName, String[] fields) {
        Connection connection = null;
        String sqlString = "INSERT INTO libraryhorsens." + tableName + " VALUES(DEFAULT,'" + fields + "');";
        try {
            connection = database.getConnection();
        } catch (SQLException e) {
            System.err.println("Error connecting to the database!");
        }
        try {
            PreparedStatement statement = connection.prepareStatement(sqlString);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(String tableName, String field, String whereClause) {

    }

    @Override
    public void delete(String tableName, String whereClause) {
        String sqlString = "DELETE FROM libraryhorsens. " + tableName +" WHERE " + whereClause;
        try {
            Connection connection = database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlString);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startTransaction() {

    }

    @Override
    public void endTransaction() {

    }
}
