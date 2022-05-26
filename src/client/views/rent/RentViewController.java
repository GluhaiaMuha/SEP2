package client.views.rent;

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
import shared.transferObj.*;

import javax.swing.*;
import java.util.List;

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



    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf)
    {
        this.viewHandler = vh;
        rentViewModel = vmf.getRentViewModel();
        updateTables();
    }

    @FXML
    void onRentBook(ActionEvent event)
    {
        Book selectedBook = (Book) booksTable.getSelectionModel().getSelectedItem();

        if (validation(selectedBook, "book"))
        {
            if (selectedBook.getAmountInStock() > 0)
            {
                selectedBook.setAmountInStock(selectedBook.getAmountInStock() - 1);
                java.sql.Date sqlDateFrom = new java.sql.Date(System.currentTimeMillis());
                java.sql.Date sqlDateTo = new java.sql.Date(
                    System.currentTimeMillis() + 691200000);
                Rent rent = new Rent(rentViewModel.getEmail(), selectedBook.getHash(), selectedBook.getTitle(),
                    sqlDateFrom, sqlDateTo);
                rentViewModel.rentProduct("book", rent);
                rentViewModel.update("book",
                    "hash = '" + selectedBook.getHash() + "'", selectedBook);
                updateTables();
            }
            else
            {
                booksTable.getSelectionModel().setCellSelectionEnabled(false);
                JOptionPane.showMessageDialog(null, "No product in stock!");
            }
        }else
            JOptionPane.showMessageDialog(null, "Product already rented!");
    }

    @FXML
    void onRentCD(ActionEvent event)
    {
        CD selectedCD = (CD) cdTable.getSelectionModel().getSelectedItem();

        if (validation(selectedCD, "cd"))
        {
            if (selectedCD.getAmountInStock() > 0){
                selectedCD.setAmountInStock(selectedCD.getAmountInStock() - 1);
                java.sql.Date sqlDateFrom = new java.sql.Date(System.currentTimeMillis());
                java.sql.Date sqlDateTo = new java.sql.Date(System.currentTimeMillis() + 691200000);
                Rent rent = new Rent(rentViewModel.getEmail(), selectedCD.getHash(), selectedCD.getName(), sqlDateFrom, sqlDateTo);
                rentViewModel.rentProduct("cd" ,rent);
                rentViewModel.update("cd", "hash = '" + selectedCD.getHash() + "'", selectedCD);
                updateTables();
            }
            else
            {
                cdTable.getSelectionModel().setCellSelectionEnabled(false);
                JOptionPane.showMessageDialog(null, "No product in stock!");
            }
        }else
            JOptionPane.showMessageDialog(null, "Product already rented!");

    }

    @FXML
    void onRentMovie(ActionEvent event)
    {
        Movie selectedMovie = (Movie) movieTable.getSelectionModel().getSelectedItem();

        if (validation(selectedMovie, "movie"))
        {
            if (selectedMovie.getAmountInStock() > 0){
                selectedMovie.setAmountInStock(selectedMovie.getAmountInStock() - 1);
                java.sql.Date sqlDateFrom = new java.sql.Date(System.currentTimeMillis());
                java.sql.Date sqlDateTo = new java.sql.Date(System.currentTimeMillis() + 691200000);
                Rent rent = new Rent(rentViewModel.getEmail(), selectedMovie.getHash(), selectedMovie.getTitle(), sqlDateFrom, sqlDateTo);
                rentViewModel.rentProduct("movie",rent);
                rentViewModel.update("movie", "hash = '" + selectedMovie.getHash() + "'", selectedMovie);
                updateTables();
            }
            else
            {
                movieTable.getSelectionModel().setCellSelectionEnabled(false);
                JOptionPane.showMessageDialog(null, "No product in stock!");
            }
        }else
            JOptionPane.showMessageDialog(null, "Product already rented!");
    }

    @FXML
    void onRentSoftware(ActionEvent event)
    {
        Software selectedSoftware = (Software) softwareTable.getSelectionModel().getSelectedItem();

        if (validation(selectedSoftware, "software"))
        {
            if (selectedSoftware.getAmountInStock() > 0){
                selectedSoftware.setAmountInStock(selectedSoftware.getAmountInStock() - 1);
                java.sql.Date sqlDateFrom = new java.sql.Date(System.currentTimeMillis());
                java.sql.Date sqlDateTo = new java.sql.Date(System.currentTimeMillis() + 691200000);
                Rent rent = new Rent(rentViewModel.getEmail(), selectedSoftware.getHash(), selectedSoftware.getName(), sqlDateFrom, sqlDateTo);
                rentViewModel.rentProduct("software", rent);
                rentViewModel.update("software", "hash = '" + selectedSoftware.getHash() + "'", selectedSoftware);
                updateTables();
            }
            else
            {
                softwareTable.getSelectionModel().setCellSelectionEnabled(false);
                JOptionPane.showMessageDialog(null, "No product in stock!");
            }
        }else
            JOptionPane.showMessageDialog(null, "Product already rented!");

    }

    @FXML
    void onAddBookReview(ActionEvent event)
    {
        Book selectedBook = (Book) booksTable.getSelectionModel().getSelectedItem();
        final String review = JOptionPane.showInputDialog("Write review: ");
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

        if (!review.equals(""))
        {
            Review bookReview = new Review(rentViewModel.getEmail(),
                selectedBook.getHash(), selectedBook.getTitle(), currentDate,
                review);
            rentViewModel.addReview("book", bookReview);
        } else
            JOptionPane.showMessageDialog(null, "Input is empty!");
    }

    @FXML
    void onAddCDReview(ActionEvent event)
    {
        CD selectedCD = (CD) cdTable.getSelectionModel().getSelectedItem();
        final String review = JOptionPane.showInputDialog("Write review: ");
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

        if (!review.equals(""))
        {
            Review cdReview = new Review(rentViewModel.getEmail(), selectedCD.getHash(), selectedCD.getName(), currentDate,
                review);
            rentViewModel.addReview("cd", cdReview);
        }else
            JOptionPane.showMessageDialog(null, "Input is empty!");
    }

    @FXML
    void onAddMovieReview(ActionEvent event)
    {
        Movie selectedMovie = (Movie) movieTable.getSelectionModel().getSelectedItem();
        final String review = JOptionPane.showInputDialog("Write review: ");
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

        if (!review.equals(""))
        {
            Review movieReview = new Review(rentViewModel.getEmail(),
                selectedMovie.getHash(), selectedMovie.getTitle(), currentDate,
                review);
            rentViewModel.addReview("movie", movieReview);
        }else
            JOptionPane.showMessageDialog(null, "Input is empty!");
    }

    @FXML
    void onAddSoftwareReview(ActionEvent event)
    {
        Software selectedSoftware = (Software) softwareTable.getSelectionModel().getSelectedItem();
        final String review = JOptionPane.showInputDialog("Write review: ");
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
        if (!review.equals(""))
        {
            Review softwareReview = new Review(rentViewModel.getEmail(), selectedSoftware.getHash(), selectedSoftware.getName(), currentDate, review);
            rentViewModel.addReview("software", softwareReview);
        }
        else
            JOptionPane.showMessageDialog(null, "Input is empty!");
    }

    public boolean validation(Object product, String table)
    {
        List<Rent> rents = rentViewModel.readCustomerRents(rentViewModel.getEmail(), table);
        switch (table)
        {
            case "book":
                Book book = (Book) product;
                for (Rent rent : rents)
                {
                    if (rent.getProduct_hash().equals(book.getHash()))
                    {
                        return false;
                    }
                }
                break;
            case "movie":
                Movie movie = (Movie) product;
                for (Rent rent : rents)
                {
                    if (rent.getProduct_hash().equals(movie.getHash()))
                    {
                        return false;
                    }
                }
                break;
            case "cd":
                CD cd = (CD) product;
                for (Rent rent : rents)
                {
                    if (rent.getProduct_hash().equals(cd.getHash()))
                    {
                        return false;
                    }
                }
                break;
            case "software":
                Software software = (Software) product;
                for (Rent rent : rents)
                {
                    if (rent.getProduct_hash().equals(software.getHash()))
                    {
                        return false;
                    }
                }
                break;
        }
        return true;
    }

    @FXML
    void onGoToMainPage(ActionEvent event) {
        viewHandler.openCustomerMainView();
    }

    @FXML
    void onUpdateList(ActionEvent event)
    {
        updateTables();
    }

    @FXML
    void onMovieSearch(ActionEvent event)
    {
        String search = movieSearchField.getText();
        ObservableList<Object> moviesSearched = FXCollections.observableArrayList(rentViewModel.readMoviesByTitle(search));

        movieTable.setItems(moviesSearched);
        updateTables();
    }

    @FXML
    void onBookSearch(ActionEvent event)
    {
        String search = bookSearchField.getText();
        ObservableList<Object> booksSearched = FXCollections.observableArrayList(rentViewModel.readBooksByTitle(search));

        booksTable.setItems(booksSearched);
        updateTables();
    }

    @FXML
    void onCDSearch(ActionEvent event)
    {
        String search = cdSearchField.getText();
        ObservableList<Object> CDsSearched = FXCollections.observableArrayList(rentViewModel.readCDsByName(search));

        cdTable.setItems(CDsSearched);
        updateTables();
    }

    @FXML
    void onSoftwareSearch(ActionEvent event)
    {
        String search = softwareSearchField.getText();
        ObservableList<Object> softwaresSearched = FXCollections.observableArrayList(rentViewModel.readSoftwaresByName(search));

        softwareTable.setItems(softwaresSearched);
        updateTables();
    }


    private void updateTables()
    {
        /* Movie Table Start Here */
        /* For future use, make sure PropertyValueFactory is the same as the get/set Methods */

        final ObservableList<Object> dataMovie = FXCollections.observableArrayList(rentViewModel.read("movie")
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

        final ObservableList<Object> dataBook = FXCollections.observableArrayList(rentViewModel.read("book")
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
        final ObservableList<Object> dataCD = FXCollections.observableArrayList(rentViewModel.read("cd")
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
        final ObservableList<Object> dataSoftware = FXCollections.observableArrayList(rentViewModel.read("software")
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
