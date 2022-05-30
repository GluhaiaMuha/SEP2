package client.network;

import shared.network.ClientCallback;
import shared.network.RMIServer;
import shared.transferObj.*;

import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements Client, ClientCallback
{
  private PropertyChangeSupport support;
  private RMIServer server;

  private String email;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("Server");
      server.registerClient(this);
    } catch (RemoteException | NotBoundException e) {
      e.printStackTrace();
    }
  }

  @Override public void unRegisterClient()
  {
    try {
      server.unRegisterClient(this);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  @Override
  public User readUserRegister(String email)
  {
    User user = null;
    try
    {
      user = server.readUserRegister(email);
      if (user==null)
      {
        this.email = email;
      }
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public void newCustomer(Customer customer)
  {
    try
    {
      server.newCustomer(customer);
    }catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public User readUserLogin(String email, String password)
  {
    User user = null;
    try
    {
      user = server.readUserLogin(email, password);
      if (user!=null)
      {
        this.email = email;
      }
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return user;
  }

  @Override
  public List<Rent> readCustomerRents(String customer_email, String product)
  {
    List<Rent> rents = null;
    try
    {
      rents = server.readCustomerRents(customer_email, product);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return rents;
  }

  @Override public void removeRent(Rent rent, String product)
  {
    try
    {
      server.removeRent(rent, product);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void updateProductAmount(String tableName, String productHash)
  {
    try
    {
      server.updateProductAmount(tableName, productHash);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void rentProduct(String product, Rent rent)
  {
    try
    {
      server.rentProduct(product, rent);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<Object> read(String tableName)
  {
    List<Object> obj = null;
    try
    {
      obj = server.read(tableName);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return obj;
  }

  @Override public List<Book> readBooks()
  {
    List<Book> books = null;
    try
    {
      books = server.readBooks();
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return books;
  }

  @Override public List<Movie> readMovies()
  {
    List<Movie> movies = null;
    try
    {
      movies = server.readMovies();
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return movies;
  }

  @Override public List<CD> readCDS()
  {
    List<CD> cds = null;
    try
    {
      cds = server.readCDS();
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return cds;
  }

  @Override public List<Software> readSoftwares()
  {
    List<Software> softwares = null;
    try
    {
      softwares = server.readSoftwares();
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return softwares;
  }

  @Override public List<Book> readBooksByTitle(String searchString)
  {
    List<Book> books = null;
    try
    {
      books = server.readBooksByTitle(searchString);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return books;
  }

  @Override public List<Movie> readMoviesByTitle(String searchString)
  {
    List<Movie> movies = null;
    try
    {
      movies = server.readMoviesByTitle(searchString);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return movies;
  }

  @Override public List<CD> readCDsByName(String searchString)
  {
    List<CD> cds = null;
    try
    {
      cds = server.readCDsByName(searchString);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return cds;
  }

  @Override public List<Software> readSoftwaresByName(String searchString)
  {
    List<Software> softwares = null;
    try
    {
      softwares = server.readSoftwaresByName(searchString);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return softwares;
  }

  @Override public Book readBookByTitle(String searchString)
  {
    Book book = null;
    try
    {
      book = server.readBookByTitle(searchString);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return book;
  }

  @Override public Movie readMovieByTitle(String searchString)
  {
    Movie movie = null;
    try
    {
      movie = server.readMovieByTitle(searchString);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return movie;
  }

  @Override public CD readCDByName(String searchString)
  {
    CD cd = null;
    try
    {
      cd = server.readCDByName(searchString);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return cd;
  }

  @Override public Software readSoftwareByName(String searchString)
  {
    Software software = null;
    try
    {
      software = server.readSoftwareByName(searchString);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return software;
  }

  @Override public void update(String tableName, String whereClause, Object obj)
  {
    try
    {
      server.update(tableName, whereClause, obj);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void delete(String tableName, String product_hash)
  {
    try
    {
      server.delete(tableName, product_hash);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void insert(String tableName, Object obj)
  {
    try
    {
      server.insert(tableName, obj);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public Customer readCustomerInfo(String email)
  {
    Customer customer = null;
    try
    {
      customer = server.readCustomerInfo(email);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return customer;
  }

  @Override public void changeCustomerInfo(String email,String f_name, String l_name, String phone)
  {
    try
    {
      server.changeCustomerInfo(email, f_name, l_name, phone);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addReview(String product, Review review)
  {
    try
    {
      server.addReview(product, review);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<Review> readReview(String product)
  {
    List<Review> reviews = null;
    try
    {
      reviews = server.readReview(product);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return reviews;
  }

  @Override public List<Review> readReviewsByProductName(String searchString,
      String product)
  {
    List<Review> reviews = null;
    try
    {
      reviews = server.readReviewsByProductName(searchString, product);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return reviews;
  }

  @Override public void removeReview(Review review, String product)
  {
    try
    {
      server.removeReview(review, product);
    } catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public String getEmail()
  {
    return email;
  }
}
