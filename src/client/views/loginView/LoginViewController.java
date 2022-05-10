package client.views.loginView;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginViewController{
    private ViewHandler viewHandler;
    private LoginViewModel loginViewModel;

    /**
     * Currently, you can log in only if both username and password are "aaaaa"
     */

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label error;

    public void init(ViewHandler viewHandler, LoginViewModel loginViewModel){
        this.viewHandler = viewHandler;
        this.loginViewModel = loginViewModel;
        loginViewModel.getUsername().bindBidirectional(usernameField.textProperty());
        loginViewModel.getPassword().bindBidirectional(passwordField.textProperty());

    }

    public void onLoginButton(ActionEvent e){
        loginViewModel.onLogin();
    }

}
