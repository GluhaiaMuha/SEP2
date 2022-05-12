package client.views.registerView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.loginView.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterViewController implements ViewController
{
  @FXML
  private TextField email;

  @FXML
  private PasswordField password;

  @FXML
  private TextField phoneNumber;

  @FXML
  private TextField fName;

  @FXML
  private TextField sName;

  private ViewHandler viewHandler;
  private RegisterViewModel registerViewModel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;
    registerViewModel = vmf.getRegisterViewModel();
  }

  @FXML
  void onLogin(ActionEvent event) {
    viewHandler.openLoginView();
  }
}
