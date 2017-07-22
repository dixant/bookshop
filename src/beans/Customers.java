package beans;

public class Customers implements java.io.Serializable
{
	private int CustomerNo;
	private Integer CityStateNo, CountryNo;
	private String Username, Password, EmailAddress, FirstName, LastName, Address1, Address2, Pincode, Dob, NewRelease, BookUpdates, LastLogin, LastIP;
	
	public Customers(){}
	
	public int getCustomerNo() {
		return CustomerNo;
	}
	public void setCustomerNo(int customerNo) {
		CustomerNo = customerNo;
	}
	public Integer getCityStateNo() {
		return CityStateNo;
	}
	public void setCityStateNo(Integer cityStateNo) {
		CityStateNo = cityStateNo;
	}
	public Integer getCountryNo() {
		return CountryNo;
	}
	public void setCountryNo(Integer countryNo) {
		CountryNo = countryNo;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		Pincode = pincode;
	}
	public String getDob() {
		return Dob;
	}
	public void setDob(String dob) {
		Dob = dob;
	}
	public String getNewRelease() {
		return NewRelease;
	}
	public void setNewRelease(String newRelease) {
		NewRelease = newRelease;
	}
	public String getBookUpdates() {
		return BookUpdates;
	}
	public void setBookUpdates(String bookUpdates) {
		BookUpdates = bookUpdates;
	}
	public String getLastLogin() {
		return LastLogin;
	}
	public void setLastLogin(String lastLogin) {
		LastLogin = lastLogin;
	}
	public String getLastIP() {
		return LastIP;
	}
	public void setLastIP(String lastIP) {
		LastIP = lastIP;
	}
}
