package client.core;

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
    openLibrarianMainView();
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

  public void openLibrarianMainView() {
    Scene logScene=ViewFactory.getScene("LibrarianMain");
    stage.setScene(logScene);
    stage.show();
  }

  public void openRentView() {
    Scene logScene=ViewFactory.getScene("Rent");
    stage.setScene(logScene);
    stage.show();
  }

  public void openLoansView() {
    Scene logScene=ViewFactory.getScene("Loans");
    stage.setScene(logScene);
    stage.show();
  }

  public void openReviewView() {
    Scene logScene=ViewFactory.getScene("Review");
    stage.setScene(logScene);
    stage.show();
  }

  public void openCustomerMainView() {
    Scene logScene=ViewFactory.getScene("CustomerMain");
    stage.setScene(logScene);
    stage.show();
  }
}
