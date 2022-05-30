package server.model.General.ProductInfo;

import shared.transferObj.Book;
import shared.transferObj.CD;
import shared.transferObj.Movie;
import shared.transferObj.Software;

import java.util.List;

public interface ProductInfoModel
{
  List<Object> read(String tableName);

  List<Book> readBooks();

  List<Movie> readMovies();

  List<CD> readCDS();

  List<Software> readSoftwares();

  List<Book> readBooksByTitle(String searchString);

  List<Movie> readMoviesByTitle(String searchString);

  List<CD> readCDsByName(String searchString);

  List<Software> readSoftwaresByName(String searchString) ;

  Book readBookByTitle(String searchString);

  Movie readMovieByTitle(String searchString);

  CD readCDByName(String searchString);

  Software readSoftwareByName(String searchString);

  Object readProductByHash(String table, String productHash);
}
