package admin;

import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;
import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import admin_dao.*;
import beans.Authors;
import common.populateDdlbs;
import org.hibernate.Hibernate;

public class manageAuthorsAction extends ActionSupport
{
	private AuthorsHibDao authorsService=new AuthorsHibDao();
	private PaginationHibDao pg=new PaginationHibDao();
	
	private populateDdlbs ddlb=new populateDdlbs();
	private Authors author;
	private List<Authors> authors;
	private File Photograph;
	private int pageNo, pageCount;
	
	public populateDdlbs getDdlb() {
		return ddlb;
	}
	public void setDdlb(populateDdlbs ddlb) {
		this.ddlb = ddlb;
	}
	public Authors getAuthor() {
		return author;
	}
	public void setAuthor(Authors author) {
		this.author = author;
	}
	public List<Authors> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Authors> authors) {
		this.authors = authors;
	}
	public File getPhotograph() {
		return Photograph;
	}
	public void setPhotograph(File photograph) {
		this.Photograph = photograph;
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
		File photographImage=null;
		InputStream iStreamPhotograph=null;
		if(Photograph!=null)
		{
			photographImage=new File(Photograph.toString());
			iStreamPhotograph=new FileInputStream(Photograph);
			author.setPhotograph(Hibernate.createBlob(iStreamPhotograph));
		}
		if(author.getAuthorNo()>0)
		{
			authorsService.update(author);
		}
		else
		{
			authorsService.insert(author);
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
			authorsService.delete(author.getAuthorNo());
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
		author=authorsService.edit(author.getAuthorNo());
		view();
		return SUCCESS;
	}
	@SkipValidation
	public String getPage() throws Exception
	{
		pageCount=pg.getTotalPages("Authors");
		authors=pg.getPage(pageNo-1, "Authors").getList();
		return SUCCESS;
	}
}