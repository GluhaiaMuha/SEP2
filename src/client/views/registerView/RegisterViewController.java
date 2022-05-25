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

  @FXML
  void onRegister(ActionEvent event)
  {
    registerViewModel.newCustomer();
  }

  @FXML
  void onLogin(ActionEvent event) {
    viewHandler.openLoginView();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if(evt.getPropertyName().equals("Register")) {
      viewHandler.openCustomerMainView();
    }
  }
}
