package server.database;

import shared.transferObj.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager implements DatabaseInterface{

    private final DatabaseFront database = DatabaseFront.getInstance();
    private static DatabaseManager instance;

    public static DatabaseManager getInstance()
    {
        if(instance==null) instance = new DatabaseManager();
        return instance;
    }

    @Override
    public Object insert(String tableName, Object obj)
    {
        if (tableName.equals("book"))
        {
            try(Connection connection = database.getConnection())
            {
                Book book = (Book) obj;
                PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO " + tableName + "(hash, title, author, pageCount, genre, publication_year, amountInStock) VALUES (?, ?, ?, ?, ?, ?, ?)");
                statement.setString(1, book.getHash());
                statement.setString(2, book.getTitle());
                statement.setString(3, book.getAuthor());
                statement.setInt(4, book.getPageCount());
                statement.setString(5, book.getGenre());
                statement.setInt(6, book.getPublication_year());
                statement.setInt(7, book.getAmountInStock());
                statement.executeUpdate();
                return new Book(book.getHash(), book.getTitle(), book.getAuthor(), book.getPageCount(), book.getGenre(), book.getPublication_year(), book.getAmountInStock());
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (tableName.equals("movie"))
        {
            try(Connection connection = database.getConnection())
            {
                Movie movie = (Movie) obj;
                PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO " + tableName + "(hash, title, director, release_year, length, amountInStock) VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1, movie.getHash());
                statement.setString(2, movie.getTitle());
                statement.setString(3, movie.getDirector());
                statement.setInt(4, movie.getRelease_year());
                statement.setInt(5, movie.getLength());
                statement.setInt(6, movie.getAmountInStock());
                statement.executeUpdate();
                return new Movie(movie.getHash(), movie.getTitle(), movie.getDirector(), movie.getRelease_year(), movie.getLength(), movie.getAmountInStock());
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (tableName.equals("cd"))
        {
            try(Connection connection = database.getConnection())
            {
                CD cd = (CD) obj;
                PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO " + tableName + "(hash, name, capacity, usage, amountInStock) VALUES (?, ?, ?, ?, ?)");
                statement.setString(1, cd.getHash());
                statement.setString(2, cd.getName());
                statement.setInt(3, cd.getCapacity());
                statement.setString(4, cd.getUsage());
                statement.setInt(5, cd.getAmountInStock());
                statement.executeUpdate();
                return new CD(cd.getHash(), cd.getName(), cd.getCapacity(), cd.getUsage(), cd.getAmountInStock());
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (tableName.equals("software"))
        {
            try(Connection connection = database.getConnection())
            {
                Software software = (Software) obj;
                PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO " + tableName + "(hash, name, type, version, license_type, amountInStock) VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1, software.getHash());
                statement.setString(2, software.getName());
                statement.setString(3, software.getType());
                statement.setString(4, software.getVersion());
                statement.setString(5, software.getLicense_type());
                statement.setInt(6, software.getAmountInStock());
                statement.executeUpdate();
                return new Software(software.getHash(), software.getName(), software.getType(), software.getVersion(), software.getLicense_type(), software.getAmountInStock());
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Object> read(String tableName)
    {
        if (tableName.equals("product"))
        {
            try(Connection connection = database.getConnection())
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
            try(Connection connection = database.getConnection())
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
            try(Connection connection = database.getConnection())
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
            try(Connection connection = database.getConnection())
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
            try(Connection connection = database.getConnection())
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

    public List<Book> readBooks()
    {
        try(Connection connection = database.getConnection())
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
        return null;
    }

    public List<Movie> readMovies()
    {
        try(Connection connection = database.getConnection())
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

    public List<CD> readCDS()
    {
        try(Connection connection = database.getConnection())
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

    public List<Software> readSoftwares()
    {
        try(Connection connection = database.getConnection())
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

    public List<Book> readBooksByTitle(String searchString)
    {
        try(Connection connection = database.getConnection())
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

    public List<Movie> readMoviesByTitle(String searchString)
    {
        try(Connection connection = database.getConnection())
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

    public List<CD> readCDsByName(String searchString)
    {
        try(Connection connection = database.getConnection())
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

    public List<Software> readSoftwaresByName(String searchString)
    {
        try(Connection connection = database.getConnection())
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

    public Book readBookByTitle(String searchString)
    {
        try(Connection connection = database.getConnection())
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

    public Movie readMovieByTitle(String searchString)
    {
        try(Connection connection = database.getConnection())
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

    public CD readCDByName(String searchString)
    {
        try(Connection connection = database.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM movie WHERE title LIKE ?");
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

    public Software readSoftwareByName(String searchString) throws SQLException
    {
        try(Connection connection = database.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM movie WHERE title LIKE ?");
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

    public void rentProduct(String email, String productHash, Date dateFrom, Date dateTo)
    {
        try(Connection connection = database.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO rent (customer_email, product_hash, dateFrom, dateTo) VALUES (?, ?, ?, ?)");
            statement.setString(1, email);
            statement.setString(2, productHash);
            statement.setDate(3, dateFrom);
            statement.setDate(4, dateTo);
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Rent> readCustomerRents(String customer_email)
    {
        try(Connection connection = database.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM rent WHERE customer_email = '" + customer_email + "'");
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Rent> rents = new ArrayList<>();
            while (resultSet.next())
            {
                String email = resultSet.getString("customer_email");
                String hash = resultSet.getString("product_hash");
                Date dateFrom = resultSet.getDate("dateFrom");
                Date dateTo = resultSet.getDate("dateTo");
                Rent rent = new Rent(email, hash, dateFrom, dateTo);
                rents.add(rent);
            }
            return rents;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User readUserLogin(String tableName, String email, String password)
    {
        try(Connection connection = database.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT email, password, type FROM " + tableName + " WHERE email = '" + email + "' AND password = '" + password + "'");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                String e_mail = resultSet.getString("email");
                String user_password = resultSet.getString("password");
                String type = resultSet.getString("type");
                return new User(e_mail, user_password, type);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public User readUserRegister(String tableName, String email)
    {
        try(Connection connection = database.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT email, password, type FROM " + tableName + " WHERE email = '" + email + "'");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                String e_mail = resultSet.getString("email");
                String user_password = resultSet.getString("password");
                String type = resultSet.getString("type");
                return new User(e_mail, user_password, type);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertUserRegister(Customer customer)
    {
        try(Connection connection = database.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO customer (email, f_name, l_name, phone, password, type) VALUES (?, ?, ?, ?, ?, ?);");
            statement.setString(1, customer.getE_mail());
            statement.setString(2, customer.getF_name());
            statement.setString(3, customer.getL_name());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getPassword());
            statement.setString(6, customer.getUser());
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String tableName, String whereClause, Object obj)
    {
        if (tableName.equals("book"))
        {
            try(Connection connection = database.getConnection())
            {
                Book book = (Book) obj;

                PreparedStatement statement = connection.prepareStatement(
                    "UPDATE "+ tableName + " SET hash = ?, title = ?, author = ?, pageCount = ?, genre = ?, publication_year = ?, amountInStock = ? WHERE " + whereClause);
                statement.setString(1, book.getHash());
                statement.setString(2, book.getTitle());
                statement.setString(3, book.getAuthor());
                statement.setInt(4, book.getPageCount());
                statement.setString(5, book.getGenre());
                statement.setInt(6, book.getPublication_year());
                statement.setInt(7, book.getAmountInStock());
                statement.executeUpdate();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (tableName.equals("movie"))
        {
            try(Connection connection = database.getConnection())
            {
                Movie movie = (Movie) obj;

                PreparedStatement statement = connection.prepareStatement(
                    "UPDATE "+ tableName + " SET hash = ?, title = ?, director = ?, release_year = ?, length = ?, amountInStock = ? WHERE " + whereClause);
                statement.setString(1, movie.getHash());
                statement.setString(2, movie.getTitle());
                statement.setString(3, movie.getDirector());
                statement.setInt(4, movie.getRelease_year());
                statement.setInt(5, movie.getLength());
                statement.setInt(6, movie.getAmountInStock());
                statement.executeUpdate();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (tableName.equals("cd"))
        {
            try(Connection connection = database.getConnection())
            {
                CD cd = (CD) obj;

                PreparedStatement statement = connection.prepareStatement(
                    "UPDATE "+ tableName + " SET hash = ?, name = ?, capacity = ?, usage = ?, amountInStock = ? WHERE " + whereClause);
                statement.setString(1, cd.getHash());
                statement.setString(2, cd.getName());
                statement.setInt(3, cd.getCapacity());
                statement.setString(4, cd.getUsage());
                statement.setInt(5, cd.getAmountInStock());
                statement.executeUpdate();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (tableName.equals("software"))
        {
            try(Connection connection = database.getConnection())
            {
                Software software = (Software) obj;

                PreparedStatement statement = connection.prepareStatement(
                    "UPDATE "+ tableName + " SET hash = ?, name = ?, type = ?, version = ?, license_type = ?, amountInStock = ? WHERE " + whereClause);
                statement.setString(1, software.getHash());
                statement.setString(2, software.getName());
                statement.setString(3, software.getType());
                statement.setString(4, software.getVersion());
                statement.setString(5, software.getLicense_type());
                statement.setInt(6, software.getAmountInStock());
                statement.executeUpdate();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String tableName, String whereClause)
    {
        try(Connection connection = database.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM " + tableName + " WHERE " + whereClause);
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
