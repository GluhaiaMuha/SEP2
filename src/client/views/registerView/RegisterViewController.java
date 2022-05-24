package client.views.registerView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import shared.transferObj.Customer;
import shared.transferObj.User;

import javax.swing.*;
import java.sql.SQLException;

public class RegisterViewController implements ViewController
{
  @FXML
  private TextField fName;

  @FXML
  private TextField lName;

  @FXML
  private TextField email;

  @FXML
  private PasswordField password;

  @FXML
  private TextField phoneNumber;

  private ViewHandler viewHandler;
  private RegisterViewModel registerViewModel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;
    registerViewModel = vmf.getRegisterViewModel();
    fName.textProperty().bindBidirectional(vmf.getRegisterViewModel().fNameProperty());
    lName.textProperty().bindBidirectional(vmf.getRegisterViewModel().lNameProperty());
    email.textProperty().bindBidirectional(vmf.getRegisterViewModel().emailProperty());
    password.textProperty().bindBidirectional(vmf.getRegisterViewModel().passwordProperty());
    phoneNumber.textProperty().bindBidirectional(vmf.getRegisterViewModel().phoneNumberProperty());
  }

  @FXML
  void onRegister(ActionEvent event)
  {
    try
    {
      if (validCustomerInformation())
      {
        String customer_fName = fName.getText();
        String customer_lName = lName.getText();
        String customerEmail = email.getText();
        String customerPassword = password.getText();
        String customerPhoneNumber = phoneNumber.getText();
        User received = registerViewModel.readUserRegister(customerEmail);
        if (received == null)
        {
          Customer newCustomer = new Customer(customerEmail, customer_fName, customer_lName, customerPhoneNumber, customerPassword, "customer");
          registerViewModel.newCustomer(newCustomer);
          viewHandler.openCustomerMainView();
        }
        else
        {
          clearTextFields();
          JOptionPane.showMessageDialog(null,"Invalid email");
        }
      }
    }catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,"Please fill in all fields");
    }
  }

  private void clearTextFields()
  {
    fName.clear();
    lName.clear();
    email.clear();
    password.clear();
    phoneNumber.clear();
  }

  public boolean validCustomerInformation()
  {
    if(fName.getText().isEmpty() || lName.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty() || phoneNumber.getText().isEmpty())
    {
      JOptionPane.showMessageDialog(null,"Please fill in all fields");
      return false;
    }
    for(int i=0;i<phoneNumber.getText().length();i++)
    {
      if(!"0123456789".contains(phoneNumber.getText().charAt(i)+""))
      {
        JOptionPane.showMessageDialog(null,"Only digits allowed in phone field");
        return false;
      }
    }
    if (!email.getText().contains("@") || !email.getText().contains("."))
    {
      JOptionPane.showMessageDialog(null,"Invalid email");
      return false;
    }

    return true;
  }

  @FXML
  void onLogin(ActionEvent event) {
    viewHandler.openLoginView();
  }
}
