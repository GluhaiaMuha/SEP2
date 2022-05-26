package shared.transferObj;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable
{
  private String customer_email;
  private String product_hash;
  private String productName;
  private Date update;
  private String review;

  public Review(String customer_email, String product_hash, String productName, Date update, String review)
  {
    this.customer_email = customer_email;
    this.product_hash = product_hash;
    this.productName = productName;
    this.update = update;
    this.review = review;
  }

  public String getCustomer_email()
  {
    return customer_email;
  }

  public void setCustomer_email(String customer_email)
  {
    this.customer_email = customer_email;
  }

  public String getProduct_hash()
  {
    return product_hash;
  }

  public void setProduct_hash(String product_hash)
  {
    this.product_hash = product_hash;
  }

  public String getProductName()
  {
    return productName;
  }

  public void setProductName(String productName)
  {
    this.productName = productName;
  }

  public Date getUpdate()
  {
    return update;
  }

  public void setUpdate(Date update)
  {
    this.update = update;
  }

  public String getReview()
  {
    return review;
  }

  public void setReview(String review)
  {
    this.review = review;
  }
}
