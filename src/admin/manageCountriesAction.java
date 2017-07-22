package admin;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import admin_dao.*;
import beans.*;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class manageCountriesAction extends ActionSupport
{
	private CountriesHibDao countriesService=new CountriesHibDao();
	private PaginationHibDao pg=new PaginationHibDao();
	
	private Countries country;
	private List<Countries> countries;
	private int pageNo, pageCount;
	
	public Countries getCountry() {
		return country;
	}
	public void setCountry(Countries country) {
		this.country = country;
	}
	public List<Countries> getCountries() {
		return countries;
	}
	public void setCountries(List<Countries> countries) {
		this.countries = countries;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public String insertupdate() throws Exception
	{
		if(country.getCountryNo()>0)
		{
			countriesService.update(country);
		}
		else
		{
			countriesService.insert(country);
		}
		return SUCCESS;
	}
	@SkipValidation
	public String view() throws Exception
	{
		pageNo=1;
		getPage();
		return SUCCESS;
	}
	@SkipValidation
	public String delete() throws Exception
	{
		try
		{
			countriesService.delete(country.getCountryNo());
		}
		catch(Exception e)
		{
			addActionError(e.getCause().toString().split("[:]")[1]);
		}
		return SUCCESS;
	}
	@SkipValidation
	public String edit() throws Exception
	{
		country=countriesService.edit(country.getCountryNo());
		view();
		return SUCCESS;
	}
	@SkipValidation
	public String getPage() throws Exception
	{
		pageCount=pg.getTotalPages("Countries");
		countries=pg.getPage(pageNo-1, "Countries").getList();
		return SUCCESS;
	}
}