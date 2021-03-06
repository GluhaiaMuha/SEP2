package server.database.Customer.CustomerInfo;

import server.database.DatabaseFront;
import shared.transferObj.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerInfoDAOImpl implements CustomerInfoDAO
{
  private static CustomerInfoDAO instance = new CustomerInfoDAOImpl();

  public static CustomerInfoDAO getInstance()
  {
    return instance;
  }

  @Override
  public Customer readCustomerInfo(String email)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM customer WHERE email = '" + email + "'");
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String e_mail = resultSet.getString("email");
        String password = resultSet.getString("password");
        String type = resultSet.getString("type");
        String fName = resultSet.getString("f_name");
        String lName = resultSet.getString("l_name");
        String phone = resultSet.getString("phone");
        return new Customer(e_mail, fName, lName, phone, password, type);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  public void changeCustomerInfo(String email,String f_name, String l_name, String phone)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE customer SET f_name = ?, l_name = ?, phone = ? WHERE email = '" + email + "'");
      statement.setString(1, f_name);
      statement.setString(2, l_name);
      statement.setString(3, phone);
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
