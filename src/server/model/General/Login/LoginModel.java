package server.model.General.Login;

import shared.transferObj.User;

public interface LoginModel
{
  User readUserLogin(String email, String password);
}
