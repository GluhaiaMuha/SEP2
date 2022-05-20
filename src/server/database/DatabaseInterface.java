package server.database;

import java.sql.SQLException;

public interface DatabaseInterface{

    void insert(String tableName,String[] fields);

    void update(String tableName, String field, String whereClause);

    void delete(String tableName, String whereClause) throws SQLException;

    void startTransaction();

    void endTransaction();
}
