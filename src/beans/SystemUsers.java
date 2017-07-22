package beans;

public class SystemUsers implements java.io.Serializable
{
	private int UserNo;
	private String Username, Password, EmailAddress, FirstName, LastName, ManageCountries, ManageCityState, ManageAuthors, ManagePublishers, ManageCategories, ManageUsers, ManageBooks, ManageCustomers, ManageTransactions, LastLogin;
	
	public SystemUsers(){}
	
	public int getUserNo() {
		return UserNo;
	}
	public void setUserNo(int userNo) {
		this.UserNo = userNo;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		this.Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.EmailAddress = emailAddress;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		this.LastName = lastName;
	}
	public String getManageCountries() {
		return ManageCountries;
	}
	public void setManageCountries(String manageCountries) {
		this.ManageCountries = manageCountries;
	}
	public String getManageCityState() {
		return ManageCityState;
	}
	public void setManageCityState(String manageCityState) {
		this.ManageCityState = manageCityState;
	}
	public String getManageAuthors() {
		return ManageAuthors;
	}
	public void setManageAuthors(String manageAuthors) {
		this.ManageAuthors = manageAuthors;
	}
	public String getManagePublishers() {
		return ManagePublishers;
	}
	public void setManagePublishers(String managePublishers) {
		this.ManagePublishers = managePublishers;
	}
	public String getManageCategories() {
		return ManageCategories;
	}
	public void setManageCategories(String manageCategories) {
		this.ManageCategories = manageCategories;
	}
	public String getManageUsers() {
		return ManageUsers;
	}
	public void setManageUsers(String manageUsers) {
		this.ManageUsers = manageUsers;
	}
	public String getManageBooks() {
		return ManageBooks;
	}
	public void setManageBooks(String manageBooks) {
		this.ManageBooks = manageBooks;
	}
	public String getManageCustomers() {
		return ManageCustomers;
	}
	public void setManageCustomers(String manageCustomers) {
		this.ManageCustomers = manageCustomers;
	}
	public String getManageTransactions() {
		return ManageTransactions;
	}
	public void setManageTransactions(String manageTransactions) {
		this.ManageTransactions = manageTransactions;
	}
	public String getLastLogin() {
		return LastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.LastLogin = lastLogin;
	}
}