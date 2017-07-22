package admin;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import admin_dao.*;
import beans.*;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class manageTransactionsAction extends ActionSupport
{
    private TransactionsHibDao transactionsService = new TransactionsHibDao();
    
    private List<Transactions> transactions;
    private List<Customers> ddlbUsernames;
    private String Username;
    
    public List<Transactions> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }
    public List<Customers> getDdlbUsernames() {
        return ddlbUsernames;
    }
    public void setDdlbUsernames(List<Customers> ddlbUsernames) {
        this.ddlbUsernames = ddlbUsernames;
    }
    public String getUsername() {
        return Username;
    }
    public void setUsername(String Username) {
        this.Username = Username;
    }
    @SkipValidation
    public String view() throws Exception
    {
        populateUsernames();
        transactions=transactionsService.getAllEntries(Username);
        return SUCCESS;
    }
    @SkipValidation
    public String populateUsernames()
    {
        ddlbUsernames=transactionsService.getAllUsernames();
        return SUCCESS;
    }
}