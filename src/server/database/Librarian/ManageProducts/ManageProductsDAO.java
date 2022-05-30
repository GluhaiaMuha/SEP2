package server.database.Librarian.ManageProducts;

public interface ManageProductsDAO
{
  //Insert update delete
  void update(String tableName, String whereClause, Object obj);

  void delete(String tableName, String product_hash);

  void insert(String tableName, Object obj);
}
