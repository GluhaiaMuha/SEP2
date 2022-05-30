package client.views.rent;

import client.model.LibraryModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferObj.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class RentViewModel {
    private ObservableList<Object> dataMovie;
    private ObservableList<Object> dataBook;
    private ObservableList<Object> dataCD;
    private ObservableList<Object> dataSoftware;

    private StringProperty movieSearchField;
    private StringProperty bookSearchField;
    private StringProperty cdSearchField;
    private StringProperty softwareSearchField;

    private LibraryModel libraryModel;

    public RentViewModel(LibraryModel libraryModel)
    {
        dataMovie = FXCollections.observableList(new ArrayList<>());
        dataBook = FXCollections.observableList(new ArrayList<>());
        dataCD = FXCollections.observableList(new ArrayList<>());
        dataSoftware = FXCollections.observableList(new ArrayList<>());

        movieSearchField = new SimpleStringProperty();
        bookSearchField = new SimpleStringProperty();
        cdSearchField = new SimpleStringProperty();
        softwareSearchField = new SimpleStringProperty();

        this.libraryModel = libraryModel;
    }

    public void updateTables()
    {
        dataMovie.clear();
        dataBook.clear();
        dataCD.clear();
        dataSoftware.clear();
        dataMovie.addAll(libraryModel.read("movie"));
        dataBook.addAll(libraryModel.read( "book"));
        dataCD.addAll(libraryModel.read( "cd"));
        dataSoftware.addAll(libraryModel.read( "software"));
    }

    public void newRent(Object obj, String product)
    {
        java.sql.Date sqlDateFrom;
        java.sql.Date sqlDateTo;
        Product product1 = (Product) obj;
        Rent rent = null;

        if (product1 != null)
        {
            if (validationForRent(obj, product))
            {
                if (product1.getAmountInStock() > 0)
                {
                    sqlDateFrom = new java.sql.Date(System.currentTimeMillis());
                    sqlDateTo = new java.sql.Date(System.currentTimeMillis() + 691200000);
                    switch (product)
                    {
                        case "book":
                            Book book = (Book) obj;
                            book.setAmountInStock(book.getAmountInStock() - 1);
                            rent = new Rent(libraryModel.getEmail(), book.getHash(), book.getTitle(), sqlDateFrom, sqlDateTo);
                            break;
                        case "movie":
                            Movie movie = (Movie) obj;
                            movie.setAmountInStock(movie.getAmountInStock() - 1);
                            rent = new Rent(libraryModel.getEmail(), movie.getHash(), movie.getTitle(), sqlDateFrom, sqlDateTo);
                            break;
                        case "cd":
                            CD cd = (CD) obj;
                            cd.setAmountInStock(cd.getAmountInStock() - 1);
                            rent = new Rent(libraryModel.getEmail(), cd.getHash(), cd.getName(), sqlDateFrom, sqlDateTo);
                            break;
                        case "software":
                            Software software = (Software) obj;
                            software.setAmountInStock(software.getAmountInStock() - 1);
                            rent = new Rent(libraryModel.getEmail(), software.getHash(), software.getName(), sqlDateFrom, sqlDateTo);
                            break;
                    }

                    libraryModel.rentProduct(product, rent);
                    libraryModel.update(product, "hash = '" + product1.getHash() + "'", obj);
                }
                else
                    JOptionPane.showMessageDialog(null, "No product in stock!");
            }
            else
                JOptionPane.showMessageDialog(null, "Product already rented!");
        }
        else
            JOptionPane.showMessageDialog(null, "Product is not selected!");
    }

    public boolean validationForRent(Object product, String table)
    {
        List<Rent> rents = libraryModel.readCustomerRents(libraryModel.getEmail(), table);
        Product product1 = (Product) product;
        for (Rent rent : rents)
        {
            if (rent.getProduct_hash().equals(product1.getHash()))
                return false;
        }
        return true;
    }

    public void newReview(Object obj, String product)
    {
        Review review = null;
        if (obj != null)
        {
            if (validationForReview(obj, product))
            {
                final String inputReview = JOptionPane.showInputDialog(
                    "Write review: ");
                java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
                if (!inputReview.equals(""))
                {
                    switch (product)
                    {
                        case "book":
                            Book book = (Book) obj;
                            review = new Review(libraryModel.getEmail(), book.getHash(), book.getTitle(), currentDate,
                                inputReview);
                            break;
                        case "movie":
                            Movie movie = (Movie) obj;
                            review = new Review(libraryModel.getEmail(), movie.getHash(), movie.getTitle(), currentDate,
                                inputReview);
                            break;
                        case "cd":
                            CD cd = (CD) obj;
                            review = new Review(libraryModel.getEmail(), cd.getHash(), cd.getName(), currentDate,
                                inputReview);
                            break;
                        case "software":
                            Software software = (Software) obj;
                            review = new Review(libraryModel.getEmail(),
                                software.getHash(), software.getName(),
                                currentDate, inputReview);
                            break;
                    }
                    libraryModel.addReview(product, review);
                }
                else
                    JOptionPane.showMessageDialog(null, "Input is empty!");
            }
            else
                JOptionPane.showMessageDialog(null, "Product is already reviewed!");
        }
        else
            JOptionPane.showMessageDialog(null, "Product is not selected!");
    }

    public boolean validationForReview(Object product, String table)
    {
        List<Review> reviews = libraryModel.readReview(table);
        Product product1 = (Product) product;
        String email = libraryModel.getEmail();
        for (Review review : reviews)
        {
            if (review.getProduct_hash().equals(product1.getHash()) && review.getCustomer_email().equals(email))
                return false;
        }
        return true;
    }

    public ObservableList<Object> searchProducts(String product)
    {
        String search;
        ObservableList<Object> productSearched = null;
        switch (product)
        {
            case "movie":
                search = movieSearchField.getValue();
                productSearched = FXCollections.observableArrayList(
                    libraryModel.readMoviesByTitle(search));
                break;
            case "book":
                search = bookSearchField.getValue();
                productSearched = FXCollections.observableArrayList(
                    libraryModel.readBooksByTitle(search));
                break;
            case "cd":
                search = cdSearchField.getValue();
                productSearched = FXCollections.observableArrayList(
                    libraryModel.readCDsByName(search));
                break;
            case "software":
                search = softwareSearchField.getValue();
                productSearched = FXCollections.observableArrayList(
                    libraryModel.readSoftwaresByName(search));
                break;
        }
        return productSearched;
    }

    public ObservableList<Object> getDataMovie()
    {
        return dataMovie;
    }

    public ObservableList<Object> getDataBook()
    {
        return dataBook;
    }

    public ObservableList<Object> getDataCD()
    {
        return dataCD;
    }

    public ObservableList<Object> getDataSoftware()
    {
        return dataSoftware;
    }

    public StringProperty movieSearchFieldProperty()
    {
        return movieSearchField;
    }

    public StringProperty bookSearchFieldProperty()
    {
        return bookSearchField;
    }

    public StringProperty cdSearchFieldProperty()
    {
        return cdSearchField;
    }

    public StringProperty softwareSearchFieldProperty()
    {
        return softwareSearchField;
    }
}
