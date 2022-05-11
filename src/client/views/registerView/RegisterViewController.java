package client.views.registerView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.loginView.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RegisterViewController implements ViewController
{
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
