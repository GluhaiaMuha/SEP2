package client.views.rent;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.librarianMainView.MainViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import server.database.DatabaseManager;
import shared.transferObj.Book;
import shared.transferObj.CD;
import shared.transferObj.Movie;
import shared.transferObj.Software;

import java.sql.SQLException;

public class RentViewController implements ViewController {

    private ViewHandler viewHandler;
    private MainViewModel mainViewController;
    private DatabaseManager createTableExample = new DatabaseManager();

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






    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) throws SQLException
    {
        this.viewHandler = vh;
        mainViewController = vmf.getMainViewModel();


        /* Movie Table Start Here */
        /* For future use, make sure PropretyValueFactory is the same as the get/set Methods */

        //TODO: Распеределить по типом даты.
        final ObservableList<Object> data = FXCollections.observableArrayList(createTableExample.read("movie")
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

        movieTable.setItems(data);

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

        //    cdTable.setItems();

        /* Software Table Starts Here */

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
    }


    @FXML
    void onRentBook(ActionEvent event) {

    }

    @FXML
    void onRentCD(ActionEvent event) {

    }

    @FXML
    void onRentMovie(ActionEvent event) {

    }

    @FXML
    void onRentSoftware(ActionEvent event) {

    }

    @FXML
    void onGoToMainPage(ActionEvent event) {
        viewHandler.openCustomerMainView();
    }

}
