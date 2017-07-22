package admin;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import admin_dao.*;
import beans.*;
import common.populateDdlbs;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class manageCustomersAction extends ActionSupport
{
    private CustomersHibDao customersService = new CustomersHibDao();
    private PaginationHibDao pg = new PaginationHibDao();
    
    private populateDdlbs ddlb = new populateDdlbs();
    private Customers customer;
    private List<Customers> customers;
    private int pageNo, pageCount;
    
    public populateDdlbs getDdlb() {
        return ddlb;
    }
    public void setDdlb(populateDdlbs ddlb) {
        this.ddlb = ddlb;
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
    public Customers getCustomer() {
        return customer;
    }
    public void setCustomer(Customers customer) {
        this.customer = customer;
    }
    public List<Customers> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }
    public String update() throws Exception
    {
        try
        {
            customersService.update(customer);
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
        customersService.delete(customer.getCustomerNo());
        return SUCCESS;
    }
    @SkipValidation
    public String edit() throws Exception
    {
        customer = customersService.edit(customer.getCustomerNo());
        view();
        return SUCCESS;
    }
    @SkipValidation
    public String getPage() throws Exception
    {
        pageCount = pg.getTotalPages("Customers");
        customers = pg.getPage(pageNo-1, "Customers").getList();
        return SUCCESS;
    }
}