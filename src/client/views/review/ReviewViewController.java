package client.views.review;

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
import shared.transferObj.Book;
import shared.transferObj.CD;
import shared.transferObj.Movie;
import shared.transferObj.Software;

import java.sql.Date;
import java.sql.SQLException;

public class ReviewViewController implements ViewController {
    private ViewHandler viewHandler;
    private ReviewViewModel reviewViewModel;
    private DatabaseManager createTableExample = new DatabaseManager();

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) throws SQLException
    {
        this.viewHandler = vh;
        reviewViewModel = vmf.getReviewViewModel();
//        updateTables();
    }


    /* Movie Table Start Here */

    @FXML
    private TableView<Object> movieTable;

    @FXML
    private TableColumn<Movie, String> moviesCustomerEmailCol;
    @FXML
    private TableColumn<Movie, String> moviesTitleCol;
    @FXML
    private TableColumn<Movie, Date> moviesDateCol;
    @FXML
    private TableColumn<Movie, String> moviesReviewCol;

    /* Books Table Starts Here */

    @FXML
    private TableView<Object> booksTable;

    @FXML
    private TableColumn<Book, String> booksCustomerEmailCol;
    @FXML
    private TableColumn<Book, String> booksTitleCol;
    @FXML
    private TableColumn<Book, Date> booksDateCol;
    @FXML
    private TableColumn<Book, String> booksReviewCol;

    /* CD Table Starts Here */

    @FXML
    private TableView<Object> cdTable;

    @FXML
    private TableColumn<CD, String> cdCustomerEmailCol;
    @FXML
    private TableColumn<CD, String> cdNameCol;
    @FXML
    private TableColumn<CD,Date > cdDateCol;
    @FXML
    private TableColumn<CD, String> cdReviewCol;

    /* Software Table Starts Here */

    @FXML
    private TableView<Object> softwareTable;

    @FXML
    private TableColumn<Software, String> softwareCustomerEmailCol;
    @FXML
    private TableColumn<Software, String> softwareNameCol;
    @FXML
    private TableColumn<Software, Date> softwareDateCol;
    @FXML
    private TableColumn<Software, String> softwareReviewCol;



    @FXML
    void onGoToMainPage(ActionEvent event) {
        viewHandler.openCustomerMainView();
    }

    @FXML
    void onUpdateList(ActionEvent event) throws SQLException
    {
        updateTables();
    }

    private void updateTables() throws SQLException
    {
        //* Movie Table Start Here *//*
        //* For future use, make sure PropertyValueFactory is the same as the get/set Methods *//*

        final ObservableList<Object> dataMovie = FXCollections.observableArrayList(createTableExample.read("movie")
        );

        moviesCustomerEmailCol.setCellValueFactory(
            new PropertyValueFactory<>("Customer")
        );
        moviesTitleCol.setCellValueFactory(
            new PropertyValueFactory<>("Title")
        );
        moviesDateCol.setCellValueFactory(
            new PropertyValueFactory<>("Date")
        );
        moviesReviewCol.setCellValueFactory(
            new PropertyValueFactory<>("Review")
        );

        movieTable.setItems(dataMovie);

        //* Books Table Starts Here *//*

        final ObservableList<Object> dataBook = FXCollections.observableArrayList(createTableExample.read("book")
        );

        booksCustomerEmailCol.setCellValueFactory(
            new PropertyValueFactory<>("Customer")
        );
        booksTitleCol.setCellValueFactory(
            new PropertyValueFactory<>("Title")
        );
        booksDateCol.setCellValueFactory(
            new PropertyValueFactory<>("Date")
        );
        booksReviewCol.setCellValueFactory(
            new PropertyValueFactory<>("Review")
        );

        booksTable.setItems(dataBook);

        //* CD Table Starts Here *//*
        final ObservableList<Object> dataCD = FXCollections.observableArrayList(createTableExample.read("cd")
        );

        cdCustomerEmailCol.setCellValueFactory(
            new PropertyValueFactory<>("Customer")
        );
        cdNameCol.setCellValueFactory(
            new PropertyValueFactory<>("Name")
        );
        cdDateCol.setCellValueFactory(
            new PropertyValueFactory<>("Date")
        );
        cdReviewCol.setCellValueFactory(
            new PropertyValueFactory<>("Review")
        );


        cdTable.setItems(dataCD);

        //* Software Table Starts Here *//*
        final ObservableList<Object> dataSoftware = FXCollections.observableArrayList(createTableExample.read("software")
        );

        softwareCustomerEmailCol.setCellValueFactory(
            new PropertyValueFactory<>("Customer")
        );
        softwareNameCol.setCellValueFactory(
            new PropertyValueFactory<>("Name")
        );
        softwareDateCol.setCellValueFactory(
            new PropertyValueFactory<>("Date")
        );
        softwareReviewCol.setCellValueFactory(
            new PropertyValueFactory<>("Review")
        );

        softwareTable.setItems(dataSoftware);
    }
}
