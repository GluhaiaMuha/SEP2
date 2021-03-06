package client.views.librarianMainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferObj.*;

import javax.swing.*;
import java.util.List;

public class MainViewController implements ViewController
{
  private ViewHandler viewHandler;
  private MainViewModel mainViewModel;

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


  /* Edit Text Fields Start Here */
  /* Edit Movie */
  @FXML
  private ChoiceBox<String> editMovieChoiceBox = new ChoiceBox<>();
  @FXML
  private TextField editMovieTitle;
  @FXML
  private TextField editMovieDirector;
  @FXML
  private TextField editMovieReleaseYear;
  @FXML
  private TextField editMovieLength;
  @FXML
  private TextField editMovieAmountInStock;
  private String savedMovieTitle;

  /* Edit Book */
  @FXML
  private ChoiceBox<String> editBookChoiceBox = new ChoiceBox<>();
  @FXML
  private TextField editBookTitle;
  @FXML
  private TextField editBookAuthor;
  @FXML
  private TextField editBookPgCount;
  @FXML
  private TextField editBookGenre;
  @FXML
  private TextField editBookPublicationYear;
  @FXML
  private TextField editBookAmountInStock;
  private String savedBookTitle;

  /* Edit CD */
  @FXML
  private ChoiceBox<String> editCdChoiceBox = new ChoiceBox<>();
  @FXML
  private TextField editCdName;
  @FXML
  private TextField editCdCapacity;
  @FXML
  private TextField editCdUsage;
  @FXML
  private TextField editCdAmountInStock;
  private String savedCdName;

  /* Edit Software */
  @FXML
  private ChoiceBox<String>editSoftwareChoiceBox;
  @FXML
  private TextField editSoftwareName;
  @FXML
  private TextField editSoftwareType;
  @FXML
  private TextField editSoftwareVersion;
  @FXML
  private TextField editSoftwareLicenseType;
  @FXML
  private TextField editSoftwareAmountInStock;
  private String savedSoftwareName;

  /* Search */
  @FXML
  private TextField movieSearchField;
  @FXML
  private TextField bookSearchField;
  @FXML
  private TextField cdSearchField;
  @FXML
  private TextField softwareSearchField;

  /**
   * Initializes the Controller
   * @param vh View Handler
   * @param vmf ViewModelFactory
   */
  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;
    mainViewModel = vmf.getMainViewModel();
    updateTables();
    updateChoiceBoxes();
  }

  /**
   * Action Event to open Review View with data available only for Librarian
   */
  @FXML
  void onReviewsButton(ActionEvent event)
  {
    viewHandler.openReviewView();
  }

  /**
   * Action Event to open Rent View with data available only for Librarian
   */
  @FXML
  void onRentsButton(ActionEvent event)
  {
    viewHandler.openLoansView();
  }



  /* Movie Action Events Start Here */

  /**
   * Action Event to add a movie to db/table
   */
  @FXML
  void onAddMovie(ActionEvent event)
  {
    String title = movieTitleField.getText();
    String director = movieDirectorField.getText();
    int release_year = Integer.parseInt(movieReleaseYearField.getText());
    int length = Integer.parseInt(movieLengthField.getText());
    int amountInStock = Integer.parseInt(movieAmountInStockField.getText());
    String hash = String.valueOf(title.hashCode());

    Movie movie = new Movie(hash,title,director,release_year,length,amountInStock);
    Movie movie1 = (Movie) mainViewModel.readProductByHash("movie", movie.getHash());
    if (movie1==null)
    {
      mainViewModel.insert("movie", movie);
      updateTables();
      updateChoiceBoxes();
      clearTextFields("movie");
      updateChoiceBoxes();
    }
    else
      JOptionPane.showMessageDialog(null, "This product already exists!");
  }

  /**
   * Action Event to remove a movie from db/table
   */
  @FXML
  void onRemoveMovie(ActionEvent event)
  {
    Movie selectedMovie = (Movie) movieTable.getSelectionModel().getSelectedItem();
    try
    {
      List<Rent> rents = mainViewModel.readRents("movie");
      boolean productRented = false;
      for (Rent rent : rents)
      {
        if (rent.getProduct_hash().equals(selectedMovie.getHash()))
        {
          productRented = true;
          break;
        }
      }
      if (!productRented)
      {
        movieTable.getItems().remove(selectedMovie);
        mainViewModel.delete("movie", selectedMovie.getHash());
        updateTables();
        updateChoiceBoxes();
      }
      else
        JOptionPane.showMessageDialog(null, "This product is currently rented!");
    } catch (NullPointerException e)
    {
      JOptionPane.showMessageDialog(null, "Product is not selected!");
    }

  }

  /**
   * Action Event to edit a Movie's Object content
   */
  @FXML
  void onEditMovie(ActionEvent event)
  {
    String title = editMovieTitle.getText();
    String director = editMovieDirector.getText();
    int release_year = Integer.parseInt(editMovieReleaseYear.getText());
    int length = Integer.parseInt(editMovieLength.getText());
    int amountInStock = Integer.parseInt(editMovieAmountInStock.getText());
    String hash = String.valueOf(title.hashCode());

    Movie movie = new Movie(hash,title,director,release_year,length,amountInStock);
    mainViewModel.update("movie", "hash = '" + hash + "'",movie);
    updateTables();
    updateChoiceBoxes();
    clearTextFields("editMovie");
  }

  /**
   * Action Event to get the selected Movie from a choiceBox
   */
  @FXML
  void onSelectMovieTitle(ActionEvent event)
  {
    savedMovieTitle = editMovieChoiceBox.getValue();
    if (savedMovieTitle!=null)
    {
      Movie movie = mainViewModel.readMovieByTitle(savedMovieTitle);
      editMovieTitle.setText(movie.getTitle());
      editMovieDirector.setText(movie.getDirector());
      editMovieReleaseYear.setText(Integer.toString(movie.getRelease_year()));
      editMovieLength.setText(Integer.toString(movie.getLength()));
      editMovieAmountInStock.setText(Integer.toString(movie.getAmountInStock()));
    }
    else
      JOptionPane.showMessageDialog(null, "Product is not selected!");
  }

  /**
   * Action Event to search for a movie by name
   */
  @FXML
  void onMovieSearch(ActionEvent event){
    String search = movieSearchField.getText();
    ObservableList<Object> moviesSearched = FXCollections.observableArrayList(mainViewModel.readMoviesByTitle(search));

    movieTable.setItems(moviesSearched);
  }

  /**
   * Action Event to update the Movie Table
   */
  @FXML
  void onMovieReset(ActionEvent event)
  {
    updateTables();
  }



  /* Book Action Events Start Here */

  /**
   * Action Event to add a Book to db/table
   */
  @FXML
  void onAddBook(ActionEvent event)
  {
    String title = booksTitleField.getText();
    String author = booksAuthorField.getText();
    int pageCount = Integer.parseInt(booksPgCountField.getText());
    String genre = booksGenreField.getText();
    int publicationYear = Integer.parseInt(booksPublicationYearField.getText());
    int amountInStock = Integer.parseInt(booksAmountInStockField.getText());
    String hash = String.valueOf(title.hashCode());

    Book book = new Book(hash,title,author,pageCount,genre,publicationYear,amountInStock);
    Book book1 = (Book) mainViewModel.readProductByHash("book", book.getHash());
    if (book1==null)
    {
      mainViewModel.insert("book", book);
      updateTables();
      clearTextFields("book");
      updateChoiceBoxes();
    }
    else
      JOptionPane.showMessageDialog(null, "This product already exists!");
  }

  /**
   * Action Event to remove a Book
   */
  @FXML
  void onRemoveBook(ActionEvent event)
  {
    Book selectedBook = (Book) booksTable.getSelectionModel().getSelectedItem();
    try
    {
      List<Rent> rents = mainViewModel.readRents("book");
      boolean productRented = false;
      for (Rent rent : rents)
      {
        if (rent.getProduct_hash().equals(selectedBook.getHash()))
        {
          productRented = true;
          break;
        }
      }
      if (!productRented)
      {
        booksTable.getItems().remove(selectedBook);
        mainViewModel.delete("book", selectedBook.getHash());
        updateTables();
        updateChoiceBoxes();
      }
      else
        JOptionPane.showMessageDialog(null, "This product is currently rented!");
    } catch (NullPointerException e)
    {
      JOptionPane.showMessageDialog(null, "Product is not selected!");
    }
  }

  /**
   * Action Event to edit a Book Object data
   */
  @FXML
  void onEditBook(ActionEvent event)
  {
    String title = editBookTitle.getText();
    String author = editBookAuthor.getText();
    int pgCount = Integer.parseInt(editBookPgCount.getText());
    String genre = editBookGenre.getText();
    int publicationYear = Integer.parseInt(editBookPublicationYear.getText());
    int amountInStock = Integer.parseInt(editBookAmountInStock.getText());
    String hash = String.valueOf(title.hashCode());

    Book book = new Book(hash, title, author, pgCount, genre, publicationYear, amountInStock);
    mainViewModel.update("book", "hash = '" + hash + "'", book);
    updateTables();
    updateChoiceBoxes();
    clearTextFields("editBook");

  }

  /**
   * Action Event to get the selected Book from the ChoiceBox and insert values in FieldText
   */
  @FXML
  void onSelectBookTitle(ActionEvent event)
  {
    savedBookTitle = editBookChoiceBox.getValue();
    if (savedBookTitle != null)
    {
      Book book = mainViewModel.readBookByTitle(savedBookTitle);
      editBookTitle.setText(book.getTitle());
      editBookAuthor.setText(book.getAuthor());
      editBookPgCount.setText(Integer.toString(book.getPageCount()));
      editBookGenre.setText(book.getGenre());
      editBookPublicationYear.setText(Integer.toString(book.getPublication_year()));
      editBookAmountInStock.setText(Integer.toString(book.getAmountInStock()));
    }
    else
      JOptionPane.showMessageDialog(null, "Product is not selected!");
  }

  /**
   * Action Event to search for a Book
   */
  @FXML
  void onBookSearch(){
    String search = bookSearchField.getText();
    ObservableList<Object> booksSearched = FXCollections.observableArrayList(mainViewModel.readBooksByTitle(search));

    booksTable.setItems(booksSearched);
  }

  /**
   * Action Event to update Book table
   */
  @FXML
  void onBookReset()
  {
    updateTables();
  }





  /* CD Action Events Start Here */

  /**
   * Action Event to add a CD to db and table
   */
  @FXML
  void onAddCd(ActionEvent event)
  {
    String name = cdNameField.getText();
    int capacity = Integer.parseInt(cdCapacityField.getText());
    String usage = cdUsageField.getText();
    int amountInStock = Integer.parseInt(cdAmountInStockField.getText());
    String hash = String.valueOf(name.hashCode());

    CD cd = new CD(hash, name, capacity, usage, amountInStock);
    CD cd1 = (CD) mainViewModel.readProductByHash("cd", cd.getHash());
    if (cd1==null)
    {
      mainViewModel.insert("cd", cd);
      updateTables();
      clearTextFields("cd");
      updateChoiceBoxes();
    }
    else
      JOptionPane.showMessageDialog(null, "This product already exists!");
  }

  /**
   * Action Event to remove a CD from table & db
   */
  @FXML
  void onRemoveCd(ActionEvent event)
  {
    CD selectedCd = (CD) cdTable.getSelectionModel().getSelectedItem();
    try
    {
      List<Rent> rents = mainViewModel.readRents("cd");
      boolean productRented = false;
      for (Rent rent : rents)
      {
        if (rent.getProduct_hash().equals(selectedCd.getHash()))
        {
          productRented = true;
          break;
        }
      }
      if (!productRented)
      {
        cdTable.getItems().remove(selectedCd);
        mainViewModel.delete("cd", selectedCd.getHash());
        updateTables();
        updateChoiceBoxes();
      }
      else
        JOptionPane.showMessageDialog(null, "This product is currently rented!");
    } catch (NullPointerException e)
    {
      JOptionPane.showMessageDialog(null, "Product is not selected!");
    }
  }

  /**
   * Action Event to edit a CD Object values
   */
  @FXML
  void onEditCd(ActionEvent event)
  {
    String name = editCdName.getText();
    int capacity = Integer.parseInt(editCdCapacity.getText());
    String usage = editCdUsage.getText();
    int amountInStock = Integer.parseInt(editCdAmountInStock.getText());
    String hash = Integer.toString(name.hashCode());

    CD cd = new CD(hash,name,capacity,usage,amountInStock);
    mainViewModel.update("cd", "hash = '" + hash + "'", cd);
    updateTables();
    updateChoiceBoxes();
    clearTextFields("editCd");
  }

  /**
   * Action Event to get a CD obj from ChoiceBox and insert values in FieldText
   */
  @FXML
  void onSelectCdName(ActionEvent event)
  {
    savedCdName = editCdChoiceBox.getValue();
    if (savedCdName != null)
    {
      CD cd = mainViewModel.readCDByName(savedCdName);

      editCdName.setText(cd.getName());
      editCdCapacity.setText(Integer.toString(cd.getCapacity()));
      editCdUsage.setText(cd.getUsage());
      editCdAmountInStock.setText(Integer.toString(cd.getAmountInStock()));
    }
    else
      JOptionPane.showMessageDialog(null, "Product is not selected!");
  }

  /**
   * Action Event to search for a CD
   */
  @FXML
  void onSearchCd(ActionEvent event){
    String search = cdSearchField.getText();
    ObservableList<Object> cdSearched = FXCollections.observableArrayList(mainViewModel.readCDsByName(search));

    cdTable.setItems(cdSearched);
  }

  /**
   * Action Event to update CD table
   */
  @FXML
  void onCdReset(ActionEvent event)
  {
    updateTables();
  }






  /* Software Action Events Start Here */

  /**
   * Action Event to add a Software to db & table
   */
  @FXML
  void onAddSoftware(ActionEvent event)
  {
    String name = softwareNameField.getText();
    String type = softwareTypeField.getText();
    String version = softwareVersionField.getText();
    String licenseType = softwareLicenseTypeField.getText();
    int amountInStock = Integer.parseInt(softwareAmountInStockField.getText());
    String hash = String.valueOf(name.hashCode());

    Software software = new Software(hash, name, type, version, licenseType, amountInStock);
    Software software1 = (Software) mainViewModel.readProductByHash("software", software.getHash());
    if (software1==null)
    {
      mainViewModel.insert("software", software);
      updateTables();
      clearTextFields("software");
      updateChoiceBoxes();
    }
    else
      JOptionPane.showMessageDialog(null, "This product already exists!");
  }

  /**
   * Action Event to remove a Software Obj from db & table
   */
  @FXML
  void onRemoveSoftware(ActionEvent event)
  {
    Software selectedSoftware = (Software) softwareTable.getSelectionModel().getSelectedItem();
    try
    {
      List<Rent> rents = mainViewModel.readRents("software");
      boolean productRented = false;
      for (Rent rent : rents)
      {
        if (rent.getProduct_hash().equals(selectedSoftware.getHash()))
        {
          productRented = true;
          break;
        }
      }
      if (!productRented)
      {
        softwareTable.getItems().remove(selectedSoftware);
        mainViewModel.delete("software", selectedSoftware.getHash());
        updateTables();
        updateChoiceBoxes();
      }
      else
        JOptionPane.showMessageDialog(null, "This product is currently rented!");
    } catch (NullPointerException e)
    {
      JOptionPane.showMessageDialog(null, "Product is not selected!");
    }
  }

  /**
   * Action Event to edit a Software Obj value
   */
  @FXML
  void onEditSoftware(ActionEvent event)
  {
    String name = editSoftwareName.getText();
    String type = editSoftwareType.getText();
    String version = editSoftwareVersion.getText();
    String license_type = editSoftwareLicenseType.getText();
    int amountInStock = Integer.parseInt(editSoftwareAmountInStock.getText());
    String hash = Integer.toString(name.hashCode());

    Software software = new Software(hash,name,type,version,license_type,amountInStock);
    mainViewModel.update("software", "hash = '" + hash + "'", software);
    updateTables();
    updateChoiceBoxes();
    clearTextFields("editSoftware");
  }

  /**
   * Action Event to get the selected Software obj from the ChoiceBox
   */
  @FXML
  void onSelectSoftwareName(ActionEvent event)
  {
    savedSoftwareName = editSoftwareChoiceBox.getValue();
    if (savedSoftwareName != null)
    {
      Software software = mainViewModel.readSoftwareByName(savedSoftwareName);

      editSoftwareName.setText(software.getName());
      editSoftwareType.setText(software.getType());
      editSoftwareVersion.setText(software.getVersion());
      editSoftwareLicenseType.setText(software.getLicense_type());
      editSoftwareAmountInStock.setText(Integer.toString(software.getAmountInStock()));
    }
    else
      JOptionPane.showMessageDialog(null, "Product is not selected!");
  }

  /**
   * Action Event to search for a Software in table
   */
  @FXML
  void onSoftwareSearch(ActionEvent event){
    String search = softwareSearchField.getText();
    ObservableList<Object> softwareSearch = FXCollections.observableArrayList(mainViewModel.readSoftwaresByName(search));

    cdTable.setItems(softwareSearch);
  }

  /**
   * Action Event to update Software table
   */
  @FXML
  void onSoftwareReset(ActionEvent event)
  {
    updateTables();
  }




  /* Utility Methods Start Here*/

  /**
   * Action Event to update all ChoiceBoxes with values from table
   */
  private void updateChoiceBoxes()
  {
    List<Movie> movies = mainViewModel.readMovies();
    editMovieChoiceBox.getItems().clear();
    for (int i = 0; i < movies.size(); i++)
    {
      editMovieChoiceBox.getItems().add(movies.get(i).getTitle());
    }

    List<Book> books = mainViewModel.readBooks();
    editBookChoiceBox.getItems().clear();
    for (int i = 0; i < books.size(); i++)
    {
      editBookChoiceBox.getItems().add(books.get(i).getTitle());
    }

    List<CD> cds = mainViewModel.readCDS();
    editCdChoiceBox.getItems().clear();
    for (int i = 0; i < cds.size(); i++)
    {
      editCdChoiceBox.getItems().add(cds.get(i).getName());
    }

    List<Software> software = mainViewModel.readSoftwares();
    editSoftwareChoiceBox.getItems().clear();
    for (int i = 0; i < software.size(); i++)
    {
      editSoftwareChoiceBox.getItems().add(software.get(i).getName());
    }
  }

  /**
   * Method for cleaning the textFields each time a product is added/edited
   *
   * @param s product Type
   */
  private void clearTextFields(String s){
    switch (s)
    {
      case "movie":
        movieTitleField.setText("");
        movieDirectorField.setText("");
        movieReleaseYearField.setText("");
        movieLengthField.setText("");
        movieAmountInStockField.setText("");
        break;
      case "book":
        booksTitleField.setText("");
        booksAuthorField.setText("");
        booksPgCountField.setText("");
        booksGenreField.setText("");
        booksPublicationYearField.setText("");
        booksAmountInStockField.setText("");
        break;
      case "cd":
        cdNameField.setText("");
        cdCapacityField.setText("");
        cdUsageField.setText("");
        cdAmountInStockField.setText("");
        break;
      case "software":
        softwareNameField.setText("");
        softwareTypeField.setText("");
        softwareVersionField.setText("");
        softwareLicenseTypeField.setText("");
        softwareAmountInStockField.setText("");
        break;
      case "editMovie":
        editMovieTitle.setText("");
        editMovieDirector.setText("");
        editMovieReleaseYear.setText("");
        editMovieLength.setText("");
        editMovieAmountInStock.setText("");
        break;
      case "editBook":
        editBookTitle.setText("");
        editBookAuthor.setText("");
        editBookPgCount.setText("");
        editBookGenre.setText("");
        editBookPgCount.setText("");
        editBookAmountInStock.setText("");
        editBookPublicationYear.setText("");
        break;
      case "editCd":
        editCdName.setText("");
        editCdCapacity.setText("");
        editCdUsage.setText("");
        editCdAmountInStock.setText("");
        break;
      case "editSoftware":
        editSoftwareName.setText("");
        editSoftwareType.setText("");
        editSoftwareVersion.setText("");
        editSoftwareLicenseType.setText("");
        editSoftwareAmountInStock.setText("");
    }
  }

  /**
   * Method for populating/updating data into the table from db
   */
  private void updateTables()
  {
    /* Movie Table Start Here */
    /* For future use, make sure PropertyValueFactory is the same as the get/set Methods */

    final ObservableList<Object> dataMovie = FXCollections.observableArrayList(mainViewModel.readMovies());

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

    final ObservableList<Object> dataBook = FXCollections.observableArrayList(mainViewModel.read("book")
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
    final ObservableList<Object> dataCD = FXCollections.observableArrayList(mainViewModel.read("cd")
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
    final ObservableList<Object> dataSoftware = FXCollections.observableArrayList(mainViewModel.read("software")
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
