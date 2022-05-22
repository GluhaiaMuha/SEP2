package shared.transferObj;

public class Product
{
  private String hash;
  private int amountInStock;

  public Product(String hash, int amountInStock)
  {
    this.hash = hash;
    this.amountInStock = amountInStock;
  }

  public String getHash()
  {
    return hash;
  }

  public int getAmountInStock()
  {
    return amountInStock;
  }

  public void setHash(String hash)
  {
    this.hash = hash;
  }

  public void setAmountInStock(int amountInStock)
  {
    this.amountInStock = amountInStock;
  }
}
