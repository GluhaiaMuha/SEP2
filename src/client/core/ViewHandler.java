package client.core;

import javafx.scene.Scene;
import javafx.stage.Stage;

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
    Scene loginScene = ViewFactory.getScene("Login");
    stage.setScene(loginScene);
    stage.setTitle("Log In");
    stage.setResizable(false);
    stage.show();
  }

  public void openRegisterView() {
    Scene registerScene=ViewFactory.getScene("Register");
    stage.setScene(registerScene);
    stage.setTitle("Sign Up");
    stage.setResizable(false);
    stage.show();
  }

  public void openLibrarianMainView() {
    Scene librarianMainScene=ViewFactory.getScene("LibrarianMain");
    stage.setScene(librarianMainScene);
    stage.setTitle("Library app");
    stage.setResizable(false);
    stage.show();
  }

  public void openRentView() {
    Scene rentScene=ViewFactory.getScene("Rent");
    stage.setScene(rentScene);
    stage.setTitle("Library App Rent ");
    stage.setResizable(false);
    stage.show();
  }

  public void openLoansView() {
    Scene loansScene=ViewFactory.getScene("Loans");
    stage.setScene(loansScene);
    stage.setTitle("Library App Loans");
    stage.setResizable(false);
    stage.show();
  }

  public void openReviewView() {
    Scene reviewScene=ViewFactory.getScene("Review");
    stage.setScene(reviewScene);
    stage.setTitle("Library App Review");
    stage.setResizable(false);
    stage.show();
  }

  public void openCustomerMainView() {
    Scene customerMainScene=ViewFactory.getScene("CustomerMain");
    stage.setScene(customerMainScene);
    stage.setTitle("Library App");
    stage.setResizable(false);
    stage.show();
  }

  public void openCustomerInfoChangeView(){
    Scene reviewScene=ViewFactory.getScene("CustomerInfoChange");
    stage.setScene(reviewScene);
    stage.setTitle("Change Info");
    stage.show();
  }
}
