package shared.transferObj;

import java.io.Serializable;
import java.sql.Date;

public class Rent implements Serializable
{
  private String customer_email;
  private String product_hash;
  private Date dateFrom;
  private Date dateTo;

  public Rent(String customer_email, String product_hash, Date dateFrom, Date dateTo)
  {
    this.customer_email = customer_email;
    this.product_hash = product_hash;
    this.dateFrom = dateFrom;
    this.dateTo = dateTo;
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

  public Date getDateFrom()
  {
    return dateFrom;
  }

  public void setDateFrom(Date dateFrom)
  {
    this.dateFrom = dateFrom;
  }

  public Date getDateTo()
  {
    return dateTo;
  }

  public void setDateTo(Date dateTo)
  {
    this.dateTo = dateTo;
  }
}
