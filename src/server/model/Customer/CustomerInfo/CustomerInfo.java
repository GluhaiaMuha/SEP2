package server.model.Customer.CustomerInfo;

import shared.transferObj.Customer;

public interface CustomerInfo
{
  Customer readCustomerInfo(String email);
}
