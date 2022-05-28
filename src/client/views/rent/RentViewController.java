package client.views.rent;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferObj.Book;
import shared.transferObj.CD;
import shared.transferObj.Movie;
import shared.transferObj.Software;

public class RentViewController implements ViewController {

    private ViewHandler viewHandler;
    private RentViewModel rentViewModel;

    /* Movie Table Start Here */

    @FXML
    private TextField movieSearchField;

    @FXML
    private TableView<Object> movieTable;

    @FXML
    private TableColumn<Movie, Integer> movieHashCol;
    @FXML
    private TableColumn<Movie, String> movieDirectorCol;
    @FXML
    private TableColumn<Movie, Integer> movieLength;
    @FXML
    private TableColumn<Movie, String> movieTitleCol;
    @FXML
    private TableColumn<Movie, Integer> movieYearCol;
    @FXML
    private TableColumn<Movie, Integer> movieAmountInStock;

    /* Books Table Starts Here */

    @FXML
    private TextField bookSearchField;

    @FXML
    private TableView<Object> booksTable;

    @FXML
    private TableColumn<Book, String> booksHashCol;
    @FXML
    private TableColumn<Book, String> booksAuthorCol;
    @FXML
    private TableColumn<Book, String> booksTitleCol;
    @FXML
    private TableColumn<Book, Integer> booksPageCountCol;
    @FXML
    private TableColumn<Book, String> booksGenreCol;
    @FXML
    private TableColumn<Book, Integer> booksYearCol;
    @FXML
    private TableColumn<Book, Integer> booksAmountInStockCol;

    /* CD Table Starts Here */

    @FXML
    private TextField cdSearchField;

    @FXML
    private TableView<Object> cdTable;

    @FXML
    private TableColumn<CD, String> cdHashCol;
    @FXML
    private TableColumn<CD, String> cdNameCol;
    @FXML
    private TableColumn<CD, Integer> cdCapacityCol;
    @FXML
    private TableColumn<CD, String> cdUsageCol;
    @FXML
    private TableColumn<CD, Integer> cdAmountInStockCol;

    /* Software Table Starts Here */

    @FXML
    private TextField softwareSearchField;

    @FXML
    private TableView<Object> softwareTable;

    @FXML
    private TableColumn<Software, String> softwareHashCol;
    @FXML
    private TableColumn<Software, String> softwareNameCol;
    @FXML
    private TableColumn<Software, String> softwareTypeCol;
    @FXML
    private TableColumn<Software, Double> softwareVersionCol;
    @FXML
    private TableColumn<Software, String> softwareLicenseTypeCol;
    @FXML
    private TableColumn<Software, String> softwareAmountInStockCol;



    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf)
    {
        this.viewHandler = vh;
        rentViewModel = vmf.getRentViewModel();

        movieSearchField.textProperty().bindBidirectional(rentViewModel.movieSearchFieldProperty());
        bookSearchField.textProperty().bindBidirectional(rentViewModel.bookSearchFieldProperty());
        cdSearchField.textProperty().bindBidirectional(rentViewModel.cdSearchFieldProperty());
        softwareSearchField.textProperty().bindBidirectional(rentViewModel.softwareSearchFieldProperty());

        tables();
        rentViewModel.updateTables();
    }

    @FXML
    void onRentBook(ActionEvent event)
    {
        Book selectedBook = (Book) booksTable.getSelectionModel().getSelectedItem();
        rentViewModel.newRent(selectedBook, "book");
        rentViewModel.updateTables();
    }

    @FXML
    void onRentCD(ActionEvent event)
    {
        CD selectedCD = (CD) cdTable.getSelectionModel().getSelectedItem();
        rentViewModel.newRent(selectedCD, "cd");
        rentViewModel.updateTables();
    }

    @FXML
    void onRentMovie(ActionEvent event)
    {
        Movie selectedMovie = (Movie) movieTable.getSelectionModel().getSelectedItem();
        rentViewModel.newRent(selectedMovie, "movie");
        rentViewModel.updateTables();
    }

    @FXML
    void onRentSoftware(ActionEvent event)
    {
        Software selectedSoftware = (Software) softwareTable.getSelectionModel().getSelectedItem();
        rentViewModel.newRent(selectedSoftware, "software");
        rentViewModel.updateTables();
    }

    @FXML
    void onAddBookReview(ActionEvent event)
    {
        Book selectedBook = (Book) booksTable.getSelectionModel().getSelectedItem();
        rentViewModel.newReview(selectedBook, "book");
    }

    @FXML
    void onAddCDReview(ActionEvent event)
    {
        CD selectedCD = (CD) cdTable.getSelectionModel().getSelectedItem();
        rentViewModel.newReview(selectedCD, "cd");
    }

    @FXML
    void onAddMovieReview(ActionEvent event)
    {
        Movie selectedMovie = (Movie) movieTable.getSelectionModel().getSelectedItem();
        rentViewModel.newReview(selectedMovie, "movie");
    }

    @FXML
    void onAddSoftwareReview(ActionEvent event)
    {
        Software selectedSoftware = (Software) softwareTable.getSelectionModel().getSelectedItem();
        rentViewModel.newReview(selectedSoftware, "software");
    }

//    public void newRent(Object obj, String product)
//    {
//        java.sql.Date sqlDateFrom;
//        java.sql.Date sqlDateTo;
//        Product product1 = (Product) obj;
//        Rent rent = null;
//
//        if (product1 != null)
//        {
//            if (validationForRent(obj, product))
//            {
//                if (product1.getAmountInStock() > 0)
//                {
//                    sqlDateFrom = new java.sql.Date(System.currentTimeMillis());
//                    sqlDateTo = new java.sql.Date(System.currentTimeMillis() + 691200000);
//                    switch (product)
//                    {
//                        case "book":
//                            Book book = (Book) obj;
//                            book.setAmountInStock(book.getAmountInStock() - 1);
//                            rent = new Rent(rentViewModel.getEmail(), book.getHash(), book.getTitle(), sqlDateFrom, sqlDateTo);
//                            break;
//                        case "movie":
//                            Movie movie = (Movie) obj;
//                            movie.setAmountInStock(movie.getAmountInStock() - 1);
//                            rent = new Rent(rentViewModel.getEmail(), movie.getHash(), movie.getTitle(), sqlDateFrom, sqlDateTo);
//                            break;
//                        case "cd":
//                            CD cd = (CD) obj;
//                            cd.setAmountInStock(cd.getAmountInStock() - 1);
//                            rent = new Rent(rentViewModel.getEmail(), cd.getHash(), cd.getName(), sqlDateFrom, sqlDateTo);
//                            break;
//                        case "software":
//                            Software software = (Software) obj;
//                            software.setAmountInStock(software.getAmountInStock() - 1);
//                            rent = new Rent(rentViewModel.getEmail(), software.getHash(), software.getName(), sqlDateFrom, sqlDateTo);
//                            break;
//                    }
//
//                    rentViewModel.rentProduct(product, rent);
//                    rentViewModel.update(product, "hash = '" + product1.getHash() + "'", obj);
//                    rentViewModel.updateTables();
//                }
//                else
//                {
//                    cdTable.getSelectionModel().setCellSelectionEnabled(false);
//                    JOptionPane.showMessageDialog(null, "No product in stock!");
//                }
//            }
//            else
//                JOptionPane.showMessageDialog(null, "Product already rented!");
//        }
//        else
//            JOptionPane.showMessageDialog(null, "Product is not selected!");
//    }

//    public void newReview(Object obj, String product)
//    {
//        Review review = null;
//        if (obj != null)
//        {
//            if (validationForReview(obj, product))
//            {
//                final String inputReview = JOptionPane.showInputDialog(
//                    "Write review: ");
//                java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
//                if (!inputReview.equals(""))
//                {
//                    switch (product)
//                    {
//                        case "book":
//                            Book book = (Book) obj;
//                            review = new Review(rentViewModel.getEmail(), book.getHash(), book.getTitle(), currentDate,
//                                inputReview);
//                            break;
//                        case "movie":
//                            Movie movie = (Movie) obj;
//                            review = new Review(rentViewModel.getEmail(), movie.getHash(), movie.getTitle(), currentDate,
//                                inputReview);
//                            break;
//                        case "cd":
//                            CD cd = (CD) obj;
//                            review = new Review(rentViewModel.getEmail(), cd.getHash(), cd.getName(), currentDate,
//                                inputReview);
//                            break;
//                        case "software":
//                            Software software = (Software) obj;
//                            review = new Review(rentViewModel.getEmail(),
//                                software.getHash(), software.getName(),
//                                currentDate, inputReview);
//                            break;
//                    }
//                    rentViewModel.addReview(product, review);
//                }
//                else
//                    JOptionPane.showMessageDialog(null, "Input is empty!");
//            }
//            else
//                JOptionPane.showMessageDialog(null, "Product is already reviewed!");
//        }
//        else
//            JOptionPane.showMessageDialog(null, "Product is not selected!");
//    }

//    public boolean validationForRent(Object product, String table)
//    {
//        List<Rent> rents = rentViewModel.readCustomerRents(rentViewModel.getEmail(), table);
//        Product product1 = (Product) product;
//        for (Rent rent : rents)
//        {
//            if (rent.getProduct_hash().equals(product1.getHash()))
//                return false;
//        }
//        return true;
//    }

//    public boolean validationForReview(Object product, String table)
//    {
//        List<Review> reviews = rentViewModel.readReview(table);
//        Product product1 = (Product) product;
//        String email = rentViewModel.getEmail();
//        for (Review review : reviews)
//        {
//            if (review.getProduct_hash().equals(product1.getHash()) && review.getCustomer_email().equals(email))
//                return false;
//        }
//        return true;
//    }

    @FXML
    void onGoToMainPage(ActionEvent event) {
        viewHandler.openCustomerMainView();
    }

    @FXML
    void onUpdateList(ActionEvent event)
    {
        rentViewModel.updateTables();
        tables();
    }

    @FXML
    void onMovieSearch(ActionEvent event)
    {
        movieTable.setItems(rentViewModel.searchProducts("movie"));
    }

    @FXML
    void onBookSearch(ActionEvent event)
    {
        booksTable.setItems(rentViewModel.searchProducts("book"));
    }

    @FXML
    void onCDSearch(ActionEvent event)
    {
        cdTable.setItems(rentViewModel.searchProducts("cd"));
    }

    @FXML
    void onSoftwareSearch(ActionEvent event)
    {
        softwareTable.setItems(rentViewModel.searchProducts("software"));
    }

    private void tables()
    {
        movieHashCol.setCellValueFactory(new PropertyValueFactory<>("Hash"));
        movieTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        movieDirectorCol.setCellValueFactory(new PropertyValueFactory<>("Director"));
        movieYearCol.setCellValueFactory(new PropertyValueFactory<>("Release_year"));
        movieLength.setCellValueFactory(new PropertyValueFactory<>("Length"));
        movieAmountInStock.setCellValueFactory(new PropertyValueFactory<>("AmountInStock"));
        movieTable.setItems(rentViewModel.getDataMovie());


        booksHashCol.setCellValueFactory(new PropertyValueFactory<>("Hash"));
        booksTitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        booksAuthorCol.setCellValueFactory(new PropertyValueFactory<>("Author"));
        booksPageCountCol.setCellValueFactory(new PropertyValueFactory<>("PageCount"));
        booksGenreCol.setCellValueFactory(new PropertyValueFactory<>("Genre"));
        booksYearCol.setCellValueFactory(new PropertyValueFactory<>("Publication_year"));
        booksAmountInStockCol.setCellValueFactory(new PropertyValueFactory<>("AmountInStock"));
        booksTable.setItems(rentViewModel.getDataBook());


        cdHashCol.setCellValueFactory(new PropertyValueFactory<>("Hash"));
        cdNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        cdCapacityCol.setCellValueFactory(new PropertyValueFactory<>("Capacity"));
        cdUsageCol.setCellValueFactory(new PropertyValueFactory<>("Usage"));
        cdAmountInStockCol.setCellValueFactory(new PropertyValueFactory<>("AmountInStock"));
        cdTable.setItems(rentViewModel.getDataCD());


        softwareHashCol.setCellValueFactory(new PropertyValueFactory<>("Hash"));
        softwareNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        softwareTypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        softwareVersionCol.setCellValueFactory(new PropertyValueFactory<>("Version"));
        softwareLicenseTypeCol.setCellValueFactory(new PropertyValueFactory<>("License_type"));
        softwareAmountInStockCol.setCellValueFactory(new PropertyValueFactory<>("AmountInStock"));
        softwareTable.setItems(rentViewModel.getDataSoftware());
    }


//    private void updateTables()
//    {
//        /* Movie Table Start Here */
//        /* For future use, make sure PropertyValueFactory is the same as the get/set Methods */
//
//        final ObservableList<Object> dataMovie = FXCollections.observableArrayList(rentViewModel.read("movie")
//        );
//
//        movieHashCol.setCellValueFactory(
//            new PropertyValueFactory<>("Hash")
//        );
//        movieTitleCol.setCellValueFactory(
//            new PropertyValueFactory<>("Title")
//        );
//        movieDirectorCol.setCellValueFactory(
//            new PropertyValueFactory<>("Director")
//        );
//        movieYearCol.setCellValueFactory(
//            new PropertyValueFactory<>("Release_year")
//        );
//        movieLength.setCellValueFactory(
//            new PropertyValueFactory<>("Length")
//        );
//        movieAmountInStock.setCellValueFactory(
//            new PropertyValueFactory<>("AmountInStock")
//        );
//
//        movieTable.setItems(dataMovie);
//
//        /* Books Table Starts Here */
//
//        final ObservableList<Object> dataBook = FXCollections.observableArrayList(rentViewModel.read("book")
//        );
//
//        booksHashCol.setCellValueFactory(
//            new PropertyValueFactory<>("Hash")
//        );
//        booksTitleCol.setCellValueFactory(
//            new PropertyValueFactory<>("Title")
//        );
//        booksAuthorCol.setCellValueFactory(
//            new PropertyValueFactory<>("Author")
//        );
//        booksPageCountCol.setCellValueFactory(
//            new PropertyValueFactory<>("PageCount")
//        );
//        booksGenreCol.setCellValueFactory(
//            new PropertyValueFactory<>("Genre")
//        );
//        booksYearCol.setCellValueFactory(
//            new PropertyValueFactory<>("Publication_year")
//        );
//        booksAmountInStockCol.setCellValueFactory(
//            new PropertyValueFactory<>("AmountInStock")
//        );
//
//        booksTable.setItems(dataBook);
//
//        /* CD Table Starts Here */
//        final ObservableList<Object> dataCD = FXCollections.observableArrayList(rentViewModel.read("cd")
//        );
//
//        cdHashCol.setCellValueFactory(
//            new PropertyValueFactory<>("Hash")
//        );
//        cdNameCol.setCellValueFactory(
//            new PropertyValueFactory<>("Name")
//        );
//        cdCapacityCol.setCellValueFactory(
//            new PropertyValueFactory<>("Capacity")
//        );
//        cdUsageCol.setCellValueFactory(
//            new PropertyValueFactory<>("Usage")
//        );
//        cdAmountInStockCol.setCellValueFactory(
//            new PropertyValueFactory<>("AmountInStock")
//        );
//
//
//        cdTable.setItems(dataCD);
//
//        /* Software Table Starts Here */
//        final ObservableList<Object> dataSoftware = FXCollections.observableArrayList(rentViewModel.read("software")
//        );
//
//        softwareHashCol.setCellValueFactory(
//            new PropertyValueFactory<>("Hash")
//        );
//        softwareNameCol.setCellValueFactory(
//            new PropertyValueFactory<>("Name")
//        );
//        softwareTypeCol.setCellValueFactory(
//            new PropertyValueFactory<>("Type")
//        );
//        softwareVersionCol.setCellValueFactory(
//            new PropertyValueFactory<>("Version")
//        );
//        softwareLicenseTypeCol.setCellValueFactory(
//            new PropertyValueFactory<>("License_type")
//        );
//        softwareAmountInStockCol.setCellValueFactory(
//            new PropertyValueFactory<>("AmountInStock")
//        );
//
//        softwareTable.setItems(dataSoftware);
//    }

}
