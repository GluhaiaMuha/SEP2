package server.model.Customer.Loans;

import server.database.Customer.Loans.LoansDAOImpl;
import shared.transferObj.Rent;

import java.util.List;

public class LoansModelImpl implements LoansModel
{
  private static LoansModel instance = new LoansModelImpl();

  public LoansModelImpl()
  {

  }

  public static LoansModel getInstance()
  {
    return instance;
  }

  public List<Rent> readCustomerRents(String customer_email, String product)
  {
    return LoansDAOImpl.getInstance().readCustomerRents(customer_email, product);
  }

  public void removeRent(Rent rent, String product)
  {
    LoansDAOImpl.getInstance().removeRent(rent, product);
  }

  public void updateProductAmount(String tableName, String productHash)
  {
    LoansDAOImpl.getInstance().updateProductAmount(tableName, productHash);
  }
}
