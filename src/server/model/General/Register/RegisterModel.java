package server.model.General.Register;

import shared.transferObj.Customer;
import shared.transferObj.User;

public interface RegisterModel
{
  User readUserRegister(String email);

  void newCustomer(Customer customer);
}
