package client.views.loginView;

import client.model.LibraryModel;
import client.views.customerMainView.CustomerMainViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferObj.User;
import shared.util.Subject;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginViewModel implements Subject
{
  private StringProperty emailInput;
  private StringProperty passwordInput;

  private LibraryModel libraryModel;
  private PropertyChangeSupport support;

  public LoginViewModel(LibraryModel libraryModel)
  {
    emailInput = new SimpleStringProperty();
    passwordInput = new SimpleStringProperty();
    this.libraryModel = libraryModel;
    support = new PropertyChangeSupport(this);
  }

  public void login()
  {
    try
    {
      if (validUserInformation())
      {
        String email = emailInput.getValue();
        String password = passwordInput.getValue();
        User received = libraryModel.readUserLogin(email, password);
        if (received != null)
        {
          if (received.getUser().equals("librarian"))
            support.firePropertyChange("Librarian Login", null, received);
          else if (received.getUser().equals("customer"))
            CustomerMainViewModel.customerInfo();
            support.firePropertyChange("Customer Login", null, received);
        }
        else
        {
          clearTextFields();
          JOptionPane.showMessageDialog(null,"Invalid email or password!");
        }
      }
    }catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,"Please fill in all fields");
    }
  }

  public boolean validUserInformation()
  {
    if(emailInput.getValue().isEmpty() || passwordInput.getValue().isEmpty())
    {
      JOptionPane.showMessageDialog(null,"Please fill in all fields");
      return false;
    }
    return true;
  }

  private void clearTextFields()
  {
    emailInput.setValue("");
    passwordInput.setValue("");
  }

  public StringProperty emailProperty()
  {
    return emailInput;
  }

  public StringProperty passwordProperty()
  {
    return passwordInput;
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
