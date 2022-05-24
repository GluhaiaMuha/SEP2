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

  public List<Rent> readCustomerRents(String customer_email)
  {
    return LoansDAOImpl.getInstance().readCustomerRents(customer_email);
  }
}
