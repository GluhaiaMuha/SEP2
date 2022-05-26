package client.views.review;

import client.model.LibraryModel;
import shared.transferObj.Review;

import java.util.List;

public class ReviewViewModel {
    private LibraryModel libraryModel;

    public ReviewViewModel(LibraryModel libraryModel) {

        this.libraryModel = libraryModel;
    }

    public List<Review> readReview(String product)
    {
        return libraryModel.readReview(product);
    }
}
