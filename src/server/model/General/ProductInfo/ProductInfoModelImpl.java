package server.model.General.ProductInfo;

import server.database.General.ProductInfo.ProductInfoDAOImpl;
import shared.transferObj.Book;
import shared.transferObj.CD;
import shared.transferObj.Movie;
import shared.transferObj.Software;

import java.util.List;

public class ProductInfoModelImpl implements ProductInfoModel
{
  private static ProductInfoModel instance =  new ProductInfoModelImpl();

  public static ProductInfoModel getInstance(){
    return instance;
  }


  @Override public List<Object> read(String tableName)
  {
    return ProductInfoDAOImpl.getInstance().read(tableName);
  }

  @Override public List<Book> readBooks()
  {
    return ProductInfoDAOImpl.getInstance().readBooks();
  }

  @Override public List<Movie> readMovies()
  {
    return ProductInfoDAOImpl.getInstance().readMovies();
  }

  @Override public List<CD> readCDS()
  {
    return ProductInfoDAOImpl.getInstance().readCDS();
  }

  @Override public List<Software> readSoftwares()
  {
    return ProductInfoDAOImpl.getInstance().readSoftwares();
  }

  @Override public List<Book> readBooksByTitle(String searchString)
  {
    return ProductInfoDAOImpl.getInstance().readBooksByTitle(searchString);
  }

  @Override public List<Movie> readMoviesByTitle(String searchString)
  {
    return ProductInfoDAOImpl.getInstance().readMoviesByTitle(searchString);
  }

  @Override public List<CD> readCDsByName(String searchString)
  {
    return ProductInfoDAOImpl.getInstance().readCDsByName(searchString);
  }

  @Override public List<Software> readSoftwaresByName(String searchString)
  {
    return ProductInfoDAOImpl.getInstance().readSoftwaresByName(searchString);
  }

  @Override public Book readBookByTitle(String searchString)
  {
    return ProductInfoDAOImpl.getInstance().readBookByTitle(searchString);
  }

  @Override public Movie readMovieByTitle(String searchString)
  {
    return ProductInfoDAOImpl.getInstance().readMovieByTitle(searchString);
  }

  @Override public CD readCDByName(String searchString)
  {
    return ProductInfoDAOImpl.getInstance().readCDByName(searchString);
  }

  @Override public Software readSoftwareByName(String searchString)
  {
    return ProductInfoDAOImpl.getInstance().readSoftwareByName(searchString);
  }

  @Override public Object readProductByHash(String table, String productHash)
  {
    return ProductInfoDAOImpl.getInstance().readProductByHash(table, productHash);
  }
}
