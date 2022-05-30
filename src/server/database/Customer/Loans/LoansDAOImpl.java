package server.database.Customer.Loans;

import server.database.DatabaseFront;
import shared.transferObj.Book;
import shared.transferObj.Customer;
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

  public List<Rent> readRents(String product)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM rent_" + product);
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

  public void updateProductAmount(String tableName, String productHash)
  {
      int amount = 0;
      try(Connection connection = DatabaseFront.getInstance().getConnection())
      {
        PreparedStatement statement = connection.prepareStatement(
            "SELECT amountInStock FROM "+ tableName + " WHERE hash = '" + productHash + "'");
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next())
        {
          amount = resultSet.getInt("amountInStock");
        }
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
      try(Connection connection = DatabaseFront.getInstance().getConnection())
      {
        PreparedStatement statement = connection.prepareStatement(
            "UPDATE "+ tableName + " SET amountInStock = ? WHERE hash = '" + productHash + "'");
        statement.setInt(1, amount+1);
        statement.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
}
