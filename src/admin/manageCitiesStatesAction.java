package admin;

import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;
import com.opensymphony.xwork2.ActionSupport;
import admin_dao.*;
import beans.*;

public class manageCitiesStatesAction extends ActionSupport
{
	private CityStateHibDao citystateService=new CityStateHibDao();
	private PaginationHibDao pg=new PaginationHibDao();
	
	private CityState citystate;
	private List<CityState> citiesstates;
	private int pageNo, pageCount;
	
	public CityState getCitystate() {
		return citystate;
	}
	public void setCitystate(CityState citystate) {
		this.citystate = citystate;
	}
	public List<CityState> getCitiesstates() {
		return citiesstates;
	}
	public void setCitiesstates(List<CityState> citiesstates) {
		this.citiesstates = citiesstates;
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
		if(citystate.getCityStateNo()>0)
		{
			citystateService.update(citystate);
		}
		else
		{
			citystateService.insert(citystate);
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
			citystateService.delete(citystate.getCityStateNo());
		}
		catch(Exception e)
		{
			addActionError(e.getCause().toString().split("[:]")[1]);
			return ERROR;
		}
		return SUCCESS;
	}
	@SkipValidation
	public String edit() throws Exception
	{
		citystate=citystateService.edit(citystate.getCityStateNo());
		view();
		return SUCCESS;
	}
	@SkipValidation
	public String getPage() throws Exception
	{
		pageCount=pg.getTotalPages("CityState");
		citiesstates=pg.getPage(pageNo-1, "CityState").getList();
		return SUCCESS;
	}
}