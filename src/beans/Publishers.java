package beans;

public class Publishers implements java.io.Serializable
{
	private int PublisherNo;
	private Integer CityStateNo, CountryNo;
	private String PublisherName, EmailAddress, Address1, Address2, Pincode;
	
	public Publishers(){}
	public int getPublisherNo() {
		return PublisherNo;
	}
	public void setPublisherNo(int publisherNo) {
		this.PublisherNo = publisherNo;
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
	public String getPublisherName() {
		return PublisherName;
	}
	public void setPublisherName(String publisherName) {
		this.PublisherName = publisherName;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.EmailAddress = emailAddress;
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
}
