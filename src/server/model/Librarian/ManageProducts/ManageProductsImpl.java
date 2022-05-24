package server.model.Librarian.ManageProducts;

import server.database.Librarian.ManageProducts.ManageProductsDAO;
import server.database.Librarian.ManageProducts.ManageProductsDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class ManageProductsImpl implements ManageProducts
{

  private static ManageProducts instance = new ManageProductsImpl();

  public static ManageProducts getInstance(){
    return instance;
  }

  @Override public void update(String tableName, String whereClause, Object obj)
      throws SQLException
  {
    ManageProductsDAOImpl.getInstance().update(tableName, whereClause, obj);
  }

  @Override public void delete(String tableName, String whereClause)
      throws SQLException
  {
    ManageProductsDAOImpl.getInstance().delete(tableName, whereClause);
  }

  @Override public Object insert(String tableName, Object obj)
      throws SQLException
  {
    return ManageProductsDAOImpl.getInstance().insert(tableName, obj);
  }

  @Override public List<Object> read(String tableName) throws SQLException
  {
    return ManageProductsDAOImpl.getInstance().read(tableName);
  }
}
