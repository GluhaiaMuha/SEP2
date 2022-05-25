package server.database.Customer.CustomerInfo;

import shared.transferObj.Customer;

public interface CustomerInfoDAO
{
  Customer readCustomerInfo(String email);
}
