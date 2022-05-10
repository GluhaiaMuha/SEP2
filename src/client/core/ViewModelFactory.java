package client.core;

import client.views.loginView.LoginViewModel;
import org.postgresql.copy.CopyDual;
import org.postgresql.core.v3.CopyDualImpl;

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
