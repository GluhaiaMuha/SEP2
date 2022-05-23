package server.model.General.Register;

import server.database.General.Register.RegisterDAOImpl;
import shared.transferObj.Customer;
import shared.transferObj.User;

public class RegisterModelImpl implements RegisterModel
{
  private static RegisterModel instance = new RegisterModelImpl();

  public RegisterModelImpl()
  {

  }

  public static RegisterModel getInstance()
  {
    return instance;
  }

  @Override
  public User readUserRegister(String email)
  {
    return RegisterDAOImpl.getInstance().readUserRegister(email);
  }

  @Override
  public void newCustomer(Customer customer)
  {
    RegisterDAOImpl.getInstance().insertUserRegister(customer);
  }
}
