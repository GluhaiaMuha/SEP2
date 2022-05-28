package client.views.loans;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.transferObj.Rent;

import java.sql.Date;

public class LoansViewController implements ViewController {
    private ViewHandler viewHandler;
    private LoansViewModel loansViewModel;


    /* Movie Table Start Here */


    @FXML
    private TableView<Rent> movieTable;
    @FXML
    private TableColumn<Rent, String> movieEmailCol;
    @FXML
    private TableColumn<Rent, String> movieTitleCol;
    @FXML
    private TableColumn<Rent, Date> movieDateFromCol;
    @FXML
    private TableColumn<Rent, Date> movieDateToCol;


    /* Books Table Starts Here */


    @FXML
    private TableView<Rent> booksTable;
    @FXML
    private TableColumn<Rent, String> booksEmailCol;
    @FXML
    private TableColumn<Rent, String> booksTitleCol;
    @FXML
    private TableColumn<Rent, Date> booksDateFromCol;
    @FXML
    private TableColumn<Rent, Date> booksDateToCol;

    /* CD Table Starts Here */


    @FXML
    private TableView<Rent> cdTable;
    @FXML
    private TableColumn<Rent, String> cdEmailCol;
    @FXML
    private TableColumn<Rent, String> cdNameCol;
    @FXML
    private TableColumn<Rent, Date> cdDateFromCol;
    @FXML
    private TableColumn<Rent, Date> cdDateToCol;

    /* Software Table Starts Here */


    @FXML
    private TableView<Rent> softwareTable;
    @FXML
    private TableColumn<Rent, String> softwareEmailCol;
    @FXML
    private TableColumn<Rent, String> softwareNameCol;
    @FXML
    private TableColumn<Rent, Date> softwareDateFromCol;
    @FXML
    private TableColumn<Rent, Date> softwareDateToCol;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf)
    {
        this.viewHandler = vh;
        loansViewModel= vmf.getLoansViewModel();

        tables();
        loansViewModel.updateTables();
    }

    @FXML
    void onRemoveBookRent(ActionEvent event)
    {
        Rent selectedBook = booksTable.getSelectionModel().getSelectedItem();
        loansViewModel.removeRent(selectedBook, "book");
        loansViewModel.updateTables();
    }

    @FXML
    void onRemoveCDRent(ActionEvent event)
    {
        Rent selectedCD = cdTable.getSelectionModel().getSelectedItem();
        loansViewModel.removeRent(selectedCD, "cd");
        loansViewModel.updateTables();
    }

    @FXML
    void onRemoveMovieRent(ActionEvent event)
    {
        Rent selectedMovie = movieTable.getSelectionModel().getSelectedItem();
        loansViewModel.removeRent(selectedMovie, "movie");
        loansViewModel.updateTables();
    }

    @FXML
    void onRemoveSoftwareRent(ActionEvent event)
    {
        Rent selectedSoftware = softwareTable.getSelectionModel().getSelectedItem();
        loansViewModel.removeRent(selectedSoftware, "software");
        loansViewModel.updateTables();
    }

    @FXML
    void onGoToMainPage(ActionEvent event) {
        viewHandler.openCustomerMainView();
    }

    @FXML
    void onUpdateList(ActionEvent event)
    {
        loansViewModel.updateTables();
    }

    public void tables()
    {
        movieEmailCol.setCellValueFactory(new PropertyValueFactory<>("customer_email"));
        movieTitleCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        movieDateFromCol.setCellValueFactory(new PropertyValueFactory<>("DateFrom"));
        movieDateToCol.setCellValueFactory(new PropertyValueFactory<>("DateTo"));
        movieTable.setItems(loansViewModel.getDataMovie());


        booksEmailCol.setCellValueFactory(new PropertyValueFactory<>("customer_email"));
        booksTitleCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        booksDateFromCol.setCellValueFactory(new PropertyValueFactory<>("DateFrom"));
        booksDateToCol.setCellValueFactory(new PropertyValueFactory<>("DateTo"));
        booksTable.setItems(loansViewModel.getDataBook());


        cdEmailCol.setCellValueFactory(new PropertyValueFactory<>("customer_email"));
        cdNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        cdDateFromCol.setCellValueFactory(new PropertyValueFactory<>("DateFrom"));
        cdDateToCol.setCellValueFactory(new PropertyValueFactory<>("DateTo"));
        cdTable.setItems(loansViewModel.getDataCD());


        softwareEmailCol.setCellValueFactory(new PropertyValueFactory<>("customer_email"));
        softwareNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        softwareDateFromCol.setCellValueFactory(new PropertyValueFactory<>("DateFrom"));
        softwareDateToCol.setCellValueFactory(new PropertyValueFactory<>("DateTo"));
        softwareTable.setItems(loansViewModel.getDataSoftware());
    }

//    public void removeRent(Rent rent, String product)
//    {
//        if (rent != null)
//        {
//            loansViewModel.removeRent(rent, product);
//            loansViewModel.updateProductAmount(product, rent.getProduct_hash());
//            loansViewModel.updateTables();
//        }else
//            JOptionPane.showMessageDialog(null, "Product is not selected!");
//    }



//    private void updateTables()
//    {
//        /* Movie Table Start Here */
//        /* For future use, make sure PropertyValueFactory is the same as the get/set Methods */
//
//        final ObservableList<Rent> dataMovie = FXCollections.observableArrayList(loansViewModel.readCustomerRents(loansViewModel.getEmail(), "movie")
//        );
//
//        movieEmailCol.setCellValueFactory(
//            new PropertyValueFactory<>("customer_email")
//        );
//
//        movieTitleCol.setCellValueFactory(
//            new PropertyValueFactory<>("productName")
//        );
//
//        movieDateFromCol.setCellValueFactory(
//            new PropertyValueFactory<>("DateFrom")
//        );
//        movieDateToCol.setCellValueFactory(
//            new PropertyValueFactory<>("DateTo")
//        );
//
//        movieTable.setItems(dataMovie);
//
//        /* Books Table Starts Here */
//
//        final ObservableList<Rent> dataBook = FXCollections.observableArrayList(loansViewModel.readCustomerRents(loansViewModel.getEmail(), "book")
//        );
//
//        booksEmailCol.setCellValueFactory(
//            new PropertyValueFactory<>("customer_email")
//        );
//
//        booksTitleCol.setCellValueFactory(
//            new PropertyValueFactory<>("productName")
//        );
//
//        booksDateFromCol.setCellValueFactory(
//            new PropertyValueFactory<>("DateFrom")
//        );
//        booksDateToCol.setCellValueFactory(
//            new PropertyValueFactory<>("DateTo")
//        );
//
//        booksTable.setItems(dataBook);
//
//        /* CD Table Starts Here */
//        final ObservableList<Rent> dataCD = FXCollections.observableArrayList(loansViewModel.readCustomerRents(loansViewModel.getEmail(), "cd")
//        );
//
//        cdEmailCol.setCellValueFactory(
//            new PropertyValueFactory<>("customer_email")
//        );
//
//        cdNameCol.setCellValueFactory(
//            new PropertyValueFactory<>("productName")
//        );
//
//        cdDateFromCol.setCellValueFactory(
//            new PropertyValueFactory<>("DateFrom")
//        );
//        cdDateToCol.setCellValueFactory(
//            new PropertyValueFactory<>("DateTo")
//        );
//
//
//        cdTable.setItems(dataCD);
//
//        /* Software Table Starts Here */
//        final ObservableList<Rent> dataSoftware = FXCollections.observableArrayList(loansViewModel.readCustomerRents(loansViewModel.getEmail(), "software")
//        );
//
//        softwareEmailCol.setCellValueFactory(
//            new PropertyValueFactory<>("customer_email")
//        );
//
//        softwareNameCol.setCellValueFactory(
//            new PropertyValueFactory<>("productName")
//        );
//
//        softwareDateFromCol.setCellValueFactory(
//            new PropertyValueFactory<>("DateFrom")
//        );
//        softwareDateToCol.setCellValueFactory(
//            new PropertyValueFactory<>("DateTo")
//        );
//
//        softwareTable.setItems(dataSoftware);
//    }


}
