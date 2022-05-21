package client.views.loginView;

import client.views.ViewController;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import server.database.DatabaseManager;
import shared.transferObj.User;

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
  }

  @FXML
  void onLoginAction(ActionEvent event) throws SQLException
  {
    String email = emailInput.getText();
    String password = passwordInput.getText();
    User received = DatabaseManager.getInstance().readUserLogin("users", email, password);
    if (received != null)
    {
      if (received.getUser().equals("librarian"))
        viewHandler.openLibrarianMainView();
      else if (received.getUser().equals("customer"))
        viewHandler.openCustomerMainView();
    }
    else
    {
      emailInput.setText("error");
      passwordInput.setText("");
    }
  }

  @FXML
  void onRegister(ActionEvent event) {
    viewHandler.openRegisterView();
  }
 }


