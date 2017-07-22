package admin;

import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;
import com.opensymphony.xwork2.ActionSupport;
import admin_dao.*;
import beans.Categories;

public class manageCategoriesAction extends ActionSupport
{
	private CategoriesHibDao categoriesService=new CategoriesHibDao();
	private PaginationHibDao pg=new PaginationHibDao();
	
	private Categories category;
	private List<Categories> categories;
	private int pageNo, pageCount;
	
	public Categories getCategory() 
	{
		return category;
	}
	public void setCategory(Categories category) 
	{
		this.category = category;
	}
	public List<Categories> getCategories() {
		return categories;
	}
	public void setCategories(List<Categories> categories) {
		this.categories = categories;
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
		if(category.getCategoryNo()>0)
		{
			categoriesService.update(category);
		}
		else
		{
			categoriesService.insert(category);
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
			categoriesService.delete(category.getCategoryNo());
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
		category=categoriesService.edit(category.getCategoryNo());
		view();
		return SUCCESS;
	}
	@SkipValidation
	public String getPage() throws Exception
	{
		pageCount=pg.getTotalPages("Categories");
		categories=pg.getPage(pageNo-1, "Categories").getList();
		return SUCCESS;
	}
}