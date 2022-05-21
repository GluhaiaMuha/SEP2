package client.views.registerView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.loginView.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import server.database.DatabaseManager;
import shared.transferObj.Customer;
import shared.transferObj.User;

import java.sql.SQLException;

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
  void onRegister(ActionEvent event) throws SQLException
  {
    String customerEmail = email.getText();
    String customerPassword = password.getText();
    String customerPhoneNumber = phoneNumber.getText();
    String customer_fName = fName.getText();
    String customer_sName = sName.getText();
    User received = DatabaseManager.getInstance().readUserRegister("users", customerEmail);
    if (received == null)
    {
      Customer newCustomer = new Customer(customerEmail, customer_fName, customer_sName, customerPhoneNumber, customerPassword, "customer");
      DatabaseManager.getInstance().insertUserRegister(newCustomer);
      viewHandler.openCustomerMainView();
    }
    else
    {
      email.setText("This user already exists");
      password.setText("");
      phoneNumber.setText("");
      fName.setText("");
      sName.setText("");
    }
  }

  @FXML
  void onLogin(ActionEvent event) {
    viewHandler.openLoginView();
  }
}
