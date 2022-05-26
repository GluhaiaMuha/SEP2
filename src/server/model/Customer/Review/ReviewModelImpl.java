package server.model.Customer.Review;

import server.database.Customer.Review.ReviewDAOImpl;
import shared.transferObj.Review;

import java.util.List;

public class ReviewModelImpl implements ReviewModel
{
  private static ReviewModel instance =  new ReviewModelImpl();

  public static ReviewModel getInstance(){
    return instance;
  }

  public void addReview(String product, Review review)
  {
    ReviewDAOImpl.getInstance().addReview(product, review);
  }

  public List<Review> readReview(String product)
  {
    return ReviewDAOImpl.getInstance().readReview(product);
  }
}
