package client.views.loans;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;

public class LoansViewController implements ViewController {
    private ViewHandler viewHandler;
    private LoansViewModel loansViewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        loansViewModel= vmf.getLoansViewModel();

    }
}
