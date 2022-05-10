package client.views.loginView;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
    private Model model;

    private StringProperty username;
    private StringProperty password;

    public LoginViewModel(Model model){
        this.model = model;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
    }

    public void onLogin(){
        model.login(username.getValue(),password.getValue());
    }

    public StringProperty getUsername(){
        return username;
    }

    public StringProperty getPassword(){
        return password;
    }

}
