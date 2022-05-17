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

  public void openLibrarianMainView(){
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

  public void openRegisterView(){
    try
    {
      Parent root = loadFXML("../views/registerView/register.fxml");

      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Sign Up");
      stage.centerOnScreen();
      stage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void openCustomerMainView(){
    try {

      Parent root = loadFXML("../views/customerMainView/CustomerMainView.fxml");

      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Customer Main");
      stage.centerOnScreen();
      stage.show();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void openRentView() {
    try
    {
      Parent root = loadFXML("../views/rent/RentView.fxml");

      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Rent");
      stage.centerOnScreen();
      stage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void openLoansView() {
    try
    {
      Parent root = loadFXML("../views/loans/LoansView.fxml");

      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Loans");
      stage.centerOnScreen();
      stage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void openReviewView() {
    try
    {
      Parent root = loadFXML("../views/review/ReviewView.fxml");

      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Review");
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
