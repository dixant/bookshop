package admin;

import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;
import com.opensymphony.xwork2.ActionSupport;
import admin_dao.*;
import beans.*;
import common.*;

public class managePublishersAction extends ActionSupport
{
	private PublishersHibDao publishersService=new PublishersHibDao();
	private PaginationHibDao pg=new PaginationHibDao();
	
	private populateDdlbs ddlb=new populateDdlbs();
	private Publishers publisher;
	private List<Publishers> publishers;
	private int pageNo, pageCount;
	
	public populateDdlbs getDdlb() {
		return ddlb;
	}
	public void setDdlb(populateDdlbs ddlb) {
		this.ddlb = ddlb;
	}
	public Publishers getPublisher() {
		return publisher;
	}
	public void setPublisher(Publishers publisher) {
		this.publisher = publisher;
	}
	public List<Publishers> getPublishers() {
		return publishers;
	}
	public void setPublishers(List<Publishers> publishers) {
		this.publishers = publishers;
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
		if(publisher.getPublisherNo()>0)
		{
			publishersService.update(publisher);
		}
		else
		{
			publishersService.insert(publisher);
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
			publishersService.delete(publisher.getPublisherNo());
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
		publisher=publishersService.edit(publisher.getPublisherNo());
		view();
		return SUCCESS;
	}
	@SkipValidation
	public String getPage() throws Exception
	{
		pageCount=pg.getTotalPages("Publishers");
		publishers=pg.getPage(pageNo-1, "Publishers").getList();
		return SUCCESS;
	}
}