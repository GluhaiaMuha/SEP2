package server.model.Customer.RentProduct;

import shared.transferObj.Rent;

public interface RentProductModel
{
  void rentProduct(String product, Rent rent);
}
