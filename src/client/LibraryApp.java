package client;

import client.core.ClientFactory;
import client.core.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class LibraryApp extends Application
{
  @Override
  public void start(Stage stage) throws Exception
  {
    ViewHandler.getInstance().start();
  }

  @Override
  public void stop() throws Exception {
    super.stop();
    System.out.println("Exit");
    ClientFactory.getInstance().getClient().unRegisterClient();
    System.exit(0);
  }
}
