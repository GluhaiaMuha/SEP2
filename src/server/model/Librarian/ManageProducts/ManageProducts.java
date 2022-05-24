package server.model.Librarian.ManageProducts;

import java.sql.SQLException;
import java.util.List;

public interface ManageProducts
{
  void update(String tableName, String whereClause, Object obj) throws SQLException;
  void delete(String tableName, String whereClause) throws SQLException;
  Object insert(String tableName, Object obj) throws SQLException;
}
