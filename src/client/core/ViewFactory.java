package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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
  }

  private static void createScene(String sceneName) {
    Scene scene = null;
    if (sceneName.equals("Login")) {
      try {
        Parent root = loadFXML("../views/loginView/login.fxml");

        scene = new Scene(root);
        stage.setTitle("Log In");
        stage.centerOnScreen();

      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (sceneName.equals("Register")) {
      try {
        Parent root = loadFXML("../views/registerView/register.fxml");

        scene = new Scene(root);
        stage.setTitle("Sign Up");
        stage.centerOnScreen();

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    else if (sceneName.equals("LibrarianMain")) {
      try {
        Parent root = loadFXML("../views/librarianMainView/main.fxml");

        scene = new Scene(root);
        stage.setTitle("Library App");
        stage.centerOnScreen();

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    scenes.put(sceneName, scene);
  }

  private static Parent loadFXML(String path) throws IOException {
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
