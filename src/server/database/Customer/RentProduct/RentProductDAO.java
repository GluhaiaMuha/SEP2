package server.database.Customer.RentProduct;

import shared.transferObj.Rent;

public interface RentProductDAO
{
  void rentProduct(String product, Rent rent);
}
