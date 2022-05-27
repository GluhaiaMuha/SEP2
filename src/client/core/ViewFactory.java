package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ViewFactory
{
  private static Map<String, Scene> scenes;
  private static Stage stage;

  static {
    scenes = new HashMap<>();
  }

  public static void init(Stage theStage) {
    stage = theStage;
    createScene("Login");
    createScene("Register");
    createScene("LibrarianMain");
    createScene("CustomerMain");
    createScene("Rent");
    createScene("Loans");
    createScene("Review");
    createScene("CustomerInfoChange");
  }

  private static void createScene(String sceneName) {
    Scene scene = null;
    if (sceneName.equals("Login")) {
      try {
        Parent root = loadFXML("../views/loginView/login.fxml");

        scene = new Scene(root);
        stage.centerOnScreen();

      } catch (IOException | SQLException e) {
        e.printStackTrace();
      }
    } else if (sceneName.equals("Register")) {
      try {
        Parent root = loadFXML("../views/registerView/register.fxml");

        scene = new Scene(root);
        stage.centerOnScreen();

      } catch (IOException | SQLException e) {
        e.printStackTrace();
      }
    } else if (sceneName.equals("CustomerMain")) {
      try {
        Parent root = loadFXML("../views/customerMainView/CustomerMainView.fxml");

        scene = new Scene(root);
        stage.centerOnScreen();

      } catch (IOException | SQLException e) {
        e.printStackTrace();
      }
    } else if (sceneName.equals("Loans")) {
      try {
        Parent root = loadFXML("../views/loans/LoansView.fxml");

        scene = new Scene(root);
        stage.centerOnScreen();

      } catch (IOException | SQLException e) {
        e.printStackTrace();
      }
    } else if (sceneName.equals("Rent")) {
      try {
        Parent root = loadFXML("../views/rent/RentView.fxml");

        scene = new Scene(root);
        stage.centerOnScreen();

      } catch (IOException | SQLException e) {
        e.printStackTrace();
      }
    } else if (sceneName.equals("Review")) {
      try {
        Parent root = loadFXML("../views/review/ReviewView.fxml");

        scene = new Scene(root);
        stage.centerOnScreen();

      } catch (IOException | SQLException e) {
        e.printStackTrace();
      }
    } else if (sceneName.equals("LibrarianMain")) {
      try {


        Parent root = loadFXML("../views/librarianMainView/main.fxml");
        scene = new Scene(root);
        stage.centerOnScreen();

      } catch (IOException | SQLException e) {
        e.printStackTrace();
      }
    }else if (sceneName.equals("CustomerInfoChange"))
    {
      try
      {
        Parent root = loadFXML("../views/customerInfoChangeView/CustomerInfoChangeView.fxml");

        scene = new Scene(root);
        stage.centerOnScreen();

      }
      catch (IOException | SQLException e)
      {
        e.printStackTrace();
      }
    }
      scenes.put(sceneName, scene);
    }

    private static Parent loadFXML(String path) throws IOException, SQLException
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(ViewFactory.class.getResource(path));
      Parent root = loader.load();

      ViewController ctrl = loader.getController();
      ctrl.init(ViewHandler.getInstance(), ViewModelFactory.getInstance());
      return root;
    }

  public static Scene getScene(String sceneName) {
    return scenes.get(sceneName);
  }
}
