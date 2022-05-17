package client.views.review;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;

public class ReviewViewController implements ViewController {
    private ViewHandler viewHandler;
    private ReviewViewModel reviewViewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        reviewViewModel= vmf.getReviewViewModel();
    }
}
