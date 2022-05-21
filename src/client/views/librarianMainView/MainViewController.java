package client.views.librarianMainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import server.database.DatabaseInterface;
import server.database.DatabaseManager;
import shared.transferObj.Book;
import shared.transferObj.CD;
import shared.transferObj.Movie;
import shared.transferObj.Software;

import java.sql.SQLException;

public class MainViewController implements ViewController
{
  private ViewHandler viewHandler;
  private MainViewModel mainViewController;
  private DatabaseInterface createTableExample = new DatabaseManager();

  /* Movie Table Start Here */

  @FXML
  private TableView<Object> movieTable;
  @FXML
  private TableColumn<Movie, Integer> movieHashCol;
  @FXML
  private TableColumn<Movie, String> movieDirectorCol;
  @FXML
  private TableColumn<Movie, Integer> movieLength;
  @FXML
  private TableColumn<Movie, String> movieTitleCol;
  @FXML
  private TableColumn<Movie, Integer> movieYearCol;
  @FXML
  private TableColumn<Movie, Integer> movieAmountInStock;

  /* Manage Movie Fields Starts Here */
  @FXML
  private TextField movieTitleField;
  @FXML
  private TextField movieDirectorField;
  @FXML
  private TextField movieReleaseYearField;
  @FXML
  private TextField movieLengthField;
  @FXML
  private TextField movieAmountInStockField;

  /* Books Table Starts Here */

  @FXML
  private TableView<Object> booksTable;

  @FXML
  private TableColumn<Book, String> booksHashCol;
  @FXML
  private TableColumn<Book, String> booksAuthorCol;
  @FXML
  private TableColumn<Book, String> booksTitleCol;
  @FXML
  private TableColumn<Book, Integer> booksPageCountCol;
  @FXML
  private TableColumn<Book, String> booksGenreCol;
  @FXML
  private TableColumn<Book, Integer> booksYearCol;
  @FXML
  private TableColumn<Book, Integer> booksAmountInStockCol;

  /* Movie Text Fields Start Here */
  @FXML
  private TextField booksTitleField;
  @FXML
  private TextField booksAuthorField;
  @FXML
  private TextField booksPgCountField;
  @FXML
  private TextField booksGenreField;
  @FXML
  private TextField booksPublicationYearField;
  @FXML
  private TextField booksAmountInStockField;

  /* CD Table Starts Here */

  @FXML
  private TableView<Object> cdTable;

  @FXML
  private TableColumn<CD, String> cdHashCol;
  @FXML
  private TableColumn<CD, String> cdNameCol;
  @FXML
  private TableColumn<CD, Integer> cdCapacityCol;
  @FXML
  private TableColumn<CD, String> cdUsageCol;
  @FXML
  private TableColumn<CD, Integer> cdAmountInStockCol;

  /* CD Text Fields Start Here */
  @FXML
  private TextField cdNameField;
  @FXML
  private TextField cdCapacityField;
  @FXML
  private TextField cdUsageField;
  @FXML
  private TextField cdAmountInStockField;

  /* Software Table Starts Here */

  @FXML
  private TableView<Object> softwareTable;

  @FXML
  private TableColumn<Software, String> softwareHashCol;
  @FXML
  private TableColumn<Software, String> softwareNameCol;
  @FXML
  private TableColumn<Software, String> softwareTypeCol;
  @FXML
  private TableColumn<Software, Double> softwareVersionCol;
  @FXML
  private TableColumn<Software, String> softwareLicenseTypeCol;
  @FXML
  private TableColumn<Software, String> softwareAmountInStockCol;

  /* Software Text Fields Start Here */
  @FXML
  private TextField softwareNameField;
  @FXML
  private TextField softwareTypeField;
  @FXML
  private TextField softwareVersionField;
  @FXML
  private TextField softwareLicenseTypeField;
  @FXML
  private TextField softwareAmountInStockField;

  /**
   * Initializes the Controller
   * @param vh View Handler
   * @param vmf ViewModelFactory
   * @throws SQLException Possible exception if the database is not found
   */
  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf) throws SQLException
  {
    this.viewHandler = vh;
    mainViewController = vmf.getMainViewModel();
    updateTables();
  }

  /**
   * ActionEvent for adding a movie after pressing a button in a Scene
   *
   * @param event
   * @throws SQLException
   */
  /* Movie Action Events Start Here */
  @FXML
  void onAddMovie(ActionEvent event) throws SQLException
  {
    String title = movieTitleField.getText();
    String director = movieDirectorField.getText();
    int release_year = Integer.parseInt(movieReleaseYearField.getText());
    int length = Integer.parseInt(movieLengthField.getText());
    int amountInStock = Integer.parseInt(movieAmountInStockField.getText());
    String hash = String.valueOf(title.hashCode());

    Movie movie = new Movie(hash,title,director,release_year,length,amountInStock);
    createTableExample.insert("movie", movie);
    updateTables();
    clearTextFields("movie");
  }

  /**
   * ActionEvent for removing a movie after pressing a button in a Scene
   *
   * @param event
   * @throws SQLException
   */
  @FXML
  void onRemoveMovie(ActionEvent event) throws SQLException
  {
    Movie selectedMovie = (Movie) movieTable.getSelectionModel().getSelectedItem();
    if (selectedMovie.getAmountInStock() == 1){
      movieTable.getItems().remove(selectedMovie);
      createTableExample.delete("movie","hash = '" + selectedMovie.getHash() + "'");
      updateTables();
    }else if (selectedMovie.getAmountInStock() > 0){
      selectedMovie.setAmountInStock(selectedMovie.getAmountInStock() - 1);
      createTableExample.update("movie", "hash = '" +selectedMovie.getHash() + "'", selectedMovie);
      updateTables();
    }
  }






  /**
   * ActionEvent for adding a book after pressing a button in a Scene
   *
   * @param event
   * @throws SQLException
   */
  /* Book Action Events Start Here */
  @FXML
  void onAddBook(ActionEvent event) throws SQLException
  {
    String title = booksTitleField.getText();
    String author = booksAuthorField.getText();
    int pageCount = Integer.parseInt(booksPgCountField.getText());
    String genre = booksGenreField.getText();
    int publicationYear = Integer.parseInt(booksPublicationYearField.getText());
    int amountInStock = Integer.parseInt(booksAmountInStockField.getText());
    String hash = String.valueOf(title.hashCode());

    Book book = new Book(hash,title,author,pageCount,genre,publicationYear,amountInStock);
    createTableExample.insert("book", book);
    updateTables();
    clearTextFields("book");
  }

  /**
   * ActionEvent for removing a book after pressing a button in a Scene
   *
   * @param event
   * @throws SQLException
   */
  @FXML
  void onRemoveBook(ActionEvent event) throws SQLException
  {
    Book selectedBook = (Book) booksTable.getSelectionModel().getSelectedItem();
    if (selectedBook.getAmountInStock() == 1){
      booksTable.getItems().remove(selectedBook);
      createTableExample.delete("book", "hash = '" + selectedBook.getHash() + "'");
      updateTables();
    }else if (selectedBook.getAmountInStock() > 0){
      selectedBook.setAmountInStock(selectedBook.getAmountInStock() - 1);
      createTableExample.update("book", "hash = '" + selectedBook.getHash() + "'", selectedBook);
      updateTables();
    }
  }








  /* CD Action Events Start Here */

  /**
   * ActionEvent for adding a cd after pressing a button in a Scene
   *
   * @param event
   * @throws SQLException
   */
  @FXML
  void onAddCd(ActionEvent event) throws SQLException
  {
    String name = cdNameField.getText();
    int capacity = Integer.parseInt(cdCapacityField.getText());
    String usage = cdUsageField.getText();
    int amountInStock = Integer.parseInt(cdAmountInStockField.getText());
    String hash = String.valueOf(name.hashCode());

    CD cd = new CD(hash, name, capacity, usage, amountInStock);
    createTableExample.insert("cd", cd);
    updateTables();
    clearTextFields("cd");
  }

  /**
   * ActionEvent for removing a cd after pressing a button in a Scene
   *
   * @param event
   * @throws SQLException
   */
  @FXML
  void onRemoveCd(ActionEvent event) throws SQLException
  {
    CD selectedCd = (CD) cdTable.getSelectionModel().getSelectedItem();
    if (selectedCd.getAmountInStock() == 1){
      cdTable.getItems().remove(selectedCd);
      createTableExample.delete("cd", "hash = '" + selectedCd.getHash() + "'");
      updateTables();
    }else if (selectedCd.getAmountInStock() > 0){
      selectedCd.setAmountInStock(selectedCd.getAmountInStock() - 1);
      createTableExample.update("cd", "hash = '" + selectedCd.getHash() + "'", selectedCd);
      updateTables();
    }
  }








  /* Software Action Events Start Here */

  /**
   * ActionEvent for adding a software after pressing a button in a Scene
   *
   * @param event
   * @throws SQLException
   */
  @FXML
  void onAddSoftware(ActionEvent event) throws SQLException
  {
    String name = softwareNameField.getText();
    String type = softwareTypeField.getText();
    String version = softwareVersionField.getText();
    String licenseType = softwareLicenseTypeField.getText();
    int amountInStock = Integer.parseInt(softwareAmountInStockField.getText());
    String hash = String.valueOf(name.hashCode());

    Software software = new Software(hash, name, type, version, licenseType, amountInStock);
    createTableExample.insert("software", software);
    updateTables();
    clearTextFields("software");
  }

  /**
   * ActionEvent for removing a software after pressing a button in a Scene
   *
   * @param event
   * @throws SQLException
   */
  @FXML
  void onRemoveSoftware(ActionEvent event) throws SQLException
  {
    Software selectedSoftware = (Software) softwareTable.getSelectionModel().getSelectedItem();
    if (selectedSoftware.getAmountInStock() == 1){
      softwareTable.getItems().remove(selectedSoftware);
      createTableExample.delete("software", "hash = '" + selectedSoftware.getHash() + "'");
      updateTables();
    }else if (selectedSoftware.getAmountInStock() > 0){
      selectedSoftware.setAmountInStock(selectedSoftware.getAmountInStock() - 1);
      createTableExample.update("software", "hash = '" + selectedSoftware.getHash() + "'", selectedSoftware);
      updateTables();
    }
  }








  /* Utility Methods Start Here*/

  /**
   * Method for cleaning the textFields each time a product is added
   *
   * @param s product Type
   */
  private void clearTextFields(String s){
    if (s.equals("movie"))
    {
      movieTitleField.setText("");
      movieDirectorField.setText("");
      movieReleaseYearField.setText("");
      movieLengthField.setText("");
      movieAmountInStockField.setText("");
    }else if (s.equals("book")){
      booksTitleField.setText("");
      booksAuthorField.setText("");
      booksPgCountField.setText("");
      booksGenreField.setText("");
      booksPublicationYearField.setText("");
      booksAmountInStockField.setText("");
    }else if (s.equals("cd")){
      cdNameField.setText("");
      cdCapacityField.setText("");
      cdUsageField.setText("");
      cdAmountInStockField.setText("");
    }else if (s.equals("software")){
      softwareNameField.setText("");
      softwareTypeField.setText("");
      softwareVersionField.setText("");
      softwareLicenseTypeField.setText("");
      softwareAmountInStockField.setText("");
    }
  }

  /**
   * Method for updating TableViews and binding each Property to cells
   *
   * @throws SQLException
   */
  private void updateTables() throws SQLException
  {
    /* Movie Table Start Here */
    /* For future use, make sure PropertyValueFactory is the same as the get/set Methods */

    final ObservableList<Object> dataMovie = FXCollections.observableArrayList(createTableExample.read("movie")
    );

    movieHashCol.setCellValueFactory(
        new PropertyValueFactory<>("Hash")
    );
    movieTitleCol.setCellValueFactory(
        new PropertyValueFactory<>("Title")
    );
    movieDirectorCol.setCellValueFactory(
        new PropertyValueFactory<>("Director")
    );
    movieYearCol.setCellValueFactory(
        new PropertyValueFactory<>("Release_year")
    );
    movieLength.setCellValueFactory(
        new PropertyValueFactory<>("Length")
    );
    movieAmountInStock.setCellValueFactory(
        new PropertyValueFactory<>("AmountInStock")
    );

    movieTable.setItems(dataMovie);

    /* Books Table Starts Here */

    final ObservableList<Object> dataBook = FXCollections.observableArrayList(createTableExample.read("book")
    );

    booksHashCol.setCellValueFactory(
        new PropertyValueFactory<>("Hash")
    );
    booksTitleCol.setCellValueFactory(
        new PropertyValueFactory<>("Title")
    );
    booksAuthorCol.setCellValueFactory(
        new PropertyValueFactory<>("Author")
    );
    booksPageCountCol.setCellValueFactory(
        new PropertyValueFactory<>("PageCount")
    );
    booksGenreCol.setCellValueFactory(
        new PropertyValueFactory<>("Genre")
    );
    booksYearCol.setCellValueFactory(
        new PropertyValueFactory<>("Publication_year")
    );
    booksAmountInStockCol.setCellValueFactory(
        new PropertyValueFactory<>("AmountInStock")
    );

    booksTable.setItems(dataBook);

    /* CD Table Starts Here */
    final ObservableList<Object> dataCD = FXCollections.observableArrayList(createTableExample.read("cd")
    );

    cdHashCol.setCellValueFactory(
        new PropertyValueFactory<>("Hash")
    );
    cdNameCol.setCellValueFactory(
        new PropertyValueFactory<>("Name")
    );
    cdCapacityCol.setCellValueFactory(
        new PropertyValueFactory<>("Capacity")
    );
    cdUsageCol.setCellValueFactory(
        new PropertyValueFactory<>("Usage")
    );
    cdAmountInStockCol.setCellValueFactory(
        new PropertyValueFactory<>("AmountInStock")
    );


    cdTable.setItems(dataCD);

    /* Software Table Starts Here */
    final ObservableList<Object> dataSoftware = FXCollections.observableArrayList(createTableExample.read("software")
    );

    softwareHashCol.setCellValueFactory(
        new PropertyValueFactory<>("Hash")
    );
    softwareNameCol.setCellValueFactory(
        new PropertyValueFactory<>("Name")
    );
    softwareTypeCol.setCellValueFactory(
        new PropertyValueFactory<>("Type")
    );
    softwareVersionCol.setCellValueFactory(
        new PropertyValueFactory<>("Version")
    );
    softwareLicenseTypeCol.setCellValueFactory(
        new PropertyValueFactory<>("License_type")
    );
    softwareAmountInStockCol.setCellValueFactory(
        new PropertyValueFactory<>("AmountInStock")
    );

    softwareTable.setItems(dataSoftware);
  }

}
