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
  {
    try
    {
      ManageProductsDAOImpl.getInstance().update(tableName, whereClause, obj);
    }catch (SQLException e){
      e.printStackTrace();
    }
  }

  @Override public void delete(String tableName, String whereClause)
  {
    try
    {
      ManageProductsDAOImpl.getInstance().delete(tableName, whereClause);
    }catch (SQLException e){
      e.printStackTrace();
    }
  }

  @Override public Object insert(String tableName, Object obj)
      throws SQLException
  {
    return ManageProductsDAOImpl.getInstance().insert(tableName, obj);
  }
}
