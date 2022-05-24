package shared.transferObj;

import java.io.Serializable;

public class Customer extends User implements Serializable
{
  private String f_name;
  private String l_name;
  private String phone;

  public Customer(String e_mail, String f_name, String l_name, String phone, String password, String user)
  {
    super(e_mail, password, user);
    this.f_name = f_name;
    this.l_name = l_name;
    this.phone = phone;
  }

  public String getF_name()
  {
    return f_name;
  }

  public void setF_name(String f_name)
  {
    this.f_name = f_name;
  }

  public String getL_name()
  {
    return l_name;
  }

  public void setL_name(String l_name)
  {
    this.l_name = l_name;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }
}
