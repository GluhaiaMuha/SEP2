package server.database.General.Login;

import server.database.DatabaseFront;
import shared.transferObj.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO
{
  private static LoginDAO instance = new LoginDAOImpl();

  public LoginDAOImpl()
  {

  }

  public static LoginDAO getInstance()
  {
    return instance;
  }

  @Override
  public User readUserLogin(String email, String password)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT email, password, type FROM users WHERE email = '" + email + "' AND password = '" + password + "'");
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
}
