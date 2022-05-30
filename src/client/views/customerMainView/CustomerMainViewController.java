package client.views.customerMainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.customerInfoChangeView.CustomerInfoChangeViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CustomerMainViewController implements ViewController {

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelName;

    @FXML
    private Label labelPhone;

    private CustomerMainViewModel customerMainViewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler=vh;
        this.customerMainViewModel=vmf.getCustomerMainViewModel();
        labelEmail.textProperty().bind(vmf.getCustomerMainViewModel().labelEmailProperty());
        labelName.textProperty().bind(vmf.getCustomerMainViewModel().labelNameProperty());
        labelPhone.textProperty().bind(vmf.getCustomerMainViewModel().labelPhoneProperty());
    }

    public void onRentAction() {
        viewHandler.openRentView();
    }
    public void onLoansAction() {
        viewHandler.openLoansView();
    }
    public void onReviewAction() {
        viewHandler.openReviewView();
    }

    @FXML
    void onChangeInfo(ActionEvent event) {
        viewHandler.openCustomerInfoChangeView();
        CustomerInfoChangeViewModel.selectInfo();
    }
}

