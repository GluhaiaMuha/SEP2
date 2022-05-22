package server.database;

import javafx.collections.ObservableList;
import shared.transferObj.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface{
    Object insert(String tableName, Object obj) throws SQLException;

    List<Object> read(String tableName) throws SQLException;

    User readUserLogin(String tableName, String email, String password) throws SQLException;

    User readUserRegister(String tableName, String email) throws SQLException;

    void insertUserRegister(Customer customer) throws SQLException;

    public void update(String tableName, String whereClause, Object obj) throws SQLException;

    void delete(String tableName, String whereClause) throws SQLException;

    List<Book> readBooks() throws SQLException;

    List<Movie> readMovies() throws SQLException;

    List<CD> readCDS() throws SQLException;

    List<Software> readSoftwares() throws SQLException;

    List<Book> readBooksByTitle(String searchString) throws SQLException;

    List<Movie> readMoviesByTitle(String searchString) throws SQLException;

    List<CD> readCDsByName(String searchString) throws SQLException;

    List<Software> readSoftwaresByName(String searchString) throws SQLException;

    Book readBookByTitle(String searchString) throws SQLException;

    Movie readMovieByTitle(String searchString) throws SQLException;

    CD readCDByName(String searchString) throws SQLException;

    Software readSoftwareByName(String searchString) throws SQLException;

    void rentProduct(String email, String productHash, Date dateFrom, Date dateTo) throws SQLException;

    List<Rent> readCustomerRents(String customer_email) throws SQLException;
}
