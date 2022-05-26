package server.model.Customer.Review;

import shared.transferObj.Review;

import java.util.List;

public interface ReviewModel
{
  void addReview(String product, Review review);

  List<Review> readReview(String product);
}
