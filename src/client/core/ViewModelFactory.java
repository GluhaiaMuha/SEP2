package client.core;

import client.views.customerMainView.CustomerMainViewModel;
import client.views.loans.LoansViewModel;
import client.views.loginView.LoginViewModel;
import client.views.registerView.RegisterViewModel;
import client.views.rent.RentViewModel;
import client.views.review.ReviewViewModel;

public class ViewModelFactory
{

  private ModelFactory modelFactory;
  private LoginViewModel logInViewModel;
  private RegisterViewModel registerViewModel;
  private CustomerMainViewModel customerMainViewModel;
  private LoansViewModel loansViewModel;
  private RentViewModel rentViewModel;

  private ReviewViewModel reviewViewModel;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  public LoginViewModel getLoginViewModel()
  {
    if (logInViewModel == null)
    {
      logInViewModel = new LoginViewModel(modelFactory.getLibraryModel());
    }
    return logInViewModel;
  }

  public RegisterViewModel getRegisterViewModel(){
    if (registerViewModel == null){
      registerViewModel = new RegisterViewModel(modelFactory.getLibraryModel());
    }
    return registerViewModel;
  }
  public CustomerMainViewModel getCustomerMainViewModel() {
    if (customerMainViewModel == null){
      customerMainViewModel= new CustomerMainViewModel(modelFactory.getLibraryModel());
    }
    return customerMainViewModel;
  }
  public LoansViewModel getLoansViewModel() {
    if (loansViewModel == null){
      loansViewModel = new LoansViewModel(modelFactory.getLibraryModel());
    }
  return loansViewModel;
}

  public RentViewModel getRentViewModel() {
    if (rentViewModel == null){
      rentViewModel = new RentViewModel(modelFactory.getLibraryModel());
    }
    return rentViewModel;
  }

  public ReviewViewModel getReviewViewModel() {
    if (reviewViewModel == null){
      reviewViewModel = new ReviewViewModel(modelFactory.getLibraryModel());
    }
    return reviewViewModel;
  }
}
