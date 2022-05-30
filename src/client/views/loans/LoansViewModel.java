package client.views.loans;

import client.model.LibraryModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferObj.Rent;
import shared.transferObj.User;
import shared.util.Subject;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class LoansViewModel implements Subject
{
    private ObservableList<Rent> dataMovie;
    private ObservableList<Rent> dataBook;
    private ObservableList<Rent> dataCD;
    private ObservableList<Rent> dataSoftware;

    private LibraryModel libraryModel;
    private PropertyChangeSupport support;

    public LoansViewModel(LibraryModel libraryModel)
    {
        dataMovie = FXCollections.observableList(new ArrayList<>());
        dataBook = FXCollections.observableList(new ArrayList<>());
        dataCD = FXCollections.observableList(new ArrayList<>());
        dataSoftware = FXCollections.observableList(new ArrayList<>());
        this.libraryModel = libraryModel;
        support = new PropertyChangeSupport(this);
    }

    public void updateTables()
    {
        dataMovie.clear();
        dataBook.clear();
        dataCD.clear();
        dataSoftware.clear();
        User user = libraryModel.readUserRegister(libraryModel.getEmail());
        if (user!=null)
        {
            if (user.getUser().equals("customer"))
            {
                dataMovie.addAll(libraryModel.readCustomerRents(libraryModel.getEmail(), "movie"));
                dataBook.addAll(libraryModel.readCustomerRents(libraryModel.getEmail(), "book"));
                dataCD.addAll(libraryModel.readCustomerRents(libraryModel.getEmail(), "cd"));
                dataSoftware.addAll(libraryModel.readCustomerRents(libraryModel.getEmail(), "software"));
            }
            else
            {
                dataMovie.addAll(libraryModel.readRents( "movie"));
                dataBook.addAll(libraryModel.readRents("book"));
                dataCD.addAll(libraryModel.readRents("cd"));
                dataSoftware.addAll(libraryModel.readRents("software"));
            }
        }
    }

    public void removeRent(Rent rent, String product)
    {
        if (rent != null)
        {
            libraryModel.removeRent(rent, product);
            libraryModel.updateProductAmount(product, rent.getProduct_hash());
        }else
            JOptionPane.showMessageDialog(null, "Product is not selected!");
    }

    public void goToMainPage()
    {
        User user = libraryModel.readUserRegister(libraryModel.getEmail());
        if (user.getUser().equals("librarian"))
            support.firePropertyChange("LibrarianView", null, user);
        else
            support.firePropertyChange("CustomerView", null, user);
    }

    public ObservableList<Rent> getDataMovie()
    {
        return dataMovie;
    }

    public ObservableList<Rent> getDataBook()
    {
        return dataBook;
    }

    public ObservableList<Rent> getDataCD()
    {
        return dataCD;
    }

    public ObservableList<Rent> getDataSoftware()
    {
        return dataSoftware;
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
