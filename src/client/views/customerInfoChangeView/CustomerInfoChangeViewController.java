package client.views.customerInfoChangeView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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

  @Override
  public void init(ViewHandler vh, ViewModelFactory vmf) {
    this.viewHandler=vh;
    this.customerInfoChangeViewModel = vmf.getCustomerInfoChangeViewModel();
    firstNameTextField.textProperty().bindBidirectional(vmf.getCustomerInfoChangeViewModel().firstNameTextFieldProperty());
    lastNameTextField.textProperty().bindBidirectional(vmf.getCustomerInfoChangeViewModel().lastNameTextFieldProperty());
    phoneTextField.textProperty().bindBidirectional(vmf.getCustomerInfoChangeViewModel().phoneTextFieldProperty());
  }

  @FXML
  void onChangeInfo(ActionEvent event) {
      customerInfoChangeViewModel.changeInfo();
  }

  @FXML
  void onMainPage(ActionEvent event) {
    viewHandler.openCustomerMainView();
  }
}
