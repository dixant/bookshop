package frontend;

import java.util.Locale;
import java.util.ResourceBundle;
import com.opensymphony.xwork2.*;
import beans.Customers;
import common.populateDdlbs;
import common.sendMail;
import frontend_dao.registrationHibDao;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class registrationAction extends ActionSupport
{
    private registrationHibDao registrationService = new registrationHibDao();
    
    private populateDdlbs ddlb = new populateDdlbs();
    private Customers customer;
    
    public populateDdlbs getDdlb() {
        return ddlb;
    }
    public void setDdlb(populateDdlbs ddlb) {
        this.ddlb = ddlb;
    }
    public Customers getCustomer() {
        return customer;
    }
    public void setCustomer(Customers customer) {
        this.customer = customer;
    }
    @SkipValidation
    @Override
    public String execute()
    {
        return SUCCESS;
    }
    public String insert() throws Exception
    {
        try
        {
            registrationService.insert(customer);
            registrationThankYouMail();
        }
        catch (Exception e)
        {
            addActionError(e.getCause().toString().split("[:]")[1]);
            return ERROR;
        }
        return SUCCESS;
    }
    @SkipValidation
    public String registrationThankYouMail() throws Exception
    {
       	Locale locale = ActionContext.getContext().getLocale();
    	ResourceBundle bundle = ResourceBundle.getBundle("bookshop", locale);
        if(!bundle.getString("emailFrom").equals("") && !bundle.getString("emailUser").equals("") && !bundle.getString("emailFromPasswd").equals("")) 
        {
            String toEmailAddress=customer.getEmailAddress();
            String emailSubject="Bookshop: Registration mail.";
           // String emailMessage="<html><head><meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'/><title>Your Registration Details</title></head><body><table width='500' border='0' align='center' cellpadding='15' cellspacing='0' style='font-family:Verdana, Arial, Helvetica, sans-serif; font-size:12pt; color:#5a5a5a;'><tr><td align='left'><p>Dear " + customer.getFirstName() + ",</p></td></tr><tr><td align='left'><p>Your login details are:</p><br/><br/><p>Username: " + customer.getUsername() + "<br />Password: " + customer.getPassword() + "<br /></p><br/><p>Thank you for using  this site.<br /></p><br/><br/><p>Regards,<br />Sharanams Bookshop<br /></p><p><br /><br />THIS IS AN AUTOMATED MESSAGE; PLEASE DO NOT REPLY. </p></td></tr></table></body></html>";
            String emailMessage="Email Address="+customer.getEmailAddress()+"User Name:"+customer.getUsername()+"Password:"+customer.getPassword();
            sendMail.sendMail(bundle.getString("emailFrom"), bundle.getString("emailUser"), bundle.getString("emailFromPasswd"), toEmailAddress, emailSubject, emailMessage);
        }
        return SUCCESS;
    }
}