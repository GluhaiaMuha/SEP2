package server.model.Customer.CustomerInfo;

import shared.transferObj.Customer;

public interface CustomerInfo
{
  Customer readCustomerInfo(String email);

  void changeCustomerInfo(String email,String f_name, String l_name, String phone);
}
