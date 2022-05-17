package server.database;



public interface DatabaseInterface{

    void insert(String tableName,String[] fields);

    void update(String tableName, String field, String whereClause);

    void delete(String tableName, String whereClause);

    void startTransaction();

    void endTransaction();
}
