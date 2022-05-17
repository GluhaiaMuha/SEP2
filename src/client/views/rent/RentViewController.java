package client.views.rent;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;

public class RentViewController implements ViewController {

    private ViewHandler viewHandler;
    private RentViewModel rentViewModel;
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler=vh;
        this.rentViewModel=vmf.getRentViewModel();
    }

    public void onSearchProductAction(ActionEvent actionEvent) {
    }

    public void onBackButton() {
        viewHandler.openCustomerMainView();
    }

    public void onShowAvailableAction(ActionEvent actionEvent) {
    }
}
