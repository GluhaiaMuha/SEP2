package client.views.customerMainView;

import client.model.LibraryModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerMainViewModel{

    private StringProperty labelEmail;
    private StringProperty labelName;
    private StringProperty labelPhone;

    private LibraryModel libraryModel;

    public CustomerMainViewModel(LibraryModel libraryModel)
    {
        labelEmail = new SimpleStringProperty();
        labelName = new SimpleStringProperty();
        labelPhone = new SimpleStringProperty();
        this.libraryModel = libraryModel;
    }

//    public static void customerInfo()
//    {
//        Customer customer = libraryModel.readCustomerInfo(libraryModel.getEmail());
//        labelName.setValue(customer.getF_name() + " " + customer.getL_name());
//        labelEmail.setValue(customer.getE_mail());
//        labelPhone.setValue(customer.getPhone());
//    }

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
