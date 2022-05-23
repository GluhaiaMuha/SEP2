package client.views.loginView;

import client.model.LibraryModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferObj.User;

public class LoginViewModel
{
  private StringProperty email;
  private StringProperty password;

  private LibraryModel libraryModel;

  public LoginViewModel(LibraryModel libraryModel)
  {
    email = new SimpleStringProperty();
    password = new SimpleStringProperty();
    this.libraryModel = libraryModel;
  }

  public User readUserLogin(String email, String password)
  {
    return libraryModel.readUserLogin(email, password);
  }

  public StringProperty emailProperty()
  {
    return email;
  }

  public StringProperty passwordProperty()
  {
    return password;
  }
}
