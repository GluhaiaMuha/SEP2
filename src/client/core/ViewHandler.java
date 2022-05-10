package client.core;

import client.views.loginView.LoginViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
    private final Stage stage;
    private final ViewModelFactory vmf;
    private Scene loginScene;

    public ViewHandler(ViewModelFactory vmf){
        this.vmf = vmf;
        stage = new Stage();
    }

    public void start(){
        openLoginView();
    }

    public void openLoginView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/loginView/login.fxml"));
            Parent root = loader.load();

            LoginViewController controller = loader.getController();
            controller.init(this, vmf.getLoginViewModel());

            loginScene = new Scene(root);
            stage.setScene(loginScene);
            stage.setTitle("Log In");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
