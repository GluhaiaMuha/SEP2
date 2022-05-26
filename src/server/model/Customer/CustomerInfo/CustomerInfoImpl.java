package server.model.Customer.CustomerInfo;

import server.database.Customer.CustomerInfo.CustomerInfoDAOImpl;
import shared.transferObj.Customer;

public class CustomerInfoImpl implements CustomerInfo
{
  private static CustomerInfo instance = new CustomerInfoImpl();

  public static CustomerInfo getInstance(){
    return instance;
  }

  @Override
  public Customer readCustomerInfo(String email)
  {
    return CustomerInfoDAOImpl.getInstance().readCustomerInfo(email);
  }

  @Override
  public void changeCustomerInfo(String email,String f_name, String l_name, String phone)
  {
    CustomerInfoDAOImpl.getInstance().changeCustomerInfo(email, f_name, l_name, phone);
  }
}
