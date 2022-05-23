package client.views.registerView;

import client.model.LibraryModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferObj.Customer;
import shared.transferObj.User;

public class RegisterViewModel
{
  private StringProperty fName;
  private StringProperty lName;
  private StringProperty email;
  private StringProperty password;
  private StringProperty phoneNumber;

  private LibraryModel libraryModel;

  public RegisterViewModel(LibraryModel libraryModel)
  {
    fName = new SimpleStringProperty();
    lName = new SimpleStringProperty();
    email = new SimpleStringProperty();
    password = new SimpleStringProperty();
    phoneNumber = new SimpleStringProperty();
    this.libraryModel = libraryModel;
  }

  public User readUserRegister(String email)
  {
    return libraryModel.readUserRegister(email);
  }

  public void newCustomer(Customer customer)
  {
    libraryModel.newCustomer(customer);
  }

  public StringProperty fNameProperty()
  {
    return fName;
  }

  public StringProperty lNameProperty()
  {
    return lName;
  }

  public StringProperty emailProperty()
  {
    return email;
  }

  public StringProperty passwordProperty()
  {
    return password;
  }

  public StringProperty phoneNumberProperty()
  {
    return phoneNumber;
  }
}
