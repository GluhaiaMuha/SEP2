package client.views.customerInfoChangeView;

import client.model.LibraryModel;
import client.views.customerMainView.CustomerMainViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferObj.Customer;

import javax.swing.*;

/**
 * View Model for CustomerInfoChangeView Controller
 */
public class CustomerInfoChangeViewModel
{
  private static StringProperty firstNameTextField;
  private static StringProperty lastNameTextField;
  private static StringProperty phoneTextField;

  private static LibraryModel libraryModel;

  public CustomerInfoChangeViewModel(LibraryModel libraryModel)
  {
    firstNameTextField = new SimpleStringProperty();
    lastNameTextField = new SimpleStringProperty();
    phoneTextField = new SimpleStringProperty();
    this.libraryModel = libraryModel;
  }

  /**
   * Method to change Customer Info
   */
  public static void changeInfo()
  {
    if (validCustomerInformation())
    {
      String f_name = firstNameTextField.getValue();
      String l_name = lastNameTextField.getValue();
      String phone = phoneTextField.getValue();
      libraryModel.changeCustomerInfo(libraryModel.getEmail(), f_name, l_name, phone);
      CustomerMainViewModel.customerInfo();
    }
  }

  public static void selectInfo()
  {
    Customer customer = libraryModel.readCustomerInfo(libraryModel.getEmail());
    firstNameTextField.setValue(customer.getF_name());
    lastNameTextField.setValue(customer.getL_name());
    phoneTextField.setValue(customer.getPhone());
  }

  /**
   * Method that checks if the Customer Input is valid
   *
   * @return boolean
   */
  public static boolean validCustomerInformation()
  {
    if (firstNameTextField.getValue().isEmpty() || lastNameTextField.getValue().isEmpty() || phoneTextField.getValue().isEmpty())
    {
      JOptionPane.showMessageDialog(null, "Please fill in all fields");
      return false;
    }
    for(int i=0;i<phoneTextField.getValue().length();i++)
    {
      if(!"0123456789".contains(phoneTextField.getValue().charAt(i)+""))
      {
        JOptionPane.showMessageDialog(null,"Only digits allowed in phone field");
        return false;
      }
    }
    if (phoneTextField.getValue().length() != 8)
    {
      JOptionPane.showMessageDialog(null,"Invalid phone number");
      return false;
    }
    return true;
  }

  public StringProperty firstNameTextFieldProperty()
  {
    return firstNameTextField;
  }

  public StringProperty lastNameTextFieldProperty()
  {
    return lastNameTextField;
  }

  public StringProperty phoneTextFieldProperty()
  {
    return phoneTextField;
  }
}
