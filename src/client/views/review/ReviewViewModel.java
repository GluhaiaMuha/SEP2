package client.views.review;

import client.model.LibraryModel;
import shared.transferObj.*;

import java.util.List;

public class ReviewViewModel
{
    private LibraryModel libraryModel;

    public ReviewViewModel(LibraryModel libraryModel) {
        this.libraryModel = libraryModel;

    }

    public List<Review> readReview(String product)
    {
        return libraryModel.readReview(product);
    }

    public List<Review> readReviewsByProductName(String searchString, String product)
    {
        return libraryModel.readReviewsByProductName(searchString, product);
    }

    public User readUserRegister(String email)
    {
        return libraryModel.readUserRegister(email);
    }

    public void removeReview(Review review, String product)
    {
        libraryModel.removeReview(review, product);
    }

    public String getEmail()
    {
        return libraryModel.getEmail();
    }
}
