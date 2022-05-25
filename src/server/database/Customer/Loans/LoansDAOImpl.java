package server.database.Customer.Loans;

import server.database.DatabaseFront;
import shared.transferObj.Rent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoansDAOImpl implements LoansDAO
{
  private static LoansDAO instance = new LoansDAOImpl();

  public LoansDAOImpl()
  {

  }

  public static LoansDAO getInstance()
  {
    return instance;
  }

  public List<Rent> readCustomerRents(String customer_email, String product)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM rent_" + product + " WHERE customer_email = '" + customer_email + "'");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Rent> rents = new ArrayList<>();
      while (resultSet.next())
      {
        String email = resultSet.getString("customer_email");
        String hash = resultSet.getString("product_hash");
        String productName = resultSet.getString("productName");
        Date dateFrom = resultSet.getDate("dateFrom");
        Date dateTo = resultSet.getDate("dateTo");
        Rent rent = new Rent(email, hash, productName, dateFrom, dateTo);
        rents.add(rent);
      }
      return rents;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  public void removeRent(Rent rent, String product)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "DELETE FROM rent_" + product + " WHERE customer_email = '" + rent.getCustomer_email() + "' AND product_hash = '" + rent.getProduct_hash() + "'");
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
