package client.core;

import client.views.loginView.LoginViewModel;

public class ViewModelFactory
{

  private ModelFactory modelFactory;
  private LoginViewModel logInViewModel;

  public ViewModelFactory(ModelFactory modelFactory){
    this.modelFactory=modelFactory;
  }

  public LoginViewModel getLoginViewModel()
  {
    if(logInViewModel==null){
      logInViewModel = new LoginViewModel(modelFactory.getLibraryModel());
    }
    return logInViewModel;
  }

  //TODO: add mainViewModel
}
