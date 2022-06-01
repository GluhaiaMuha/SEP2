package client.views.customerMainView;

import client.model.LibraryModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.transferObj.Customer;

public class CustomerMainViewModel{

    private static StringProperty labelEmail;
    private static StringProperty labelName;
    private static StringProperty labelPhone;

    private static LibraryModel libraryModel;

    public CustomerMainViewModel(LibraryModel libraryModel)
    {
        labelEmail = new SimpleStringProperty();
        labelName = new SimpleStringProperty();
        labelPhone = new SimpleStringProperty();
        this.libraryModel = libraryModel;
    }

    public static void customerInfo()
    {
        Customer customer = libraryModel.readCustomerInfo(libraryModel.getEmail());
        labelName.setValue(customer.getF_name() + " " + customer.getL_name());
        labelEmail.setValue(customer.getE_mail());
        labelPhone.setValue("+45" + customer.getPhone());
    }

    public StringProperty labelEmailProperty()
    {
        return labelEmail;
    }

    public StringProperty labelNameProperty()
    {
        return labelName;
    }

    public StringProperty labelPhoneProperty()
    {
        return labelPhone;
    }
}
