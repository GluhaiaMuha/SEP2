package client.views.review;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.loginView.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferObj.Review;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;

/**
 * Controller Class for Review.fxml
 */
public class ReviewViewController implements ViewController, PropertyChangeListener
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

    /**
     * Method for initializing the Controller
     *
     * @param vh ViewHandler
     * @param vmf ViewModelFactory
     */
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf)
    {
        this.viewHandler = vh;
        reviewViewModel = vmf.getReviewViewModel();
        loginViewModel = vmf.getLoginViewModel();

        movieSearchField.textProperty().bindBidirectional(reviewViewModel.movieSearchFieldProperty());
        bookSearchField.textProperty().bindBidirectional(reviewViewModel.bookSearchFieldProperty());
        cdSearchField.textProperty().bindBidirectional(reviewViewModel.cdSearchFieldProperty());
        softwareSearchField.textProperty().bindBidirectional(reviewViewModel.softwareSearchFieldProperty());

        loginViewModel.addListener("Librarian",this);
        reviewViewModel.addListener("LibrarianView", this);
        reviewViewModel.addListener("CustomerView", this);
        tables();
        reviewViewModel.updateTables();
    }

    /**
     * Action Event for showing Book reviews
     */
    @FXML
    void onShowBookReview(ActionEvent event) {
        Review selectedBook = booksTable.getSelectionModel().getSelectedItem();
        reviewViewModel.showReview(selectedBook);
    }

    /**
     * Action Event for showing CD reviews
     */
    @FXML
    void onShowCDReview(ActionEvent event)
    {
        Review selectedCD = cdTable.getSelectionModel().getSelectedItem();
        reviewViewModel.showReview(selectedCD);
    }

    /**
     * Action Event for showing Movie Reviews
     */
    @FXML
    void onShowMovieReview(ActionEvent event)
    {
        Review selectedMovie = movieTable.getSelectionModel().getSelectedItem();
        reviewViewModel.showReview(selectedMovie);
    }

    /**
     * Action Event for showing Software Reviews
     */
    @FXML
    void onShowSoftwareReview(ActionEvent event)
    {
        Review selectedSoftware = softwareTable.getSelectionModel().getSelectedItem();
        reviewViewModel.showReview(selectedSoftware);
    }

    /**
     * Action Event for removing Book reviews
     */
    @FXML
    void onRemoveBookReview(ActionEvent event)
    {
        Review selectedBook = booksTable.getSelectionModel().getSelectedItem();
        reviewViewModel.removeReview(selectedBook, "book");
        reviewViewModel.updateTables();
    }

    /**
     * Action Event for removing CD reviews
     */
    @FXML
    void onRemoveCDReview(ActionEvent event)
    {
        Review selectedCD = cdTable.getSelectionModel().getSelectedItem();
        reviewViewModel.removeReview(selectedCD, "cd");
        reviewViewModel.updateTables();
    }

    /**
     * Action Event for removing Movie reviews
     */
    @FXML
    void onRemoveMovieReview(ActionEvent event)
    {
        Review selectedMovie = movieTable.getSelectionModel().getSelectedItem();
        reviewViewModel.removeReview(selectedMovie, "movie");
        reviewViewModel.updateTables();
    }

    /**
     * Action Event for removing Software reviews
     */
    @FXML
    void onRemoveSoftwareReview(ActionEvent event)
    {
        Review selectedSoftware = softwareTable.getSelectionModel().getSelectedItem();
        reviewViewModel.removeReview(selectedSoftware, "software");
        reviewViewModel.updateTables();
    }

    /**
     * Action Event for going back to the main Page
     */
    @FXML
    void onGoToMainPage(ActionEvent event)
    {
        reviewViewModel.goToMainPage();
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
        movieTable.setItems(reviewViewModel.searchProducts("movie"));
    }

    @FXML
    void onBookSearch(ActionEvent event)
    {
        booksTable.setItems(reviewViewModel.searchProducts("book"));
    }

    @FXML
    void onCDSearch(ActionEvent event)
    {
        cdTable.setItems(reviewViewModel.searchProducts("cd"));
    }

    @FXML
    void onSoftwareSearch(ActionEvent event)
    {
        softwareTable.setItems(reviewViewModel.searchProducts("software"));
    }

    @FXML
    void onUpdateList(ActionEvent event)
    {
        reviewViewModel.updateTables();
        tables();
    }

    private void tables()
    {
        moviesCustomerEmailCol.setCellValueFactory(new PropertyValueFactory<>("customer_email"));
        moviesTitleCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        moviesDateCol.setCellValueFactory(new PropertyValueFactory<>("update"));
        moviesReviewCol.setCellValueFactory(new PropertyValueFactory<>("Review"));
        movieTable.setItems(reviewViewModel.getDataMovie());


        booksCustomerEmailCol.setCellValueFactory(new PropertyValueFactory<>("customer_email"));
        booksTitleCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        booksDateCol.setCellValueFactory(new PropertyValueFactory<>("update"));
        booksReviewCol.setCellValueFactory(new PropertyValueFactory<>("Review"));
        booksTable.setItems(reviewViewModel.getDataBook());


        cdCustomerEmailCol.setCellValueFactory(new PropertyValueFactory<>("customer_email"));
        cdNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        cdDateCol.setCellValueFactory(new PropertyValueFactory<>("update"));
        cdReviewCol.setCellValueFactory(new PropertyValueFactory<>("Review"));
        cdTable.setItems(reviewViewModel.getDataCD());


        softwareCustomerEmailCol.setCellValueFactory(new PropertyValueFactory<>("customer_email"));
        softwareNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        softwareDateCol.setCellValueFactory(new PropertyValueFactory<>("update"));
        softwareReviewCol.setCellValueFactory(new PropertyValueFactory<>("Review"));
        softwareTable.setItems(reviewViewModel.getDataSoftware());
    }

    @Override public void propertyChange(PropertyChangeEvent evt)
    {
        if(evt.getPropertyName().equals("Librarian"))
        {
            librarianView();
        }
        else if (evt.getPropertyName().equals("LibrarianView"))
        {
            viewHandler.openLibrarianMainView();
        }
        else if (evt.getPropertyName().equals("CustomerView"))
        {
            viewHandler.openCustomerMainView();
        }
    }
}
