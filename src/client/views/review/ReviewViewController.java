package client.views.review;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.loginView.LoginViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import server.database.Customer.Review.ReviewDAOImpl;
import server.database.DatabaseManager;
import shared.transferObj.*;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.SQLException;

public class ReviewViewController implements ViewController,
    PropertyChangeListener
{
    private ViewHandler viewHandler;
    private ReviewViewModel reviewViewModel;
    private LoginViewModel loginViewModel;


    /* Movie Table Start Here */

    @FXML
    private TextField movieSearchField;

    @FXML
    private TableView<Review> movieTable;

    @FXML
    private TableColumn<Review, String> moviesCustomerEmailCol;
    @FXML
    private TableColumn<Review, String> moviesTitleCol;
    @FXML
    private TableColumn<Review, Date> moviesDateCol;
    @FXML
    private TableColumn<Review, String> moviesReviewCol;

    /* Books Table Starts Here */
    @FXML
    private TextField bookSearchField;

    @FXML
    private TableView<Review> booksTable;

    @FXML
    private TableColumn<Review, String> booksCustomerEmailCol;
    @FXML
    private TableColumn<Review, String> booksTitleCol;
    @FXML
    private TableColumn<Review, Date> booksDateCol;
    @FXML
    private TableColumn<Review, String> booksReviewCol;

    /* CD Table Starts Here */

    @FXML
    private TextField cdSearchField;

    @FXML
    private TableView<Review> cdTable;

    @FXML
    private TableColumn<Review, String> cdCustomerEmailCol;
    @FXML
    private TableColumn<Review, String> cdNameCol;
    @FXML
    private TableColumn<Review,Date > cdDateCol;
    @FXML
    private TableColumn<Review, String> cdReviewCol;

    /* Software Table Starts Here */
    @FXML
    private TextField softwareSearchField;

    @FXML
    private TableView<Review> softwareTable;

    @FXML
    private TableColumn<Review, String> softwareCustomerEmailCol;
    @FXML
    private TableColumn<Review, String> softwareNameCol;
    @FXML
    private TableColumn<Review, Date> softwareDateCol;
    @FXML
    private TableColumn<Review, String> softwareReviewCol;

    @FXML
    private Button removeBookReview;

    @FXML
    private Button removeCDReview;

    @FXML
    private Button removeMovieReview;

    @FXML
    private Button removeSoftwareReview;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf)
    {
        this.viewHandler = vh;
        reviewViewModel = vmf.getReviewViewModel();
        loginViewModel = vmf.getLoginViewModel();
        loginViewModel.addListener("Librarian",this);
        updateTables();
    }

    @FXML
    void onShowBookReview(ActionEvent event) {
        Review selectedBook = booksTable.getSelectionModel().getSelectedItem();
        final String review = selectedBook.getReview();
        final String html = "<html><body style='width: %1spx'>%1s";

        Runnable r = () -> {
            JOptionPane.showMessageDialog(
                null, String.format(html, 200, review));
        };
        SwingUtilities.invokeLater(r);
    }

    @FXML
    void onShowCDReview(ActionEvent event)
    {
        Review selectedCD = cdTable.getSelectionModel().getSelectedItem();
        final String review = selectedCD.getReview();
        final String html = "<html><body style='width: %1spx'>%1s";

        Runnable r = () -> {
            JOptionPane.showMessageDialog(
                null, String.format(html, 200, review));
        };
        SwingUtilities.invokeLater(r);
    }

    @FXML
    void onShowMovieReview(ActionEvent event)
    {
        Review selectedMovie = movieTable.getSelectionModel().getSelectedItem();
        final String review = selectedMovie.getReview();
        final String html = "<html><body style='width: %1spx'>%1s";

        Runnable r = () -> {
            JOptionPane.showMessageDialog(
                null, String.format(html, 200, review));
        };
        SwingUtilities.invokeLater(r);
    }

    @FXML
    void onShowSoftwareReview(ActionEvent event)
    {
        Review selectedSoftware = softwareTable.getSelectionModel().getSelectedItem();
        final String review = selectedSoftware.getReview();
        final String html = "<html><body style='width: %1spx'>%1s";

        Runnable r = () -> {
            JOptionPane.showMessageDialog(
                null, String.format(html, 200, review));
        };
        SwingUtilities.invokeLater(r);
    }

    @FXML
    void onRemoveBookReview(ActionEvent event)
    {
        Review selectedBook = booksTable.getSelectionModel().getSelectedItem();
        reviewViewModel.removeReview(selectedBook, "book");
        updateTables();
    }

    @FXML
    void onRemoveCDReview(ActionEvent event)
    {
        Review selectedCD = cdTable.getSelectionModel().getSelectedItem();
        reviewViewModel.removeReview(selectedCD, "cd");
        updateTables();
    }

    @FXML
    void onRemoveMovieReview(ActionEvent event)
    {
        Review selectedMovie = movieTable.getSelectionModel().getSelectedItem();
        reviewViewModel.removeReview(selectedMovie, "movie");
        updateTables();
    }

    @FXML
    void onRemoveSoftwareReview(ActionEvent event)
    {
        Review selectedSoftware = softwareTable.getSelectionModel().getSelectedItem();
        reviewViewModel.removeReview(selectedSoftware, "software");
        updateTables();
    }


    @FXML
    void onGoToMainPage(ActionEvent event)
    {
        User user = reviewViewModel.readUserRegister(reviewViewModel.getEmail());
        if (user.getUser().equals("librarian"))
            viewHandler.openLibrarianMainView();
        else
            viewHandler.openCustomerMainView();
    }

    public void librarianView()
    {
        removeMovieReview.setVisible(true);
        removeBookReview.setVisible(true);
        removeSoftwareReview.setVisible(true);
        removeCDReview.setVisible(true);
    }

    @FXML
    void onMovieSearch(ActionEvent event)
    {
        String search = movieSearchField.getText();
        ObservableList<Review> moviesSearched = FXCollections.observableArrayList(reviewViewModel.readReviewsByProductName(search, "movie"));

        movieTable.setItems(moviesSearched);
    }

    @FXML
    void onBookSearch(ActionEvent event)
    {
        String search = bookSearchField.getText();
        ObservableList<Review> booksSearched = FXCollections.observableArrayList(reviewViewModel.readReviewsByProductName(search, "book"));

        booksTable.setItems(booksSearched);
    }

    @FXML
    void onCDSearch(ActionEvent event)
    {
        String search = cdSearchField.getText();
        ObservableList<Review> CDsSearched = FXCollections.observableArrayList(reviewViewModel.readReviewsByProductName(search, "cd"));

        cdTable.setItems(CDsSearched);
    }

    @FXML
    void onSoftwareSearch(ActionEvent event)
    {
        String search = softwareSearchField.getText();
        ObservableList<Review> softwaresSearched = FXCollections.observableArrayList(reviewViewModel.readReviewsByProductName(search, "software"));

        softwareTable.setItems(softwaresSearched);
    }

    @FXML
    void onUpdateList(ActionEvent event)
    {
        updateTables();
    }

    private void updateTables()
    {
        //* Movie Table Start Here *//*
        //* For future use, make sure PropertyValueFactory is the same as the get/set Methods *//*

        final ObservableList<Review> dataMovie = FXCollections.observableArrayList(reviewViewModel.readReview("movie")
        );

        moviesCustomerEmailCol.setCellValueFactory(
            new PropertyValueFactory<>("customer_email")
        );
        moviesTitleCol.setCellValueFactory(
            new PropertyValueFactory<>("productName")
        );
        moviesDateCol.setCellValueFactory(
            new PropertyValueFactory<>("update")
        );
        moviesReviewCol.setCellValueFactory(
            new PropertyValueFactory<>("Review")
        );

        movieTable.setItems(dataMovie);

        //* Books Table Starts Here *//*

        final ObservableList<Review> dataBook = FXCollections.observableArrayList(reviewViewModel.readReview("book")
        );

        booksCustomerEmailCol.setCellValueFactory(
            new PropertyValueFactory<>("customer_email")
        );
        booksTitleCol.setCellValueFactory(
            new PropertyValueFactory<>("productName")
        );
        booksDateCol.setCellValueFactory(
            new PropertyValueFactory<>("update")
        );
        booksReviewCol.setCellValueFactory(
            new PropertyValueFactory<>("Review")
        );

        booksTable.setItems(dataBook);

        //* CD Table Starts Here *//*
        final ObservableList<Review> dataCD = FXCollections.observableArrayList(reviewViewModel.readReview("cd")
        );

        cdCustomerEmailCol.setCellValueFactory(
            new PropertyValueFactory<>("customer_email")
        );
        cdNameCol.setCellValueFactory(
            new PropertyValueFactory<>("productName")
        );
        cdDateCol.setCellValueFactory(
            new PropertyValueFactory<>("update")
        );
        cdReviewCol.setCellValueFactory(
            new PropertyValueFactory<>("Review")
        );


        cdTable.setItems(dataCD);

        //* Software Table Starts Here *//*
        final ObservableList<Review> dataSoftware = FXCollections.observableArrayList(reviewViewModel.readReview("software")
        );

        softwareCustomerEmailCol.setCellValueFactory(
            new PropertyValueFactory<>("customer_email")
        );
        softwareNameCol.setCellValueFactory(
            new PropertyValueFactory<>("productName")
        );
        softwareDateCol.setCellValueFactory(
            new PropertyValueFactory<>("update")
        );
        softwareReviewCol.setCellValueFactory(
            new PropertyValueFactory<>("Review")
        );

        softwareTable.setItems(dataSoftware);
    }

    @Override public void propertyChange(PropertyChangeEvent evt)
    {
        if(evt.getPropertyName().equals("Librarian"))
        {
            librarianView();
        }
    }
}
