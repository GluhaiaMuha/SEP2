package client.core;

import client.views.loginView.LoginViewModel;

public class ViewModelFactory
{
    private ModelFactory modelFactory;

    public ViewModelFactory(ModelFactory modelFactory){
        this.modelFactory = modelFactory;
    }

    public LoginViewModel getLoginViewModel(){
        return new LoginViewModel(modelFactory.getModel());
    }
}
