package server.database;

import shared.transferObj.Customer;
import shared.transferObj.User;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface{
    Object insert(String tableName, Object obj) throws SQLException;

    List<Object> read(String tableName) throws SQLException;

    User readUserLogin(String tableName, String email, String password) throws SQLException;

    User readUserRegister(String tableName, String email) throws SQLException;

    void insertUserRegister(Customer customer) throws SQLException;

    public void update(String tableName, String whereClause, Object obj) throws SQLException;

    void delete(String tableName, String whereClause) throws SQLException;
}
