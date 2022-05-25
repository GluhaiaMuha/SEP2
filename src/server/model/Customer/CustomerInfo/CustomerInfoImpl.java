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
}
