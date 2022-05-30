package client.views.review;

import client.model.LibraryModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferObj.Review;
import shared.transferObj.User;
import shared.util.Subject;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * ViewModel Class for ReviewViewController
 */
public class ReviewViewModel implements Subject
{
    private ObservableList<Review> dataMovie;
    private ObservableList<Review> dataBook;
    private ObservableList<Review> dataCD;
    private ObservableList<Review> dataSoftware;

    private StringProperty movieSearchField;
    private StringProperty bookSearchField;
    private StringProperty cdSearchField;
    private StringProperty softwareSearchField;

    private LibraryModel libraryModel;
    private PropertyChangeSupport support;

    public ReviewViewModel(LibraryModel libraryModel)
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
        support = new PropertyChangeSupport(this);
    }

    public void updateTables()
    {
        dataMovie.clear();
        dataBook.clear();
        dataCD.clear();
        dataSoftware.clear();
        dataMovie.addAll(libraryModel.readReview("movie"));
        dataBook.addAll(libraryModel.readReview( "book"));
        dataCD.addAll(libraryModel.readReview( "cd"));
        dataSoftware.addAll(libraryModel.readReview( "software"));
    }

    /**
     * Show review
     */
    public void showReview(Review review)
    {
        if (review != null)
        {
            final String customerReview = review.getReview();
            final String html = "<html><body style='width: %1spx'>%1s";

            Runnable r = () -> {
                JOptionPane.showMessageDialog(null, String.format(html, 200, customerReview));
            };
            SwingUtilities.invokeLater(r);
        }else
            JOptionPane.showMessageDialog(null, "Product is not selected!");
    }

    /**
     * Delete review
     */
    public void removeReview(Review review, String product)
    {
        if (review != null)
        {
            libraryModel.removeReview(review, product);
        }else
            JOptionPane.showMessageDialog(null, "Product is not selected!");
    }

    /**
     * Search for a specific product
     *
     * @param product Product
     * @return ObservableList
     */
    public ObservableList<Review> searchProducts(String product)
    {
        String search = "";
        switch (product)
        {
            case "movie":
                search = movieSearchField.getValue();
                break;
            case "book":
                search = bookSearchField.getValue();
                break;
            case "cd":
                search = cdSearchField.getValue();
                break;
            case "software":
                search = softwareSearchField.getValue();
                break;
        }
        return FXCollections.observableArrayList(libraryModel.readReviewsByProductName(search, product));
    }

    public void goToMainPage()
    {
        User user = libraryModel.readUserRegister(libraryModel.getEmail());
        if (user.getUser().equals("librarian"))
            support.firePropertyChange("LibrarianView", null, user);
        else
            support.firePropertyChange("CustomerView", null, user);
    }

    public ObservableList<Review> getDataMovie()
    {
        return dataMovie;
    }

    public ObservableList<Review> getDataBook()
    {
        return dataBook;
    }

    public ObservableList<Review> getDataCD()
    {
        return dataCD;
    }

    public ObservableList<Review> getDataSoftware()
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

    @Override public void addListener(String eventName,
        PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override public void removeListener(String eventName,
        PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(eventName,listener);
    }
}
