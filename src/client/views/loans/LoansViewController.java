package client.views.loans;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import server.database.DatabaseManager;
import shared.transferObj.*;

import java.sql.Date;
import java.sql.SQLException;

public class LoansViewController implements ViewController {
    private ViewHandler viewHandler;
    private LoansViewModel loansViewModel;
    private DatabaseManager createTableExample = new DatabaseManager();


    /* Movie Table Start Here */

    @FXML
    private TableView<Rent> movieTable;
    @FXML
    private TableColumn<Rent, String> movieEmailCol;

    @FXML
    private TableColumn<Rent, String> movieTitleCol;
    @FXML
    private TableColumn<Rent, Date> movieDateFromCol;
    @FXML
    private TableColumn<Rent, Date> movieDateToCol;


    /* Books Table Starts Here */

    @FXML
    private TableView<Object> booksTable;
    @FXML
    private TableColumn<Book, String> booksTitleCol;
    @FXML
    private TableColumn<Book, Date> booksDateFromCol;
    @FXML
    private TableColumn<Book, Date> booksDateToCol;

    /* CD Table Starts Here */

    @FXML
    private TableView<Object> cdTable;
    @FXML
    private TableColumn<CD, String> cdNameCol;
    @FXML
    private TableColumn<CD, Date> cdDateFromCol;
    @FXML
    private TableColumn<CD, Date> cdDateToCol;

    /* Software Table Starts Here */

    @FXML
    private TableView<Object> softwareTable;
    @FXML
    private TableColumn<Software, String> softwareNameCol;
    @FXML
    private TableColumn<Software, Date> softwareDateFromCol;
    @FXML
    private TableColumn<Software, Date> softwareDateToCol;








    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf)
    {
        this.viewHandler = vh;
        loansViewModel= vmf.getLoansViewModel();
    }


    @FXML
    void onGoToMainPage(ActionEvent event) {
        viewHandler.openCustomerMainView();
    }

    @FXML
    void onUpdateList(ActionEvent event) throws SQLException
    {
        updateTables();
    }

    private void updateTables()
    {
        /* Movie Table Start Here */
        /* For future use, make sure PropertyValueFactory is the same as the get/set Methods */

        final ObservableList<Rent> dataMovie = FXCollections.observableArrayList(loansViewModel.readCustomerRents(loansViewModel.getEmail(), "movie")
        );

        movieEmailCol.setCellValueFactory(new PropertyValueFactory<>("customer_email"));

        movieTitleCol.setCellValueFactory(new PropertyValueFactory<>("productName"));

        movieDateFromCol.setCellValueFactory(
            new PropertyValueFactory<>("DateFrom")
        );
        movieDateToCol.setCellValueFactory(
            new PropertyValueFactory<>("DateTo")
        );

        movieTable.setItems(dataMovie);

        /* Books Table Starts Here */

        final ObservableList<Object> dataBook = FXCollections.observableArrayList(createTableExample.read("book")
        );

        booksTitleCol.setCellValueFactory(
            new PropertyValueFactory<>("Title")
        );
        booksDateFromCol.setCellValueFactory(
            new PropertyValueFactory<>("DateFrom")
        );
        booksDateToCol.setCellValueFactory(
            new PropertyValueFactory<>("DateTo")
        );

        booksTable.setItems(dataBook);

        /* CD Table Starts Here */
        final ObservableList<Object> dataCD = FXCollections.observableArrayList(createTableExample.read("cd")
        );

        cdNameCol.setCellValueFactory(
            new PropertyValueFactory<>("Name")
        );
        cdDateFromCol.setCellValueFactory(
            new PropertyValueFactory<>("DateFrom")
        );
        cdDateToCol.setCellValueFactory(
            new PropertyValueFactory<>("DateTo")
        );


        cdTable.setItems(dataCD);

        /* Software Table Starts Here */
        final ObservableList<Object> dataSoftware = FXCollections.observableArrayList(createTableExample.read("software")
        );

        softwareNameCol.setCellValueFactory(
            new PropertyValueFactory<>("Name")
        );
        softwareDateFromCol.setCellValueFactory(
            new PropertyValueFactory<>("DateFrom")
        );
        softwareDateToCol.setCellValueFactory(
            new PropertyValueFactory<>("DateTo")
        );

        softwareTable.setItems(dataSoftware);
    }


}
