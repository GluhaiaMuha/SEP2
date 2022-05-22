package client.views.loans;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import server.database.DatabaseManager;
import shared.transferObj.Book;
import shared.transferObj.CD;
import shared.transferObj.Movie;
import shared.transferObj.Software;

import java.sql.Date;
import java.sql.SQLException;

public class LoansViewController implements ViewController {
    private ViewHandler viewHandler;
    private LoansViewModel loansViewModel;
    private DatabaseManager createTableExample = new DatabaseManager();


    /* Movie Table Start Here */

    @FXML
    private TableView<Object> movieTable;
    @FXML
    private TableColumn<Movie, String> movieTitleCol;
    @FXML
    private TableColumn<Movie, Date> movieDateFromCol;
    @FXML
    private TableColumn<Movie, Date> movieDateToCol;


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
    private TableView<Software> softwareTable;
    @FXML
    private TableColumn<Software, String> softwareNameCol;
    @FXML
    private TableColumn<Software, Date> softwareDateFromCol;
    @FXML
    private TableColumn<Software, Date> softwareDateToCol;








    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
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

    }


}
