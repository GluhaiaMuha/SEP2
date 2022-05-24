package shared.transferObj;

import java.io.Serializable;

public class Movie extends Product implements Serializable
{
  private String title;
  private String director;
  private int length;
  private int release_year;

  public Movie(String hash, String title, String director, int release_year, int length,int amountInStock)
  {
    super(hash,amountInStock);
    this.title = title;
    this.director = director;
    this.length = length;
    this.release_year = release_year;
  }

  public String getTitle()
  {
    return title;
  }

  public String getDirector()
  {
    return director;
  }

  public int getLength()
  {
    return length;
  }

  public int getRelease_year()
  {
    return release_year;
  }

}
