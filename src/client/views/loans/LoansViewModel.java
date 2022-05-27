package client.views.loans;

import client.model.LibraryModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.transferObj.Rent;

import javax.swing.*;
import java.util.ArrayList;

public class LoansViewModel {
    private ObservableList<Rent> dataMovie;
    private ObservableList<Rent> dataBook;
    private ObservableList<Rent> dataCD;
    private ObservableList<Rent> dataSoftware;
    private LibraryModel libraryModel;

    public LoansViewModel(LibraryModel libraryModel)
    {
        dataMovie = FXCollections.observableList(new ArrayList<>());
        dataBook = FXCollections.observableList(new ArrayList<>());
        dataCD = FXCollections.observableList(new ArrayList<>());
        dataSoftware = FXCollections.observableList(new ArrayList<>());
        this.libraryModel = libraryModel;
    }

    public void updateTables()
    {
        dataMovie.clear();
        dataBook.clear();
        dataCD.clear();
        dataSoftware.clear();
        dataMovie.addAll(libraryModel.readCustomerRents(libraryModel.getEmail(), "movie"));
        dataBook.addAll(libraryModel.readCustomerRents(libraryModel.getEmail(), "book"));
        dataCD.addAll(libraryModel.readCustomerRents(libraryModel.getEmail(), "cd"));
        dataSoftware.addAll(libraryModel.readCustomerRents(libraryModel.getEmail(), "software"));
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

//    public List<Rent> readCustomerRents(String customer_email, String product)
//    {
//        return libraryModel.readCustomerRents(customer_email, product);
//    }

//    public void removeRent(Rent rent, String product)
//    {
//        libraryModel.removeRent(rent, product);
//    }

//    public void update(String tableName, String whereClause, Object obj)
//    {
//        libraryModel.update(tableName, whereClause, obj);
//    }

//    public void updateProductAmount(String tableName, String productHash)
//    {
//        libraryModel.updateProductAmount(tableName, productHash);
//    }

//    public String getEmail()
//    {
//        return libraryModel.getEmail();
//    }


}
