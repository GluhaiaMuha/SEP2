package server.database.Customer.Review;

import shared.transferObj.Review;

import java.util.List;

public interface ReviewDAO
{
  void addReview(String product, Review review);

  List<Review> readReview(String product);

  List<Review> readReviewsByProductName(String searchString, String product);

  void removeReview(Review review, String product);
}
