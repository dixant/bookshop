package beans;

public class Countries implements java.io.Serializable
{
	private int CountryNo;
	private String Country;
	
	public Countries()
	{}
	public int getCountryNo() {
		return CountryNo;
	}
	public void setCountryNo(int countryNo) {
		this.CountryNo = countryNo;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		this.Country = country;
	}
}
