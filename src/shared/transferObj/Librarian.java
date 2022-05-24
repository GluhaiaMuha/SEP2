package shared.transferObj;

import java.io.Serializable;

public class Librarian extends User implements Serializable
{
  public Librarian(String e_mail, String password, String user)
  {
    super(e_mail, password, user);
  }
}
