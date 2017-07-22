package admin;

import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;
import com.opensymphony.xwork2.ActionSupport;
import admin_dao.*;
import beans.*;

public class manageUsersAction extends ActionSupport
{
	private SystemUsersHibDao systemusersService=new SystemUsersHibDao();
	private PaginationHibDao pg=new PaginationHibDao();
	
	private SystemUsers systemuser;
	private List<SystemUsers> systemusers;
	private int pageNo, pageCount;
	
	public SystemUsers getSystemuser() {
		return systemuser;
	}
	public void setSystemuser(SystemUsers systemuser) {
		this.systemuser = systemuser;
	}
	public List<SystemUsers> getSystemusers() {
		return systemusers;
	}
	public void setSystemusers(List<SystemUsers> systemusers) {
		this.systemusers = systemusers;
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
		try
		{
			if(systemuser.getUserNo()>0)
			{
				systemusersService.update(systemuser);
			}
			else
			{
				systemusersService.insert(systemuser);
			}
		}
		catch(Exception e)
		{
			addActionError(e.getCause().toString().split("[:]")[1]);
			return ERROR;
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
		systemusersService.delete(systemuser.getUserNo());
		return SUCCESS;
	}
	@SkipValidation
	public String edit() throws Exception
	{
		systemuser=systemusersService.edit(systemuser.getUserNo());
		view();
		return SUCCESS;
	}
	@SkipValidation
	public String getPage() throws Exception
	{
		pageCount=pg.getTotalPages("SystemUsers");
		systemusers=pg.getPage(pageNo-1,"SystemUsers").getList();
		return SUCCESS;
	}
}