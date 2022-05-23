package server.database.General.Login;

import shared.transferObj.User;

public interface LoginDAO
{
  User readUserLogin(String email, String password);
}
