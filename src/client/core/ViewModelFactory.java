package client.core;

import client.views.loginView.LoginViewModel;
import client.views.registerView.RegisterViewModel;

public class ViewModelFactory
{

  private ModelFactory modelFactory;
  private LoginViewModel logInViewModel;
  private RegisterViewModel registerViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public LoginViewModel getLoginViewModel()
  {
    if (logInViewModel == null)
    {
      logInViewModel = new LoginViewModel(modelFactory.getLibraryModel());
    }
    return logInViewModel;
  }

  public RegisterViewModel getRegisterViewModel(){
    if (registerViewModel == null){
      registerViewModel = new RegisterViewModel(modelFactory.getLibraryModel());
    }
    return registerViewModel;
  }
}
