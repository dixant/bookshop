package beans;

public class CityState implements java.io.Serializable
{
	private int CityStateNo;
	private String State, City;
	
	public CityState(){}
	
	public int getCityStateNo() 
	{
		return CityStateNo;
	}
	public void setCityStateNo(int cityStateNo) 
	{
		this.CityStateNo = cityStateNo;
	}
	public String getState() 
	{
		return State;
	}
	public void setState(String state) 
	{
		this.State = state;
	}
	public String getCity() 
	{
		return City;
	}
	public void setCity(String city) 
	{
		this.City = city;
	}
}
