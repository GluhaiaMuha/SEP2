package client.views.librarianMainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.loginView.LoginViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferObj.Movie;

public class MainViewController implements ViewController
{
  private ViewHandler viewHandler;
  private MainViewModel mainViewController;

  /* Here starts Movie Table */
  @FXML
  private TableView<Movie> movieTable;
  @FXML
  private TableColumn<Movie, String> movieAuthorCol;
  @FXML
  private TableColumn<Movie, String> movieGenreCol;
  @FXML
  private TableColumn<Movie, Integer> moviePgCol;
  @FXML
  private TableColumn<Movie, Integer> movieISBNCol;
  @FXML
  private TableColumn<Movie, String> movieStatusCol; //TODO: Change according to db
  @FXML
  private TableColumn<Movie, String> movieTitleCol;
  @FXML
  private TableColumn<Movie, Integer> movieYearCol;
  @FXML
  private TableColumn<Movie, Integer> movieCount;

  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;
    mainViewController = vmf.getMainViewModel();


    /* Movie Table Start Here */
    /* For future use, make sure PropretyValueFactory is the same as the get/set Methods */

    final ObservableList<Movie> data = FXCollections.observableArrayList(
        new Movie("Harry Potter: 1","J.K Rowling", 2001, 2145, "Fantasy", "Available", 1231,2 ),
        new Movie("Harry Potter: 1","J.K Rowling", 2001, 2145, "Fantasy", "Available", 1231,3 ),
        new Movie("Harry Potter: 1","J.K Rowling", 2001, 2145, "Fantasy", "Available", 1231,4 )
    );

    movieTitleCol.setCellValueFactory(
        new PropertyValueFactory<Movie, String>("Title")
    );
    movieAuthorCol.setCellValueFactory(
        new PropertyValueFactory<Movie, String>("Author")
    );
    movieYearCol.setCellValueFactory(
        new PropertyValueFactory<Movie, Integer>("Year")
    );
    moviePgCol.setCellValueFactory(
        new PropertyValueFactory<Movie, Integer>("pgCount")
    );
    movieGenreCol.setCellValueFactory(
        new PropertyValueFactory<Movie, String>("Genre")
    );
    movieStatusCol.setCellValueFactory(
        new PropertyValueFactory<Movie, String>("Status")
    );
    movieYearCol.setCellValueFactory(
        new PropertyValueFactory<Movie, Integer>("Year")
    );
    movieISBNCol.setCellValueFactory(
        new PropertyValueFactory<Movie, Integer>("ISBN")
    );
    movieCount.setCellValueFactory(
        new PropertyValueFactory<Movie, Integer>("Count")
    );

    movieTable.setItems(data);


  }
}
