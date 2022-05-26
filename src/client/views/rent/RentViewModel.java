package client.views.rent;

import client.model.LibraryModel;
import shared.transferObj.*;

import java.util.List;

public class RentViewModel {
    private LibraryModel libraryModel;

    public RentViewModel(LibraryModel libraryModel)
    {
        this.libraryModel = libraryModel;
    }

    public void rentProduct(String product, Rent rent)
    {
        libraryModel.rentProduct(product, rent);
    }

    public List<Rent> readCustomerRents(String customer_email, String product)
    {
        return libraryModel.readCustomerRents(customer_email, product);
    }

    public List<Object> read(String tableName)
    {
        return libraryModel.read(tableName);
    }

    public List<Book> readBooksByTitle(String searchString)
    {
        return libraryModel.readBooksByTitle(searchString);
    }

    public List<Movie> readMoviesByTitle(String searchString)
    {
        return libraryModel.readMoviesByTitle(searchString);
    }

    public List<CD> readCDsByName(String searchString)
    {
        return libraryModel.readCDsByName(searchString);
    }

    public List<Software> readSoftwaresByName(String searchString)
    {
        return libraryModel.readSoftwaresByName(searchString);
    }

    public void update(String tableName, String whereClause, Object obj)
    {
        libraryModel.update(tableName, whereClause, obj);
    }

    public void delete(String tableName, String whereClause)
    {
        libraryModel.delete(tableName, whereClause);
    }

    public void addReview(String product, Review review)
    {
        libraryModel.addReview(product, review);
    }

    public List<Review> readReview(String product)
    {
        return libraryModel.readReview(product);
    }

    public String getEmail()
    {
        return libraryModel.getEmail();
    }
}
