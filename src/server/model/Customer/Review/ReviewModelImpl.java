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

  public List<Review> readReviewsByProductName(String searchString, String product)
  {
    return ReviewDAOImpl.getInstance().readReviewsByProductName(searchString, product);
  }

  public void removeReview(Review review, String product)
  {
    ReviewDAOImpl.getInstance().removeReview(review, product);
  }
}
