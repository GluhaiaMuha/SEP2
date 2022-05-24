package server.model.Librarian.ManageProducts;

public interface ManageProducts
{
  void update(String tableName, String whereClause, Object obj);
  void delete(String tableName, String whereClause);
  Object insert(String tableName, Object obj);
}
