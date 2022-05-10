package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start() throws IOException
  {
    stage = new Stage();
    openLoginView();
  }

  public void openLoginView()
  {
    try
    {
      Parent root = loadFXML("../views/loginView/login.fxml");

      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Log In");
      stage.centerOnScreen();
      stage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void openMainView(){
    try
    {
      Parent root = loadFXML("../views/mainView/main.fxml");

      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Library App");
      stage.centerOnScreen();
      stage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private Parent loadFXML(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(ViewHandler.class.getResource(path));
    Parent root = loader.load();

    ViewController controller = loader.getController();
    controller.init(this, vmf);
    return root;
  }

}
