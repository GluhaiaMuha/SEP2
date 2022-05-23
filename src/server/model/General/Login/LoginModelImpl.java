package server.model.General.Login;

import server.database.General.Login.LoginDAOImpl;
import shared.transferObj.User;

public class LoginModelImpl implements LoginModel
{
  private static LoginModel instance = new LoginModelImpl();

  public LoginModelImpl()
  {

  }

  public static LoginModel getInstance()
  {
    return instance;
  }

  public User readUserLogin(String email, String password)
  {
    return LoginDAOImpl.getInstance().readUserLogin(email, password);
  }
}
