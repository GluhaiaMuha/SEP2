package server.model.Librarian.ManageProducts;

import server.database.Librarian.ManageProducts.ManageProductsDAOImpl;

public class ManageProductsImpl implements ManageProducts
{
  private static ManageProducts instance = new ManageProductsImpl();

  public static ManageProducts getInstance(){
    return instance;
  }

  @Override public void update(String tableName, String whereClause, Object obj)
  {
    ManageProductsDAOImpl.getInstance().update(tableName, whereClause, obj);
  }

  @Override public void delete(String tableName, String product_hash)
  {
    ManageProductsDAOImpl.getInstance().delete(tableName, product_hash);
  }

  @Override public void insert(String tableName, Object obj)
  {
    ManageProductsDAOImpl.getInstance().insert(tableName, obj);
  }
}
