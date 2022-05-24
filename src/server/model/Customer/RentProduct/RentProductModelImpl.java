package server.model.Customer.RentProduct;

import server.database.Customer.RentProduct.RentProductDAOImpl;
import shared.transferObj.Rent;

public class RentProductModelImpl implements RentProductModel
{
  private static RentProductModel instance = new RentProductModelImpl();

  public RentProductModelImpl()
  {

  }

  public static RentProductModel getInstance()
  {
    return instance;
  }

  public void rentProduct(Rent rent)
  {
    RentProductDAOImpl.getInstance().rentProduct(rent);
  }
}
