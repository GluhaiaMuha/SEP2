package client.views;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import java.io.IOException;
import java.sql.SQLException;

public interface ViewController
{
  void init(ViewHandler vh, ViewModelFactory vmf) throws SQLException;
}
