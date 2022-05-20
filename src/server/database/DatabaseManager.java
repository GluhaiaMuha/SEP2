package server.database;

import shared.transferObj.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager{

    private final DatabaseFront database = DatabaseFront.getInstance();

    //    @Override //@TODO make this work for tables where one of the values is "SERIAL" type
    //    public void insert(String tableName, String[] fields) {
    //        Connection connection = null;
    //        String sqlString = "INSERT INTO libraryhorsens." + tableName + " VALUES(DEFAULT,'" + fields + "');";
    //        try {
    //            connection = database.getConnection();
    //        } catch (SQLException e) {
    //            System.err.println("Error connecting to the database!");
    //        }
    //        try {
    //            PreparedStatement statement = connection.prepareStatement(sqlString);
    //            statement.executeUpdate();
    //        } catch (SQLException e) {
    //            e.printStackTrace();
    //        } finally {
    //            try {
    //                connection.close();
    //            } catch (SQLException e) {
    //                e.printStackTrace();
    //            }
    //        }
    //    }
    //
    //    @Override
    //    public void update(String tableName, String field, String whereClause) {
    //
    //    }
    //
    //    //    @Override
    //    //    public void delete(String tableName, String whereClause) {
    //    //        String sqlString = "DELETE FROM libraryhorsens. " + tableName +" WHERE " + whereClause;
    //    //        try {
    //    //            Connection connection = database.getConnection();
    //    //            PreparedStatement statement = connection.prepareStatement(sqlString);
    //    //            statement.execute();
    //    //        } catch (SQLException e) {
    //    //            e.printStackTrace();
    //    //        }
    //    //    }

    public Object insert(String tableName, Object obj) throws SQLException
    {
        //        if (tableName.equals("product"))
        //        {
        //            try(Connection connection = database.getConnection())
        //            {
        //                Product product = (Product) obj;
        //                PreparedStatement statement = connection.prepareStatement(
        //                    "INSERT INTO libraryhorsens." + tableName + "(hash, amountInStock) VALUES (?, ?)");
        //                statement.setString(1, product.getHash());
        //                statement.setInt(2, product.getAmountInStock());
        //                statement.executeUpdate();
        //                return new Product(product.getHash(), product.getAmountInStock());
        //            }
        //        }
        if (tableName.equals("book"))
        {
            try(Connection connection = database.getConnection())
            {
                Book book = (Book) obj;
                PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO libraryhorsens." + tableName + "(hash, title, author, pageCount, genre, publication_year, amountInStock) VALUES (?, ?, ?, ?, ?, ?, ?)");
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
        }
        if (tableName.equals("movie"))
        {
            try(Connection connection = database.getConnection())
            {
                Movie movie = (Movie) obj;
                PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO libraryhorsens." + tableName + "(hash, title, director, release_year, length, amountInStock) VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1, movie.getHash());
                statement.setString(2, movie.getTitle());
                statement.setString(3, movie.getDirector());
                statement.setInt(4, movie.getRelease_year());
                statement.setInt(5, movie.getLength());
                statement.setInt(6, movie.getAmountInStock());
                statement.executeUpdate();
                return new Movie(movie.getHash(), movie.getTitle(), movie.getDirector(), movie.getRelease_year(), movie.getLength(), movie.getAmountInStock());
            }
        }
        if (tableName.equals("cd"))
        {
            try(Connection connection = database.getConnection())
            {
                CD cd = (CD) obj;
                PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO libraryhorsens." + tableName + "(hash, name, capacity, usage, amountInStock) VALUES (?, ?, ?, ?, ?)");
                statement.setString(1, cd.getHash());
                statement.setString(2, cd.getName());
                statement.setInt(3, cd.getCapacity());
                statement.setString(4, cd.getUsage());
                statement.setInt(5, cd.getAmountInStock());
                statement.executeUpdate();
                return new CD(cd.getHash(), cd.getName(), cd.getCapacity(), cd.getUsage(), cd.getAmountInStock());
            }
        }
        if (tableName.equals("software"))
        {
            try(Connection connection = database.getConnection())
            {
                Software software = (Software) obj;
                PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO libraryhorsens." + tableName + "(hash, name, type, version, license_type, amountInStock) VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1, software.getHash());
                statement.setString(2, software.getName());
                statement.setString(3, software.getType());
                statement.setDouble(4, software.getVersion());
                statement.setString(5, software.getLicense_type());
                statement.setInt(6, software.getAmountInStock());
                statement.executeUpdate();
                return new Software(software.getHash(), software.getName(), software.getType(), software.getVersion(), software.getLicense_type(), software.getAmountInStock());
            }
        }
        return null;
    }

    public List<Object> read(String tableName) throws SQLException
    {
        if (tableName.equals("product"))
        {
            try(Connection connection = database.getConnection())
            {
                PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM libraryhorsens." + tableName);
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
        }
        if (tableName.equals("book"))
        {
            try(Connection connection = database.getConnection())
            {
                PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM libraryhorsens."+ tableName);
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
        }
        if (tableName.equals("movie"))
        {
            try(Connection connection = database.getConnection())
            {
                PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM libraryhorsens."+ tableName);
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
        }
        if (tableName.equals("cd"))
        {
            try(Connection connection = database.getConnection())
            {
                PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM libraryhorsens."+ tableName);
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
        }
        if (tableName.equals("software"))
        {
            try(Connection connection = database.getConnection())
            {
                PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM libraryhorsens."+ tableName);
                ResultSet resultSet = statement.executeQuery();
                ArrayList<Object> softwares = new ArrayList<>();
                while (resultSet.next())
                {
                    String hash = resultSet.getString("hash");
                    String name = resultSet.getString("name");
                    String type = resultSet.getString("type");
                    double version = resultSet.getDouble("version");
                    String license_type = resultSet.getString("license_type");
                    int amountInStock = resultSet.getInt("amountInStock");
                    Software software = new Software(hash, name, type, version, license_type, amountInStock);
                    softwares.add(software);
                }
                return softwares;
            }
        }
        return null;
    }

    public Login readUserLogin(String tableName, Login login) throws SQLException
    {
        try(Connection connection = database.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM libraryhorsens." + tableName + " WHERE email = " + login.getE_mail());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                String e_mail = resultSet.getString("email");
                String password1 = resultSet.getString("password");
                return new Login(e_mail, password1);
            }
            else
                return null;
        }
    }

    public Register readUserRegister(Register register) throws SQLException
    {
        try(Connection connection = database.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "SELECT f_name, l_name, email, password, phone FROM libraryhorsens.customer JOIN customer_password ON customer.email = customer_password.email WHERE email = " + register.getE_mail());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                String f_name = resultSet.getString("f_name");
                String l_name = resultSet.getString("l_name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String phone = resultSet.getString("phone");
                return new Register(f_name, l_name, email, password, phone);
            }
            else return null;
        }
    }

    public void insertUserRegister(Register register) throws SQLException
    {
        try(Connection connection = database.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO libraryhorsens.customer (email, f_name, l_name, phone) VALUES (?, ?, ?, ?);"
                    + "INSERT INTO libraryhorsens.customer_password (email, password) VALUES (?, ?);");
            statement.setString(1, register.getE_mail());
            statement.setString(2, register.getF_name());
            statement.setString(3, register.getL_name());
            statement.setString(4, register.getPhone());
            statement.setString(5, register.getE_mail());
            statement.setString(6, register.getPassword());
            statement.executeUpdate();
        }
    }

    public void update(String tableName, String whereClause, Object obj) throws SQLException
    {
        //        if (tableName.equals("product"))
        //        {
        //            try(Connection connection = database.getConnection())
        //            {
        //                Product product = (Product) obj;
        //
        //                PreparedStatement statement = connection.prepareStatement(
        //                    "UPDATE libraryhorsens."+ tableName + " SET hash = ?, amountInStock = ? WHERE "+ whereClause);
        //                statement.setString(1, product.getHash());
        //                statement.setInt(2, product.getAmountInStock());
        //                statement.executeUpdate();
        //            }
        //        }
        if (tableName.equals("book"))
        {
            try(Connection connection = database.getConnection())
            {
                Book book = (Book) obj;

                PreparedStatement statement = connection.prepareStatement(
                    "UPDATE libraryhorsens."+ tableName + " SET hash = ?, title = ?, author = ?, pageCount = ?, genre = ?, publication_year = ?, amountInStock = ? WHERE " + whereClause);
                statement.setString(1, book.getHash());
                statement.setString(2, book.getTitle());
                statement.setString(3, book.getAuthor());
                statement.setInt(4, book.getPageCount());
                statement.setString(5, book.getGenre());
                statement.setInt(6, book.getPublication_year());
                statement.setInt(7, book.getAmountInStock());
                statement.executeUpdate();
            }
        }
        if (tableName.equals("movie"))
        {
            try(Connection connection = database.getConnection())
            {
                Movie movie = (Movie) obj;

                PreparedStatement statement = connection.prepareStatement(
                    "UPDATE libraryhorsens."+ tableName + " SET hash = ?, title = ?, director = ?, release_year = ?, length = ?, amountInStock = ? WHERE " + whereClause);
                statement.setString(1, movie.getHash());
                statement.setString(2, movie.getTitle());
                statement.setString(3, movie.getDirector());
                statement.setInt(4, movie.getRelease_year());
                statement.setInt(5, movie.getLength());
                statement.setInt(6, movie.getAmountInStock());
                statement.executeUpdate();
            }
        }
        if (tableName.equals("cd"))
        {
            try(Connection connection = database.getConnection())
            {
                CD cd = (CD) obj;

                PreparedStatement statement = connection.prepareStatement(
                    "UPDATE libraryhorsens."+ tableName + " SET hash = ?, name = ?, capacity = ?, usage = ?, amountInStock = ? WHERE " + whereClause);
                statement.setString(1, cd.getHash());
                statement.setString(2, cd.getName());
                statement.setInt(3, cd.getCapacity());
                statement.setString(4, cd.getUsage());
                statement.setInt(5, cd.getAmountInStock());
                statement.executeUpdate();
            }
        }
        if (tableName.equals("software"))
        {
            try(Connection connection = database.getConnection())
            {
                Software software = (Software) obj;

                PreparedStatement statement = connection.prepareStatement(
                    "UPDATE libraryhorsens."+ tableName + " SET hash = ?, name = ?, type = ?, version = ?, license_type = ?, amountInStock = ? WHERE " + whereClause);
                statement.setString(1, software.getHash());
                statement.setString(2, software.getName());
                statement.setString(3, software.getType());
                statement.setDouble(4, software.getVersion());
                statement.setString(5, software.getLicense_type());
                statement.setInt(6, software.getAmountInStock());
                statement.executeUpdate();
            }
        }
    }

    public void delete(String tableName, String whereClause) throws SQLException
    {
        //        if (tableName.equals("product"))
        //        {
        //            try(Connection connection = database.getConnection())
        //            {
        //                PreparedStatement statement = connection.prepareStatement(
        //                    "DELETE FROM libraryhorsens." + tableName + " WHERE " + whereClause);
        //                statement.executeUpdate();
        //            }
        //        }
        try(Connection connection = database.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM libraryhorsens." + tableName + " WHERE " + whereClause);
            statement.executeUpdate();
        }
    }
    //
    //    @Override
    //    public void startTransaction() {
    //
    //    }
    //
    //    @Override
    //    public void endTransaction() {
    //
    //    }
}
