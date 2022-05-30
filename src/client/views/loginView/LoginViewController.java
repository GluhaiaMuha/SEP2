package client.views.loginView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Controller for login.fxml
 */
public class LoginViewController implements ViewController, PropertyChangeListener
{
  @FXML
  private TextField emailInput;

  @FXML
  private PasswordField passwordInput;

  private ViewHandler viewHandler;
  private LoginViewModel loginViewModel;

  /**
   * Method to Initialize the Controller
   *
   * @param vh VieHandler
   * @param vmf ViewModelFactory
   */
  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;
    loginViewModel = vmf.getLoginViewModel();
    emailInput.textProperty().bindBidirectional(vmf.getLoginViewModel().emailProperty());
    passwordInput.textProperty().bindBidirectional(vmf.getLoginViewModel().passwordProperty());
    loginViewModel.addListener("Librarian Login", this);
    loginViewModel.addListener("Customer Login", this);
  }

  /**
   * Action Event for loging In
   */
  @FXML
  void onLoginAction(ActionEvent event)
  {
    loginViewModel.login();
  }

  /**
   * Action Event for registering a user
   */
  @FXML
  void onRegister(ActionEvent event) {
    viewHandler.openRegisterView();
    loginViewModel.clearTextFields();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if(evt.getPropertyName().equals("Librarian Login"))
    {
      viewHandler.openLibrarianMainView();
    }
    else if(evt.getPropertyName().equals("Customer Login"))
    {
      viewHandler.openCustomerMainView();
    }
  }
}


