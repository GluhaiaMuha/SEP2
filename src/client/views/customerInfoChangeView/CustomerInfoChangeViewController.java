package client.views.customerInfoChangeView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller Class for CustomerInfoChangeView
 */
public class CustomerInfoChangeViewController implements ViewController
{
  @FXML
  private TextField firstNameTextField;

  @FXML
  private TextField lastNameTextField;

  @FXML
  private TextField phoneTextField;

  private ViewHandler viewHandler;
  private CustomerInfoChangeViewModel customerInfoChangeViewModel;

  /**
   * Initializes the controller
   *
   * @param vh ViewHandler
   * @param vmf ViewModelFactory
   */
  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf) {
    this.viewHandler=vh;
    this.customerInfoChangeViewModel = vmf.getCustomerInfoChangeViewModel();
    firstNameTextField.textProperty().bindBidirectional(vmf.getCustomerInfoChangeViewModel().firstNameTextFieldProperty());
    lastNameTextField.textProperty().bindBidirectional(vmf.getCustomerInfoChangeViewModel().lastNameTextFieldProperty());
    phoneTextField.textProperty().bindBidirectional(vmf.getCustomerInfoChangeViewModel().phoneTextFieldProperty());
  }

  /**
   * Action Event to change Customer Info
   */
  @FXML
  void onChangeInfo(ActionEvent event) {
      customerInfoChangeViewModel.changeInfo();
  }

  /**
   * Action Event to return to main Page
   */
  @FXML
  void onMainPage(ActionEvent event) {
    viewHandler.openCustomerMainView();
  }
}
