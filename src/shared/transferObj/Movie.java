package shared.transferObj;

import javafx.scene.control.Button;

public class Movie
{
  private int ISBN;
  private String title;
  private String genre;
  private String author;
  private int pgCount;
  private int year;
  private String status; //TODO: Change later according to db.
  private int count;


  public Movie(String title, String author, int year, int pgCount, String genre, String status, int ISBN, int count)
  {
    this.ISBN = ISBN;
    this.title = title;
    this.genre = genre;
    this.author = author;
    this.pgCount = pgCount;
    this.year = year;
    this.status = status;
    this.count = count;
  }

//  public Movie(String title, String author, int year, int pgCount, String genre, String status, int ISBN){
//    this.ISBN = ISBN;
//    this.title = title;
//    this.genre = genre;
//    this.author = author;
//    this.pgCount = pgCount;
//    this.year = year;
//    this.status = status;
//  }

  public int getISBN()
  {
    return ISBN;
  }

  public void setISBN(int ISBN)
  {
    this.ISBN = ISBN;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getGenre()
  {
    return genre;
  }

  public void setGenre(String genre)
  {
    this.genre = genre;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public int getPgCount()
  {
    return pgCount;
  }

  public void setPgCount(int pgCount)
  {
    this.pgCount = pgCount;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public String getStatus()
  {
    return status;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  public int getCount()
  {
    return count;
  }

  public void setCount(int count)
  {
    this.count = count;
  }
}
