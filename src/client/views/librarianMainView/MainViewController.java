package client.views.librarianMainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.loginView.LoginViewModel;

public class MainViewController implements ViewController
{
  private ViewHandler viewHandler;
  private MainViewModel mainViewController;

  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;
    mainViewController = vmf.getMainViewModel();

  }
}
