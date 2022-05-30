package server.database.Librarian.ManageProducts;

import server.database.DatabaseFront;
import shared.transferObj.Book;
import shared.transferObj.CD;
import shared.transferObj.Movie;
import shared.transferObj.Software;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManageProductsDAOImpl implements ManageProductsDAO
{
  private static ManageProductsDAO instance = new ManageProductsDAOImpl();

  public static ManageProductsDAO getInstance(){
    return instance;
  }

  @Override public void update(String tableName, String whereClause, Object obj)
  {
    if (tableName.equals("book"))
    {
      try(Connection connection = DatabaseFront.getInstance().getConnection())
      {
        Book book = (Book) obj;

        PreparedStatement statement = connection.prepareStatement(
            "UPDATE "+ tableName + " SET hash = ?, title = ?, author = ?, pageCount = ?, genre = ?, publication_year = ?, amountInStock = ? WHERE " + whereClause);
        statement.setString(1, book.getHash());
        statement.setString(2, book.getTitle());
        statement.setString(3, book.getAuthor());
        statement.setInt(4, book.getPageCount());
        statement.setString(5, book.getGenre());
        statement.setInt(6, book.getPublication_year());
        statement.setInt(7, book.getAmountInStock());
        statement.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    if (tableName.equals("movie"))
    {
      try(Connection connection = DatabaseFront.getInstance().getConnection())
      {
        Movie movie = (Movie) obj;

        PreparedStatement statement = connection.prepareStatement(
            "UPDATE "+ tableName + " SET hash = ?, title = ?, director = ?, release_year = ?, length = ?, amountInStock = ? WHERE " + whereClause);
        statement.setString(1, movie.getHash());
        statement.setString(2, movie.getTitle());
        statement.setString(3, movie.getDirector());
        statement.setInt(4, movie.getRelease_year());
        statement.setInt(5, movie.getLength());
        statement.setInt(6, movie.getAmountInStock());
        statement.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    if (tableName.equals("cd"))
    {
      try(Connection connection = DatabaseFront.getInstance().getConnection())
      {
        CD cd = (CD) obj;

        PreparedStatement statement = connection.prepareStatement(
            "UPDATE "+ tableName + " SET hash = ?, name = ?, capacity = ?, usage = ?, amountInStock = ? WHERE " + whereClause);
        statement.setString(1, cd.getHash());
        statement.setString(2, cd.getName());
        statement.setInt(3, cd.getCapacity());
        statement.setString(4, cd.getUsage());
        statement.setInt(5, cd.getAmountInStock());
        statement.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    if (tableName.equals("software"))
    {
      try(Connection connection = DatabaseFront.getInstance().getConnection())
      {
        Software software = (Software) obj;

        PreparedStatement statement = connection.prepareStatement(
            "UPDATE "+ tableName + " SET hash = ?, name = ?, type = ?, version = ?, license_type = ?, amountInStock = ? WHERE " + whereClause);
        statement.setString(1, software.getHash());
        statement.setString(2, software.getName());
        statement.setString(3, software.getType());
        statement.setString(4, software.getVersion());
        statement.setString(5, software.getLicense_type());
        statement.setInt(6, software.getAmountInStock());
        statement.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }

  @Override public void delete(String tableName, String product_hash)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "DELETE FROM review_" + tableName + " WHERE product_hash = '" + product_hash + "'");
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "DELETE FROM " + tableName + " WHERE hash = '" + product_hash + "'");
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void insert(String tableName, Object obj)
  {
    if (tableName.equals("book"))
    {
      try(Connection connection = DatabaseFront.getInstance().getConnection())
      {
        Book book = (Book) obj;
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO " + tableName + "(hash, title, author, pageCount, genre, publication_year, amountInStock) VALUES (?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, book.getHash());
        statement.setString(2, book.getTitle());
        statement.setString(3, book.getAuthor());
        statement.setInt(4, book.getPageCount());
        statement.setString(5, book.getGenre());
        statement.setInt(6, book.getPublication_year());
        statement.setInt(7, book.getAmountInStock());
        statement.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    if (tableName.equals("movie"))
    {
      try(Connection connection = DatabaseFront.getInstance().getConnection())
      {
        Movie movie = (Movie) obj;
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO " + tableName + "(hash, title, director, release_year, length, amountInStock) VALUES (?, ?, ?, ?, ?, ?)");
        statement.setString(1, movie.getHash());
        statement.setString(2, movie.getTitle());
        statement.setString(3, movie.getDirector());
        statement.setInt(4, movie.getRelease_year());
        statement.setInt(5, movie.getLength());
        statement.setInt(6, movie.getAmountInStock());
        statement.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    if (tableName.equals("cd"))
    {
      try(Connection connection = DatabaseFront.getInstance().getConnection())
      {
        CD cd = (CD) obj;
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO " + tableName + "(hash, name, capacity, usage, amountInStock) VALUES (?, ?, ?, ?, ?)");
        statement.setString(1, cd.getHash());
        statement.setString(2, cd.getName());
        statement.setInt(3, cd.getCapacity());
        statement.setString(4, cd.getUsage());
        statement.setInt(5, cd.getAmountInStock());
        statement.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    if (tableName.equals("software"))
    {
      try(Connection connection = DatabaseFront.getInstance().getConnection())
      {
        Software software = (Software) obj;
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO " + tableName + "(hash, name, type, version, license_type, amountInStock) VALUES (?, ?, ?, ?, ?, ?)");
        statement.setString(1, software.getHash());
        statement.setString(2, software.getName());
        statement.setString(3, software.getType());
        statement.setString(4, software.getVersion());
        statement.setString(5, software.getLicense_type());
        statement.setInt(6, software.getAmountInStock());
        statement.executeUpdate();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
}
