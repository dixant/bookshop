package frontend;

import java.util.*;
import com.opensymphony.xwork2.*;
import beans.Customers;
import common.sendMail;
import frontend_dao.customerLoginHibDao;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class customerLoginAction extends ActionSupport implements SessionAware, ServletRequestAware
{
    private customerLoginHibDao customerLoginService = new customerLoginHibDao();
    private Customers customer;
    private String message;
    private Map session;
    private HttpServletRequest request;
    
    public HttpServletRequest getServletRequest(){
        return request;
    }
    public void setServletRequest(HttpServletRequest request){
        this.request = request;
    }
    public Map getSession() {
        return session;
    }
    public void setSession(Map session) {
        this.session = session;
    }
    public String getMessage() {
        return message;
    }
    public Customers getCustomer() {
        return customer;
    }
    public void setCustomer(Customers customer) {
        this.customer = customer;
    }
    public String login() throws Exception
    {
        Customers objCustomer=(Customers)customerLoginService.validateLogin(customer.getUsername(), customer.getPassword(), request.getRemoteAddr());
        if(objCustomer!=null)
        {
            session = ActionContext.getContext().getSession();
            session.put("username", customer.getUsername());
            session.put("lastlogin", objCustomer.getLastLogin());
            session.put("lastip", objCustomer.getLastIP());
        }
        else
        {
            message = "Invalid Username or Password. Please try again";
            return ERROR;
        }
        return SUCCESS;
    }
    public String retrievePassword() throws Exception 
    {
        Customers objCustomers=(Customers)customerLoginService.getPassword(customer.getUsername(), customer.getEmailAddress());
        if(objCustomers!=null)
        {
            Locale locale = ActionContext.getContext().getLocale();
            ResourceBundle bundle = ResourceBundle.getBundle("bookshop", locale);
            if(!bundle.getString("emailFrom").equals("") && !bundle.getString("emailUser").equals("") && !bundle.getString("emailFromPasswd").equals("")) 
            {
                String toEmailAddress = objCustomers.getEmailAddress();
                String emailSubject = "Bookshop: Forgot Password mail";
                String emailMessage = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'/><title>Your Password</title></head><body><table width='500' border='0' align='center' cellpadding='15' cellspacing='0' style='font-family:Verdana, Arial, Helvetica, sans-serif; font-size:12pt; color:#5a5a5a;'><tr><td align='left'><p>Dear " + objCustomers.getFirstName() + ",</p></td></tr><tr><td align='left'><p>As requested, please find your login details below:</p><br/><br/><p>Username: " + objCustomers.getUsername() + "<br />Password: " + objCustomers.getPassword() + "<br /></p><br/><p>Thank you for using  this site.<br /></p><br/><br/><p>Regards,<br />Sharanams Bookshop<br /></p><p><br /><br />THIS IS AN AUTOMATED MESSAGE; PLEASE DO NOT REPLY. </p></td></tr></table></body></html>";
                sendMail.sendMail(bundle.getString("emailFrom"), bundle.getString("emailUser"), bundle.getString("emailFromPasswd"), toEmailAddress, emailSubject, emailMessage);
            }
        }
        else
        {
            message = "Invalid Username or Email Address. Please try again";
            return ERROR;
        }
        return SUCCESS;
    }
    @SkipValidation
    public String logoff() throws Exception
    {
        session=ActionContext.getContext().getSession();
        session.remove("username");
        session.remove("lastlogin");
        session.remove("lastip");
        session.clear();
        return SUCCESS;
    }
}