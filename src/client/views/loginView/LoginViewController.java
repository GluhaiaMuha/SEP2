package client.views.loginView;

import client.core.ViewHandler;

public class LoginViewController{
    private ViewHandler viewHandler;
    private LoginViewModel loginViewModel;

    public void init(ViewHandler viewHandler, LoginViewModel loginViewModel){
        this.viewHandler = viewHandler;
        this.loginViewModel = loginViewModel;
    }
}
