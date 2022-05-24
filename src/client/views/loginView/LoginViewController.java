package client.views.loginView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import shared.transferObj.User;

import javax.swing.*;
import java.sql.SQLException;

public class LoginViewController implements ViewController
{
  @FXML
  private TextField emailInput;

  @FXML
  private PasswordField passwordInput;

  private ViewHandler viewHandler;
  private LoginViewModel loginViewModel;

  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;
    loginViewModel = vmf.getLoginViewModel();
    emailInput.textProperty().bindBidirectional(vmf.getLoginViewModel().emailProperty());
    passwordInput.textProperty().bindBidirectional(vmf.getLoginViewModel().passwordProperty());
  }

  @FXML
  void onLoginAction(ActionEvent event)
  {
    try
    {
      if (validUserInformation())
      {
        String email = emailInput.getText();
        String password = passwordInput.getText();
        User received = loginViewModel.readUserLogin(email, password);
        if (received != null)
        {
          if (received.getUser().equals("librarian"))
            viewHandler.openLibrarianMainView();
          else if (received.getUser().equals("customer"))
            viewHandler.openCustomerMainView();
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
    if(emailInput.getText().isEmpty() || passwordInput.getText().isEmpty())
    {
      JOptionPane.showMessageDialog(null,"Please fill in all fields");
      return false;
    }
    return true;
  }

  @FXML
  void onRegister(ActionEvent event) {
    viewHandler.openRegisterView();
  }

  private void clearTextFields()
  {
    emailInput.clear();
    passwordInput.clear();
  }
 }


