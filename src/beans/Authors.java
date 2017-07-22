package beans;

import java.sql.Blob;

public class Authors implements java.io.Serializable
{
	private int AuthorNo;
	private Integer CityStateNo, CountryNo;
	private String FirstName, LastName, Address1, Address2, Pincode, Degree, EmailAddress, Speciality, Dob;
	private Blob Photograph;
	
	public Authors() {}
	
	public int getAuthorNo() {
		return AuthorNo;
	}
	public void setAuthorNo(int authorNo) {
		this.AuthorNo = authorNo;
	}
	public Integer getCityStateNo() {
		return CityStateNo;
	}
	public void setCityStateNo(Integer cityStateNo) {
		this.CityStateNo = cityStateNo;
	}
	public Integer getCountryNo() {
		return CountryNo;
	}
	public void setCountryNo(Integer countryNo) {
		this.CountryNo = countryNo;
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
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		this.Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		this.Address2 = address2;
	}
	public String getPincode() {
		return Pincode;
	}
	public void setPincode(String pincode) {
		this.Pincode = pincode;
	}
	public String getDegree() {
		return Degree;
	}
	public void setDegree(String degree) {
		this.Degree = degree;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.EmailAddress = emailAddress;
	}
	public String getSpeciality() {
		return Speciality;
	}
	public void setSpeciality(String speciality) {
		this.Speciality = speciality;
	}
	public String getDob() {
		return Dob;
	}
	public void setDob(String dob) {
		this.Dob = dob;
	}
	public Blob getPhotograph() {
		return Photograph;
	}
	public void setPhotograph(Blob photograph) {
		this.Photograph = photograph;
	}
}