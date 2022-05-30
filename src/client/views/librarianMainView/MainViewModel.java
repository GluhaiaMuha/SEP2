package client.views.librarianMainView;

import client.model.LibraryModel;
import shared.transferObj.Book;
import shared.transferObj.CD;
import shared.transferObj.Movie;
import shared.transferObj.Software;

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

  public List<Book> readBooks()
  {
    return libraryModel.readBooks();
  }

  public List<Movie> readMovies()
  {
    return libraryModel.readMovies();
  }

  public List<CD> readCDS()
  {
    return libraryModel.readCDS();
  }

  public List<Software> readSoftwares()
  {
    return libraryModel.readSoftwares();
  }

  public List<Book> readBooksByTitle(String searchString)
  {
    return libraryModel.readBooksByTitle(searchString);
  }

  public List<Movie> readMoviesByTitle(String searchString)
  {
    return libraryModel.readMoviesByTitle(searchString);
  }

  public List<CD> readCDsByName(String searchString)
  {
    return libraryModel.readCDsByName(searchString);
  }

  public List<Software> readSoftwaresByName(String searchString)
  {
    return libraryModel.readSoftwaresByName(searchString);
  }

  public Book readBookByTitle(String searchString)
  {
    return libraryModel.readBookByTitle(searchString);
  }

  public Movie readMovieByTitle(String searchString)
  {
    return libraryModel.readMovieByTitle(searchString);
  }

  public CD readCDByName(String searchString)
  {
    return libraryModel.readCDByName(searchString);
  }

  public Software readSoftwareByName(String searchString)
  {
    return libraryModel.readSoftwareByName(searchString);
  }

  public void update(String tableName, String whereClause, Object obj)
  {
    libraryModel.update(tableName, whereClause, obj);
  }

  public void delete(String tableName, String product_hash)
  {
    libraryModel.delete(tableName, product_hash);
  }

  public void insert(String tableName, Object obj)
  {
    libraryModel.insert(tableName, obj);
  }
}
