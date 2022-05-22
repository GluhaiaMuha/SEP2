package shared.transferObj;

import java.io.Serializable;

public class User implements Serializable
{
  private String e_mail;
  private String password;
  private String user;

  public User(String e_mail, String password, String user)
  {
    this.e_mail = e_mail;
    this.password = password;
    this.user = user;
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

  public String getUser()
  {
    return user;
  }

  public void setUser(String user)
  {
    this.user = user;
  }
}
