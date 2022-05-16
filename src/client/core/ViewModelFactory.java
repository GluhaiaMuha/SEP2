package client.core;

import client.views.loginView.LoginViewModel;
import client.views.registerView.RegisterViewModel;

public class ViewModelFactory
{
  private static ViewModelFactory instance=new ViewModelFactory();

  public static ViewModelFactory getInstance(){
    return instance;
  }

  private LoginViewModel logInViewModel;
  private RegisterViewModel registerViewModel;

  public ViewModelFactory() {
  }

  public LoginViewModel getLoginViewModel()
  {
    if (logInViewModel == null)
    {
      logInViewModel = new LoginViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return logInViewModel;
  }

  public RegisterViewModel getRegisterViewModel(){
    if (registerViewModel == null){
      registerViewModel = new RegisterViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return registerViewModel;
  }
}
