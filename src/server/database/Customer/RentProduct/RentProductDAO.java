package server.database.Customer.RentProduct;

import shared.transferObj.Rent;

import java.sql.Date;

public interface RentProductDAO
{
  void rentProduct(Rent rent);
}
