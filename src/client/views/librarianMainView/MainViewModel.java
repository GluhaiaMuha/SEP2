package client.views.librarianMainView;

import client.model.LibraryModel;
import shared.transferObj.*;

import java.util.List;

public class MainViewModel
{
  private LibraryModel libraryModel;

  public MainViewModel(LibraryModel libraryModel)
  {
    this.libraryModel = libraryModel;
  }

  public List<Object> read(String tableName)
  {
    return libraryModel.read(tableName);
  }

  /**
   * Return a list of type Book from the database
   *
   * @return List
   */
  public List<Book> readBooks()
  {
    return libraryModel.readBooks();
  }

  /**
   * Return a list of type Movie from the database
   *
   * @return List
   */
  public List<Movie> readMovies()
  {
    return libraryModel.readMovies();
  }

  /**
   * Return a list of type CD from the database
   *
   * @return List
   */
  public List<CD> readCDS()
  {
    return libraryModel.readCDS();
  }

  /**
   * Return a list of type Software from the database
   *
   * @return List
   */
  public List<Software> readSoftwares()
  {
    return libraryModel.readSoftwares();
  }

  /**
   * Return a list of type Book when searched by title
   *
   * @param searchString book title
   * @return List
   */
  public List<Book> readBooksByTitle(String searchString)
  {
    return libraryModel.readBooksByTitle(searchString);
  }

  /**
   * Return a list of type Movie when searched by title
   *
   * @param searchString Movie Title
   * @return List
   */
  public List<Movie> readMoviesByTitle(String searchString)
  {
    return libraryModel.readMoviesByTitle(searchString);
  }

  /**
   * Return a list of type CD when searched by name
   *
   * @param searchString CD name
   * @return List
   */
  public List<CD> readCDsByName(String searchString)
  {
    return libraryModel.readCDsByName(searchString);
  }

  /**
   * Return a list of type Software when searched by name
   *
   * @param searchString Software Name
   * @return List
   */
  public List<Software> readSoftwaresByName(String searchString)
  {
    return libraryModel.readSoftwaresByName(searchString);
  }

  /**
   * Return a book Object when searched by title
   *
   * @param searchString Book title
   * @return Book
   */
  public Book readBookByTitle(String searchString)
  {
    return libraryModel.readBookByTitle(searchString);
  }

  /**
   * Return a movie Object when searched by title
   *
   * @param searchString Movie Title
   * @return Movie
   */
  public Movie readMovieByTitle(String searchString)
  {
    return libraryModel.readMovieByTitle(searchString);
  }

  /**
   * Return a CD Object when searched by name
   *
   * @param searchString CD name
   * @return CD
   */
  public CD readCDByName(String searchString)
  {
    return libraryModel.readCDByName(searchString);
  }

  /**
   * Return a Software Object when searched by name
   *
   * @param searchString Software name
   * @return Software
   */
  public Software readSoftwareByName(String searchString)
  {
    return libraryModel.readSoftwareByName(searchString);
  }

  /**
   * Update a product by specified whereClause
   *
   * @param tableName DB table name
   * @param whereClause DB Where Clause
   * @param obj Object
   */
  public void update(String tableName, String whereClause, Object obj)
  {
    libraryModel.update(tableName, whereClause, obj);
  }

  /**
   * Delete a product by hash
   *
   * @param tableName DB table name
   * @param product_hash Product Hash
   */
  public void delete(String tableName, String product_hash)
  {
    libraryModel.delete(tableName, product_hash);
  }

  /**
   * Insert an object into specified db table
   *
   * @param tableName DB table name
   * @param obj Object
   */
  public void insert(String tableName, Object obj)
  {
    libraryModel.insert(tableName, obj);
  }

  /**
   * Return a product by hash
   *
   * @param table DB table name
   * @param productHash Product Hash
   * @return Object
   */
  public Object readProductByHash(String table, String productHash)
  {
    return libraryModel.readProductByHash(table, productHash);
  }

  /**
   * Returns all rented products
   *
   * @param product Rented product
   * @return List
   */
  public List<Rent> readRents(String product)
  {
    return libraryModel.readRents(product);
  }
}
