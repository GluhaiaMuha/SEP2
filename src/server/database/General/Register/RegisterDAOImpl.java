package server.database.General.Register;

import server.database.DatabaseFront;
import shared.transferObj.Customer;
import shared.transferObj.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAOImpl implements RegisterDAO
{
  private static RegisterDAO instance = new RegisterDAOImpl();

  public RegisterDAOImpl()
  {

  }

  public static RegisterDAO getInstance()
  {
    return instance;
  }

  @Override
  public User readUserRegister(String email)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT email, password, type FROM users WHERE email = '" + email + "'");
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String e_mail = resultSet.getString("email");
        String user_password = resultSet.getString("password");
        String type = resultSet.getString("type");
        return new User(e_mail, user_password, type);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public void insertUserRegister(Customer customer)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO customer (email, f_name, l_name, phone, password, type) VALUES (?, ?, ?, ?, ?, ?);");
      statement.setString(1, customer.getE_mail());
      statement.setString(2, customer.getF_name());
      statement.setString(3, customer.getL_name());
      statement.setString(4, customer.getPhone());
      statement.setString(5, customer.getPassword());
      statement.setString(6, customer.getUser());
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}

