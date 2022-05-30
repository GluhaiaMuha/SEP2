package client.views.rent;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferObj.Book;
import shared.transferObj.CD;
import shared.transferObj.Movie;
import shared.transferObj.Software;

/**
 * Controller Class for RentView.fxml
 */
public class RentViewController implements ViewController {

    private ViewHandler viewHandler;
    private RentViewModel rentViewModel;

    /* Movie Table Start Here */

    @FXML
    private TextField movieSearchField;

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

    /* Books Table Starts Here */

    @FXML
    private TextField bookSearchField;

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

    /* CD Table Starts Here */

    @FXML
    private TextField cdSearchField;

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

    /* Software Table Starts Here */

    @FXML
    private TextField softwareSearchField;

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

    /**
     * Method to Initialize the Controller
     *
     * @param vh ViewHandler
     * @param vmf ViewModelFactory
     */
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf)
    {
        this.viewHandler = vh;
        rentViewModel = vmf.getRentViewModel();

        movieSearchField.textProperty().bindBidirectional(rentViewModel.movieSearchFieldProperty());
        bookSearchField.textProperty().bindBidirectional(rentViewModel.bookSearchFieldProperty());
        cdSearchField.textProperty().bindBidirectional(rentViewModel.cdSearchFieldProperty());
        softwareSearchField.textProperty().bindBidirectional(rentViewModel.softwareSearchFieldProperty());

        tables();
        rentViewModel.updateTables();
    }

    /**
     * Action Event to rent a Book
     */
    @FXML
    void onRentBook(ActionEvent event)
    {
        Book selectedBook = (Book) booksTable.getSelectionModel().getSelectedItem();
        rentViewModel.newRent(selectedBook, "book");
        rentViewModel.updateTables();
    }

    /**
     * Action Event to rent a CD
     */
    @FXML
    void onRentCD(ActionEvent event)
    {
        CD selectedCD = (CD) cdTable.getSelectionModel().getSelectedItem();
        rentViewModel.newRent(selectedCD, "cd");
        rentViewModel.updateTables();
    }

    /**
     * Action Event to rent a Movie
     */
    @FXML
    void onRentMovie(ActionEvent event)
    {
        Movie selectedMovie = (Movie) movieTable.getSelectionModel().getSelectedItem();
        rentViewModel.newRent(selectedMovie, "movie");
        rentViewModel.updateTables();
    }

    /**
     * Action Event to rent a Software
     */
    @FXML
    void onRentSoftware(ActionEvent event)
    {
        Software selectedSoftware = (Software) softwareTable.getSelectionModel().getSelectedItem();
        rentViewModel.newRent(selectedSoftware, "software");
        rentViewModel.updateTables();
    }

    /**
     * Action Event to add review for Book
     */
    @FXML
    void onAddBookReview(ActionEvent event)
    {
        Book selectedBook = (Book) booksTable.getSelectionModel().getSelectedItem();
        rentViewModel.newReview(selectedBook, "book");
    }

    /**
     * Action Event to add review for CD
     */
    @FXML
    void onAddCDReview(ActionEvent event)
    {
        CD selectedCD = (CD) cdTable.getSelectionModel().getSelectedItem();
        rentViewModel.newReview(selectedCD, "cd");
    }

    /**
     * Action Event to add review for Movie
     */
    @FXML
    void onAddMovieReview(ActionEvent event)
    {
        Movie selectedMovie = (Movie) movieTable.getSelectionModel().getSelectedItem();
        rentViewModel.newReview(selectedMovie, "movie");
    }

    /**
     * Action Event to add review Software
     */
    @FXML
    void onAddSoftwareReview(ActionEvent event)
    {
        Software selectedSoftware = (Software) softwareTable.getSelectionModel().getSelectedItem();
        rentViewModel.newReview(selectedSoftware, "software");
    }

    /**
     * Action Event to return to Main Page
     */
    @FXML
    void onGoToMainPage(ActionEvent event) {
        viewHandler.openCustomerMainView();
    }

    /**
     * Action Event to update Rent Table
     */
    @FXML
    void onUpdateList(ActionEvent event)
    {
        rentViewModel.updateTables();
        tables();
    }

    /**
     * Action Event to search all movie Rents
     */
    @FXML
    void onMovieSearch(ActionEvent event)
    {
        movieTable.setItems(rentViewModel.searchProducts("movie"));
    }

    /**
     * Action Event to search all Book Rents
     */
    @FXML
    void onBookSearch(ActionEvent event)
    {
        booksTable.setItems(rentViewModel.searchProducts("book"));
    }

    /**
     * Action Event to search all CD Rents
     */
    @FXML
    void onCDSearch(ActionEvent event)
    {
        cdTable.setItems(rentViewModel.searchProducts("cd"));
    }

    /**
     * Action Event to search all Software rents
     */
    @FXML
    void onSoftwareSearch(ActionEvent event)
    {
        softwareTable.setItems(rentViewModel.searchProducts("software"));
    }

    /**
     * Method for binding/updating tables with data
     */
    private void tables()
    {
        movieHashCol.setCellValueFactory(new PropertyValueFactory<>("Hash"));
        movieTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        movieDirectorCol.setCellValueFactory(new PropertyValueFactory<>("Director"));
        movieYearCol.setCellValueFactory(new PropertyValueFactory<>("Release_year"));
        movieLength.setCellValueFactory(new PropertyValueFactory<>("Length"));
        movieAmountInStock.setCellValueFactory(new PropertyValueFactory<>("AmountInStock"));
        movieTable.setItems(rentViewModel.getDataMovie());


        booksHashCol.setCellValueFactory(new PropertyValueFactory<>("Hash"));
        booksTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        booksAuthorCol.setCellValueFactory(new PropertyValueFactory<>("Author"));
        booksPageCountCol.setCellValueFactory(new PropertyValueFactory<>("PageCount"));
        booksGenreCol.setCellValueFactory(new PropertyValueFactory<>("Genre"));
        booksYearCol.setCellValueFactory(new PropertyValueFactory<>("Publication_year"));
        booksAmountInStockCol.setCellValueFactory(new PropertyValueFactory<>("AmountInStock"));
        booksTable.setItems(rentViewModel.getDataBook());


        cdHashCol.setCellValueFactory(new PropertyValueFactory<>("Hash"));
        cdNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        cdCapacityCol.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        cdUsageCol.setCellValueFactory(new PropertyValueFactory<>("Usage"));
        cdAmountInStockCol.setCellValueFactory(new PropertyValueFactory<>("AmountInStock"));
        cdTable.setItems(rentViewModel.getDataCD());


        softwareHashCol.setCellValueFactory(new PropertyValueFactory<>("Hash"));
        softwareNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        softwareTypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        softwareVersionCol.setCellValueFactory(new PropertyValueFactory<>("Version"));
        softwareLicenseTypeCol.setCellValueFactory(new PropertyValueFactory<>("License_type"));
        softwareAmountInStockCol.setCellValueFactory(new PropertyValueFactory<>("AmountInStock"));
        softwareTable.setItems(rentViewModel.getDataSoftware());
    }
}
