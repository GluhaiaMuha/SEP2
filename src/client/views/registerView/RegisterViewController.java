package client.views.registerView;

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
 * Controller Class for Register.fxml
 */
public class RegisterViewController implements ViewController, PropertyChangeListener
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

  /**
   * Method to Initialize the Controller Class
   *
   * @param vh ViewHandler
   * @param vmf ViewModelFactory
   */
  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;
    registerViewModel = vmf.getRegisterViewModel();
    fName.textProperty().bindBidirectional(vmf.getRegisterViewModel().fNameProperty());
    lName.textProperty().bindBidirectional(vmf.getRegisterViewModel().lNameProperty());
    email.textProperty().bindBidirectional(vmf.getRegisterViewModel().emailProperty());
    password.textProperty().bindBidirectional(vmf.getRegisterViewModel().passwordProperty());
    phoneNumber.textProperty().bindBidirectional(vmf.getRegisterViewModel().phoneNumberProperty());
    registerViewModel.addListener("Register",this);
  }

  /**
   * Action Event to register a User
   */
  @FXML
  void onRegister(ActionEvent event)
  {
    registerViewModel.newCustomer();
  }

  /**
   * Action Event to Login as a User
   */
  @FXML
  void onLogin(ActionEvent event) {
    viewHandler.openLoginView();
    registerViewModel.clearTextFields();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if(evt.getPropertyName().equals("Register")) {
      viewHandler.openCustomerMainView();
    }
  }
}
