package server.database.General.ProductInfo;

import server.database.DatabaseFront;
import shared.transferObj.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductInfoDAOImpl implements ProductInfoDAO
{
  private static ProductInfoDAO instance = new ProductInfoDAOImpl();

  public static ProductInfoDAO getInstance(){
    return instance;
  }

  @Override public List<Object> read(String tableName)
  {
    if (tableName.equals("product"))
    {
      try(Connection connection = DatabaseFront.getInstance().getConnection())
      {
        PreparedStatement statement = connection.prepareStatement(
            "SELECT * FROM " + tableName);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Object> products = new ArrayList<>();
        while (resultSet.next())
        {
          String hash = resultSet.getString("hash");
          int amountInStock = resultSet.getInt("amountInStock");
          Product product = new Product(hash, amountInStock);
          products.add(product);
        }
        return products;
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    if (tableName.equals("book"))
    {
      try(Connection connection = DatabaseFront.getInstance().getConnection())
      {
        PreparedStatement statement = connection.prepareStatement(
            "SELECT * FROM "+ tableName);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Object> books = new ArrayList<>();
        while (resultSet.next())
        {
          String hash = resultSet.getString("hash");
          String title = resultSet.getString("title");
          String author = resultSet.getString("author");
          int pageCount = resultSet.getInt("pageCount");
          String genre = resultSet.getString("genre");
          int publication_year = resultSet.getInt("publication_year");
          int amountInStock = resultSet.getInt("amountInStock");
          Book book = new Book(hash, title, author, pageCount, genre, publication_year, amountInStock);
          books.add(book);
        }
        return books;
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
        PreparedStatement statement = connection.prepareStatement(
            "SELECT * FROM "+ tableName);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Object> movies = new ArrayList<>();
        while (resultSet.next())
        {
          String hash = resultSet.getString("hash");
          String title = resultSet.getString("title");
          String director = resultSet.getString("director");
          int release_year = resultSet.getInt("release_year");
          int length = resultSet.getInt("length");
          int amountInStock = resultSet.getInt("amountInStock");
          Movie movie = new Movie(hash, title, director, release_year, length, amountInStock);
          movies.add(movie);
        }
        return movies;
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
        PreparedStatement statement = connection.prepareStatement(
            "SELECT * FROM "+ tableName);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Object> cds = new ArrayList<>();
        while (resultSet.next())
        {
          String hash = resultSet.getString("hash");
          String name = resultSet.getString("name");
          int capacity = resultSet.getInt("capacity");
          String usage = resultSet.getString("usage");
          int amountInStock = resultSet.getInt("amountInStock");
          CD cd = new CD(hash, name, capacity, usage, amountInStock);
          cds.add(cd);
        }
        return cds;
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
        PreparedStatement statement = connection.prepareStatement(
            "SELECT * FROM "+ tableName);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Object> softwares = new ArrayList<>();
        while (resultSet.next())
        {
          String hash = resultSet.getString("hash");
          String name = resultSet.getString("name");
          String type = resultSet.getString("type");
          String version = resultSet.getString("version");
          String license_type = resultSet.getString("license_type");
          int amountInStock = resultSet.getInt("amountInStock");
          Software software = new Software(hash, name, type, version, license_type, amountInStock);
          softwares.add(software);
        }
        return softwares;
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
    return null;
  }

  @Override public List<Book> readBooks()
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM book");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Book> books = new ArrayList<>();
      while (resultSet.next())
      {
        String hash = resultSet.getString("hash");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        int pageCount = resultSet.getInt("pageCount");
        String genre = resultSet.getString("genre");
        int publication_year = resultSet.getInt("publication_year");
        int amountInStock = resultSet.getInt("amountInStock");
        Book book = new Book(hash, title, author, pageCount, genre, publication_year, amountInStock);
        books.add(book);
      }
      return books;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;  }

  @Override public List<Movie> readMovies()
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM movie");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Movie> movies = new ArrayList<>();
      while (resultSet.next())
      {
        String hash = resultSet.getString("hash");
        String title = resultSet.getString("title");
        String director = resultSet.getString("director");
        int release_year = resultSet.getInt("release_year");
        int length = resultSet.getInt("length");
        int amountInStock = resultSet.getInt("amountInStock");
        Movie movie = new Movie(hash, title, director, release_year, length, amountInStock);
        movies.add(movie);
      }
      return movies;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public List<CD> readCDS()
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM cd");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<CD> cds = new ArrayList<>();
      while (resultSet.next())
      {
        String hash = resultSet.getString("hash");
        String name = resultSet.getString("name");
        int capacity = resultSet.getInt("capacity");
        String usage = resultSet.getString("usage");
        int amountInStock = resultSet.getInt("amountInStock");
        CD cd = new CD(hash, name, capacity, usage, amountInStock);
        cds.add(cd);
      }
      return cds;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public List<Software> readSoftwares()
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM software");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Software> softwares = new ArrayList<>();
      while (resultSet.next())
      {
        String hash = resultSet.getString("hash");
        String name = resultSet.getString("name");
        String type = resultSet.getString("type");
        String version = resultSet.getString("version");
        String license_type = resultSet.getString("license_type");
        int amountInStock = resultSet.getInt("amountInStock");
        Software software = new Software(hash, name, type, version, license_type, amountInStock);
        softwares.add(software);
      }
      return softwares;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public List<Book> readBooksByTitle(String searchString)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM book WHERE title LIKE ?");
      statement.setString(1, "%" + searchString + "%");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Book> books = new ArrayList<>();
      while (resultSet.next())
      {
        String hash = resultSet.getString("hash");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        int pageCount = resultSet.getInt("pageCount");
        String genre = resultSet.getString("genre");
        int publication_year = resultSet.getInt("publication_year");
        int amountInStock = resultSet.getInt("amountInStock");
        Book book = new Book(hash, title, author, pageCount, genre, publication_year, amountInStock);
        books.add(book);
      }
      return books;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public List<Movie> readMoviesByTitle(String searchString)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM movie WHERE title LIKE ?");
      statement.setString(1, "%" + searchString + "%");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Movie> movies = new ArrayList<>();
      while (resultSet.next())
      {
        String hash = resultSet.getString("hash");
        String title = resultSet.getString("title");
        String director = resultSet.getString("director");
        int release_year = resultSet.getInt("release_year");
        int length = resultSet.getInt("length");
        int amountInStock = resultSet.getInt("amountInStock");
        Movie movie = new Movie(hash, title, director, release_year, length, amountInStock);
        movies.add(movie);
      }
      return movies;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public List<CD> readCDsByName(String searchString)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM cd WHERE name LIKE ?");
      statement.setString(1, "%" + searchString + "%");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<CD> cds = new ArrayList<>();
      while (resultSet.next())
      {
        String hash = resultSet.getString("hash");
        String name = resultSet.getString("name");
        int capacity = resultSet.getInt("capacity");
        String usage = resultSet.getString("usage");
        int amountInStock = resultSet.getInt("amountInStock");
        CD cd = new CD(hash, name, capacity, usage, amountInStock);
        cds.add(cd);
      }
      return cds;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public List<Software> readSoftwaresByName(String searchString)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM software WHERE name LIKE ?");
      statement.setString(1,"%" + searchString + "%");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Software> softwares = new ArrayList<>();
      while (resultSet.next())
      {
        String hash = resultSet.getString("hash");
        String name = resultSet.getString("name");
        String type = resultSet.getString("type");
        String version = resultSet.getString("version");
        String license_type = resultSet.getString("license_type");
        int amountInStock = resultSet.getInt("amountInStock");
        Software software = new Software(hash, name, type, version, license_type, amountInStock);
        softwares.add(software);
      }
      return softwares;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public Book readBookByTitle(String searchString)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM book WHERE title LIKE ?");
      statement.setString(1, "%" + searchString + "%");
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String hash = resultSet.getString("hash");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        int pageCount = resultSet.getInt("pageCount");
        String genre = resultSet.getString("genre");
        int publication_year = resultSet.getInt("publication_year");
        int amountInStock = resultSet.getInt("amountInStock");
        return new Book(hash, title, author, pageCount, genre, publication_year, amountInStock);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public Movie readMovieByTitle(String searchString)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM movie WHERE title LIKE ?");
      statement.setString(1, "%" + searchString + "%");
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String hash = resultSet.getString("hash");
        String title = resultSet.getString("title");
        String director = resultSet.getString("director");
        int release_year = resultSet.getInt("release_year");
        int length = resultSet.getInt("length");
        int amountInStock = resultSet.getInt("amountInStock");
        return new Movie(hash, title, director, release_year, length, amountInStock);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public CD readCDByName(String searchString)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM cd WHERE name LIKE ?");
      statement.setString(1, "%" + searchString + "%");
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String hash = resultSet.getString("hash");
        String name = resultSet.getString("name");
        int capacity = resultSet.getInt("capacity");
        String usage = resultSet.getString("usage");
        int amountInStock = resultSet.getInt("amountInStock");
        return new CD(hash, name, capacity, usage, amountInStock);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public Software readSoftwareByName(String searchString)
  {
    try(Connection connection = DatabaseFront.getInstance().getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM software WHERE name LIKE ?");
      statement.setString(1, "%" + searchString + "%");
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String hash = resultSet.getString("hash");
        String name = resultSet.getString("name");
        String type = resultSet.getString("type");
        String version = resultSet.getString("version");
        String license_type = resultSet.getString("license_type");
        int amountInStock = resultSet.getInt("amountInStock");
        return new Software(hash, name, type, version, license_type, amountInStock);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
