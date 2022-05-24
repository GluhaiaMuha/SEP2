package server.database.Librarian.ManageProducts;

import java.sql.SQLException;
import java.util.List;

public interface ManageProductsDAO
{
  //Insert update delete
  void update(String tableName, String whereClause, Object obj);

  void delete(String tableName, String whereClause);

  Object insert(String tableName, Object obj);



}
