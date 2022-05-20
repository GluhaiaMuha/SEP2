package shared.transferObj;

public class Register
{
  private String f_name;
  private String l_name;
  private String e_mail;
  private String password;
  private String phone;

  public Register(String f_name, String l_name, String e_mail, String password, String phone)
  {
    this.f_name = f_name;
    this.l_name = l_name;
    this.e_mail = e_mail;
    this.password = password;
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

  public String getE_mail()
  {
    return e_mail;
  }

  public void setE_mail(String e_mail)
  {
    this.e_mail = e_mail;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
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
