package client;

import javafx.application.Application;
import server.database.DatabaseInterface;
import server.database.DatabaseManager;
import shared.transferObj.Book;
import shared.transferObj.Movie;

import java.sql.SQLException;

public class RunApp
{
  private static DatabaseInterface createTableExample = new DatabaseManager();

  public static void main(String[] args) throws SQLException
  {
//    createTableExample.insert("movie", new Movie("1", "Harry Potter: 1", "J.K Rowling", 2001, 120, 15));
//    createTableExample.insert("movie", new Movie("2","Harry Potter: 2", "J.K Rowling", 2002, 180, 3 ));
//    createTableExample.insert("movie", new Movie("3", "Harry Potter: 3","J.K Rowling", 2003, 90 ,4 ));
//
//    createTableExample.insert("book", new Book("14214", "Harry Potter: В пойсках Кабана", "Marius Babin", 300, "Fantasy", 2022, 3));

    Application.launch(LibraryApp.class);
  }
}
