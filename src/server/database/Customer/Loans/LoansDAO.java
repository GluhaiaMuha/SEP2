package server.database.Customer.Loans;

import shared.transferObj.Rent;

import java.util.List;

public interface LoansDAO
{
  List<Rent> readCustomerRents(String customer_email, String product);

  List<Rent> readRents(String product);

  void removeRent(Rent rent, String product);

  void updateProductAmount(String tableName, String productHash);
}
