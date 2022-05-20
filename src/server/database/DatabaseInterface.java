package server.database;

import shared.transferObj.Login;
import shared.transferObj.Register;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface{
    Object insert(String tableName, Object obj) throws SQLException;

    List<Object> read(String tableName) throws SQLException;

    Login readUserLogin(String tableName, Login login) throws SQLException;

    Register readUserRegister(Register register) throws SQLException;

    void insertUserRegister(Register register) throws SQLException;

    public void update(String tableName, String whereClause, Object obj) throws SQLException;

    void delete(String tableName, String whereClause) throws SQLException;
}
