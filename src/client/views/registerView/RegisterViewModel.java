package client.views.registerView;

import client.model.LibraryModel;
import client.views.customerMainView.CustomerMainViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferObj.Customer;
import shared.transferObj.User;
import shared.util.Subject;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RegisterViewModel implements Subject
{
  private StringProperty fName;
  private StringProperty lName;
  private StringProperty email;
  private StringProperty password;
  private StringProperty phoneNumber;

  private LibraryModel libraryModel;
  private PropertyChangeSupport support;

  public RegisterViewModel(LibraryModel libraryModel)
  {
    fName = new SimpleStringProperty();
    lName = new SimpleStringProperty();
    email = new SimpleStringProperty();
    password = new SimpleStringProperty();
    phoneNumber = new SimpleStringProperty();
    this.libraryModel = libraryModel;
    support = new PropertyChangeSupport(this);
  }

  public void newCustomer()
  {
    try
    {
      if (validCustomerInformation())
      {
        String customer_fName = fName.getValue();
        String customer_lName = lName.getValue();
        String customerEmail = email.getValue();
        String customerPassword = password.getValue();
        String customerPhoneNumber = phoneNumber.getValue();
        User received = libraryModel.readUserRegister(customerEmail);
        if (received == null)
        {
          Customer newCustomer = new Customer(customerEmail, customer_fName, customer_lName, customerPhoneNumber, customerPassword, "customer");
          libraryModel.newCustomer(newCustomer);
          support.firePropertyChange("Register", null, newCustomer);
          CustomerMainViewModel.customerInfo();
        }
        else
        {
          clearTextFields();
          JOptionPane.showMessageDialog(null,"An account with Email (" + customerEmail + ") already exists!");
        }
      }
    }catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,"Please fill in all fields");
    }
  }

  private void clearTextFields()
  {
    fName.setValue("");
    lName.setValue("");
    email.setValue("");
    password.setValue("");
    phoneNumber.setValue("");
  }

  public boolean validCustomerInformation()
  {
    if(fName.getValue().isEmpty() || lName.getValue().isEmpty() || email.getValue().isEmpty() || password.getValue().isEmpty() || phoneNumber.getValue().isEmpty())
    {
      JOptionPane.showMessageDialog(null,"Please fill in all fields");
      return false;
    }
    for(int i=0;i<phoneNumber.getValue().length();i++)
    {
      if(!"0123456789".contains(phoneNumber.getValue().charAt(i)+""))
      {
        JOptionPane.showMessageDialog(null,"Only digits allowed in phone field");
        return false;
      }
    }
    if (!email.getValue().contains("@") || !email.getValue().contains("."))
    {
      JOptionPane.showMessageDialog(null,"Invalid email");
      return false;
    }

    return true;
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

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName,listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName,listener);
  }
}
