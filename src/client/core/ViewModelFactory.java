package client.core;

import client.views.customerInfoChangeView.CustomerInfoChangeViewModel;
import client.views.customerMainView.CustomerMainViewModel;
import client.views.librarianMainView.MainViewModel;
import client.views.loans.LoansViewModel;
import client.views.loginView.LoginViewModel;
import client.views.registerView.RegisterViewModel;
import client.views.rent.RentViewModel;
import client.views.review.ReviewViewModel;

/**
 * Factory for creating ViewModel Objects without exposing the creation logic to the client
 */
public class ViewModelFactory
{
  private static ViewModelFactory instance=new ViewModelFactory();

  public static ViewModelFactory getInstance(){
    return instance;
  }

  private LoginViewModel logInViewModel;
  private RegisterViewModel registerViewModel;
  private CustomerMainViewModel customerMainViewModel;
  private LoansViewModel loansViewModel;
  private RentViewModel rentViewModel;
  private MainViewModel librarianViewModel;
  private CustomerInfoChangeViewModel customerInfoChangeViewModel;

  private ReviewViewModel reviewViewModel;

  /**
   * Method for creating LoginViewModel
   *
   * @return LoginViewModel
   */
  public LoginViewModel getLoginViewModel()
  {
    if (logInViewModel == null)
    {
      logInViewModel = new LoginViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return logInViewModel;
  }

  /**
   * Method for creating RegisterViewModel
   *
   * @return RegisterViewModel
   */
  public RegisterViewModel getRegisterViewModel(){
    if (registerViewModel == null){
      registerViewModel = new RegisterViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return registerViewModel;
  }

  /**
   * Method for creating CustomerMainViewModel
   *
   * @return CustomerMainViewModel
   */
  public CustomerMainViewModel getCustomerMainViewModel() {
    if (customerMainViewModel == null){
      customerMainViewModel= new CustomerMainViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return customerMainViewModel;
  }

  /**
   * Method for creating LoansViewModel
   *
   * @return LoansViewModel
   */
  public LoansViewModel getLoansViewModel() {
    if (loansViewModel == null){
      loansViewModel = new LoansViewModel(ModelFactory.getInstance().getLibraryModel());
    }
  return loansViewModel;
}

  /**
   * Method for creating RentViewModel
   *
   * @return RentViewModel
   */
  public RentViewModel getRentViewModel() {
    if (rentViewModel == null){
      rentViewModel = new RentViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return rentViewModel;
  }

  /**
   * Method for creating ReviewViewModel
   *
   * @return ReviewViewModel
   */
  public ReviewViewModel getReviewViewModel() {
    if (reviewViewModel == null){
      reviewViewModel = new ReviewViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return reviewViewModel;
  }

  /**
   * Method for creating MainViewModel
   *
   * @return MainViewModel
   */
  public MainViewModel getMainViewModel()
  {
   if (librarianViewModel == null){
     librarianViewModel = new MainViewModel(ModelFactory.getInstance()
         .getLibraryModel());
   }
   return librarianViewModel;
  }

  /**
   * Method for creating CustomerInfoChangeViewModel
   *
   * @return CustomerInfoChangeViewModel
   */
  public CustomerInfoChangeViewModel getCustomerInfoChangeViewModel()
  {
    if (customerInfoChangeViewModel == null){
      customerInfoChangeViewModel = new CustomerInfoChangeViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return customerInfoChangeViewModel;
  }
}
