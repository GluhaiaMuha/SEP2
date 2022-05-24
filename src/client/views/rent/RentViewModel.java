package client.views.rent;

import client.model.LibraryModel;
import shared.transferObj.Rent;

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

    public String getEmail()
    {
        return libraryModel.getEmail();
    }
}
