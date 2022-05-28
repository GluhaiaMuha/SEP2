package client.core;

import client.views.customerInfoChangeView.CustomerInfoChangeViewModel;
import client.views.customerMainView.CustomerMainViewModel;
import client.views.librarianMainView.MainViewModel;
import client.views.loans.LoansViewModel;
import client.views.loginView.LoginViewModel;
import client.views.registerView.RegisterViewModel;
import client.views.rent.RentViewModel;
import client.views.review.ReviewViewModel;

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


  public LoginViewModel getLoginViewModel()
  {
    if (logInViewModel == null)
    {
      logInViewModel = new LoginViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return logInViewModel;
  }

  public RegisterViewModel getRegisterViewModel(){
    if (registerViewModel == null){
      registerViewModel = new RegisterViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return registerViewModel;
  }
  public CustomerMainViewModel getCustomerMainViewModel() {
    if (customerMainViewModel == null){
      customerMainViewModel= new CustomerMainViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return customerMainViewModel;
  }
  public LoansViewModel getLoansViewModel() {
    if (loansViewModel == null){
      loansViewModel = new LoansViewModel(ModelFactory.getInstance().getLibraryModel());
    }
  return loansViewModel;
}

  public RentViewModel getRentViewModel() {
    if (rentViewModel == null){
      rentViewModel = new RentViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return rentViewModel;
  }

  public ReviewViewModel getReviewViewModel() {
    if (reviewViewModel == null){
      reviewViewModel = new ReviewViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return reviewViewModel;
  }

  public MainViewModel getMainViewModel()
  {
   if (librarianViewModel == null){
     librarianViewModel = new MainViewModel(ModelFactory.getInstance()
         .getLibraryModel());
   }
   return librarianViewModel;
  }

  public CustomerInfoChangeViewModel getCustomerInfoChangeViewModel()
  {
    if (customerInfoChangeViewModel == null){
      customerInfoChangeViewModel = new CustomerInfoChangeViewModel(ModelFactory.getInstance().getLibraryModel());
    }
    return customerInfoChangeViewModel;
  }
}
