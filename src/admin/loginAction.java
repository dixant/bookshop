package admin;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import admin_dao.LoginHibDao;
import beans.SystemUsers;

public class loginAction extends ActionSupport implements SessionAware
{
	private LoginHibDao loginService=new LoginHibDao();
	
	private SystemUsers systemuser;
	private String message;
	private Map session;
	
	public SystemUsers getSystemuser() {
		return systemuser;
	}
	public void setSystemuser(SystemUsers systemuser) {
		this.systemuser = systemuser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	public String login() throws Exception
	{
		SystemUsers objSystemusers=(SystemUsers)loginService.validateLogin(systemuser.getUsername(), systemuser.getPassword());
		
		if(objSystemusers!=null)
		{
			session=ActionContext.getContext().getSession();
			session.put("username", systemuser.getUsername());
			session.put("authors", objSystemusers.getManageAuthors());
			session.put("books", objSystemusers.getManageBooks());
			session.put("categories", objSystemusers.getManageCategories());
			session.put("citystate", objSystemusers.getManageCityState());
			session.put("countries", objSystemusers.getManageCountries());
			session.put("customers", objSystemusers.getManageCustomers());
			session.put("publishers", objSystemusers.getManagePublishers());
			session.put("transactions", objSystemusers.getManageTransactions());
			session.put("users", objSystemusers.getManageUsers());
			return SUCCESS;
		}
		else
		{
			message="Invalid Username or Password. Please try again";
			return ERROR;
		}
	}
	@SkipValidation
	public String logoff() throws Exception
	{
		session=ActionContext.getContext().getSession();
		session.remove("username");
		session.clear();
		return SUCCESS;
	}
}