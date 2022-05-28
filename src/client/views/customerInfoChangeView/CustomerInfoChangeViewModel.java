package client.views.customerInfoChangeView;

import client.model.LibraryModel;
import client.views.customerMainView.CustomerMainViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferObj.Customer;

import javax.swing.*;

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

  public static boolean validCustomerInformation()
  {
    if (firstNameTextField.getValue().isEmpty() || lastNameTextField.getValue().isEmpty() || phoneTextField.getValue().isEmpty())
    {
      JOptionPane.showMessageDialog(null, "Please fill in all fields");
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
