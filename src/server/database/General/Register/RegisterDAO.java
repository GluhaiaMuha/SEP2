package server.database.General.Register;

import shared.transferObj.Customer;
import shared.transferObj.User;

public interface RegisterDAO
{
  User readUserRegister(String email);

  void insertUserRegister(Customer customer);
}
