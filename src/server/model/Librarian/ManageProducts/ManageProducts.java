package server.model.Librarian.ManageProducts;

public interface ManageProducts
{
  void update(String tableName, String whereClause, Object obj);

  void delete(String tableName, String product_hash);

  void insert(String tableName, Object obj);
}
