package client.views.librarianMainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.loginView.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.TableRow;

import javax.swing.text.TableView;

public class MainViewController implements ViewController
{
  private ViewHandler viewHandler;
  private MainViewModel mainViewController;

  @FXML private TableRow bookTable;

  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;
    //mainViewController = vmf.getMainViewModel();

  }
}
