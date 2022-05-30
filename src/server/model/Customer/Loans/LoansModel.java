package server.model.Customer.Loans;

import shared.transferObj.Rent;

import java.util.List;

public interface LoansModel
{
  List<Rent> readCustomerRents(String customer_email, String product);

  List<Rent> readRents(String product);

  void removeRent(Rent rent, String product);

  void updateProductAmount(String tableName, String productHash);
}
