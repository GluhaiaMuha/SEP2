package server.database.Customer.Review;

import server.database.DatabaseFront;
import shared.transferObj.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImpl implements ReviewDAO
{
  private static ReviewDAO instance = new ReviewDAOImpl();

  public static ReviewDAO getInstance(){
    return instance;
  }

  public void addReview(String product, Review review)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO review_" + product + "(customer_email, product_hash, productName, update, review) VALUES (?, ?, ?, ?, ?)");
      statement.setString(1, review.getCustomer_email());
      statement.setString(2, review.getProduct_hash());
      statement.setString(3, review.getProductName());
      statement.setDate(4, review.getUpdate());
      statement.setString(5, review.getReview());
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  public List<Review> readReview(String product)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM review_" + product);
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Review> reviews = new ArrayList<>();
      while (resultSet.next())
      {
        String email = resultSet.getString("customer_email");
        String hash = resultSet.getString("product_hash");
        String productName = resultSet.getString("productName");
        Date update = resultSet.getDate("update");
        String customer_review = resultSet.getString("review");
        Review review = new Review(email,hash, productName, update, customer_review);
        reviews.add(review);
      }
      return reviews;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
