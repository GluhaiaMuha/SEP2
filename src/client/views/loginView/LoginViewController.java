package client.views.loginView;

import client.views.ViewController;
import client.core.ViewHandler;
import client.core.ViewModelFactory;

public class LoginViewController implements ViewController
{
  private ViewHandler viewHandler;
  private LoginViewModel loginViewModel;

  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;
    loginViewModel = vmf.getLoginViewModel();
  }
}
