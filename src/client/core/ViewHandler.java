package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private static ViewHandler instance = new ViewHandler();

  public static ViewHandler getInstance(){
    return instance;
  }
  private Stage stage;

  private ViewHandler() {
  }

  public void start() {
    stage = new Stage();
    ViewFactory.init(stage);
    openLoginView();
  }

  public void openLoginView() {
    Scene uppercaseScene = ViewFactory.getScene("Login");
    stage.setScene(uppercaseScene);
    stage.show();
  }

  public void openRegisterView() {
    Scene logScene=ViewFactory.getScene("Register");
    stage.setScene(logScene);
    stage.show();
  }

//  public void openLibrarianMainView() {
//    Scene logScene=ViewFactory.getScene("LibrarianMain");
//    stage.setScene(logScene);
//    stage.show();
//  }
}
