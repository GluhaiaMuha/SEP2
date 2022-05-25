package client.views.loans;

import client.model.LibraryModel;
import shared.transferObj.*;

import java.util.List;

public class LoansViewModel {
    private LibraryModel libraryModel;

    public LoansViewModel(LibraryModel libraryModel) {

        this.libraryModel = libraryModel;
    }

    public List<Rent> readCustomerRents(String customer_email, String product)
    {
        return libraryModel.readCustomerRents(customer_email, product);
    }

    public void removeRent(Rent rent, String product)
    {
        libraryModel.removeRent(rent, product);
    }

    public String getEmail()
    {
        return libraryModel.getEmail();
    }
}
