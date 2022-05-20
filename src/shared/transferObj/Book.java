package shared.transferObj;

public class Book extends Product
{
  private String title;
  private String author;
  private int pageCount;
  private String genre;
  private int publication_year;

  public Book(String hash, String title,String author ,int pageCount, String genre, int publication_year, int amountInStock)
  {
    super(hash, amountInStock);
    this.title = title;
    this.author = author;
    this.pageCount = pageCount;
    this.genre = genre;
    this.publication_year = publication_year;
  }

  public String getTitle()
  {
    return title;
  }

  public String getAuthor()
  {
    return author;
  }

  public int getPageCount()
  {
    return pageCount;
  }

  public String getGenre()
  {
    return genre;
  }

  public int getPublication_year()
  {
    return publication_year;
  }
}
