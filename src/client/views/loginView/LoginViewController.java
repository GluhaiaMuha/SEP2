package client.views.loginView;

import client.views.ViewController;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
  }

  @FXML
  void onLoginAction(ActionEvent event) {

  }

  @FXML
  void onRegister(ActionEvent event) {
    viewHandler.openRegisterView();
  }
 }


