package server.database.Customer.RentProduct;

import server.database.DatabaseFront;
import shared.transferObj.Rent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RentProductDAOImpl implements RentProductDAO
{
  private static RentProductDAO instance = new RentProductDAOImpl();

  public RentProductDAOImpl()
  {

  }

  public static RentProductDAO getInstance()
  {
    return instance;
  }

  public void rentProduct(Rent rent)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO rent (customer_email, product_hash, dateFrom, dateTo) VALUES (?, ?, ?, ?)");
      statement.setString(1, rent.getCustomer_email());
      statement.setString(2, rent.getProduct_hash());
      statement.setDate(3, rent.getDateFrom());
      statement.setDate(4, rent.getDateTo());
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
