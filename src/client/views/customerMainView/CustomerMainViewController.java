package client.views.customerMainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;

public class CustomerMainViewController implements ViewController {

    private CustomerMainViewModel customerMainViewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler=vh;
        this.customerMainViewModel=vmf.getCustomerMainViewModel();
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
}

