package admin_dao;

import com.opensymphony.xwork2.ActionContext;
import beans.Books;
import beans.Customers;
import common.HibernateUtil;
import common.sendMail;
import java.util.*;
import org.hibernate.*;

public class BooksHibDao 
{
    public void insert(Books objBooks) throws Exception 
    {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try 
        {
            tx = session.beginTransaction();
            session.save(objBooks);
            tx.commit();
            notifyNewReleasesToCustomers(objBooks);
        }
        catch (RuntimeException e) 
        {
            if(objBooks != null)
                tx.rollback();
            throw e;
        }
        finally
        {
            session.close();
        }
    }
    public void update(Books objBooks) throws Exception
    {
        Session session=HibernateUtil.getSession();
        Transaction tx=null;
        try 
        {
            tx = session.beginTransaction();
            session.update(objBooks);
            tx.commit();
            notifyUpdatesToCustomers(objBooks);
        }
        catch (RuntimeException e) 
        {
            if(objBooks != null)
                tx.rollback();
            throw e;
        }
        finally 
        {
            session.close();
        }
    }
    public void delete(int BookNo) 
    {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Object Books = null;

        try 
        {
            tx = session.beginTransaction();
            Books = session.load(Books.class, BookNo);
            session.delete(Books);
            tx.commit();
        }
        catch (RuntimeException e) 
        {
            if(Books != null)
                tx.rollback();
            throw e;
        }
        finally 
        {
            session.close();
        }
    }
    public Books edit(int BookNo) 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            Query query = session.createQuery("FROM Books WHERE BookNo = :BookNo");
            query.setInteger("BookNo", BookNo);
            return (Books) query.uniqueResult();
        }
        finally 
        {
            session.close();
        }
    }
    public void notifyNewReleasesToCustomers(Books objBooks) throws Exception 
    {
        Session session = HibernateUtil.getSession();

        try 
        {
            Locale locale = ActionContext.getContext().getLocale();
            ResourceBundle bundle = ResourceBundle.getBundle("bookshop", locale);
            if(!bundle.getString("emailFrom").equals("") && !bundle.getString("emailUser").equals("") && !bundle.getString("emailFromPasswd").equals("")) 
            {
                session.beginTransaction();
                List<Customers> customers = session.createQuery("FROM Customers WHERE NewRelease = 'true'").list();

                for (Iterator i = customers.iterator(); i.hasNext(); ) 
                {
                    Customers objCustomer = (Customers) i.next();
                    String toEmailAddress = objCustomer.getEmailAddress();
                    String emailSubject = "Bookshop: " + objBooks.getBookName() + " has been added.";
                    String emailMessage = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'/><title>" + objBooks.getBookName() + " has been added.</title></head><body><table width='500' border='0' align='center' cellpadding='15' cellspacing='0' style='font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12pt; color:#5a5a5a;'><tr><td align='left'><p>Dear " + objCustomer.getFirstName() + ",</p></td></tr><tr><td align='left'><p>" + objBooks.getBookName() + " has been updated.</p><br/><br/><p>ISBN: " + objBooks.getISBN() + "<br />Edition: " + objBooks.getEdition() + "<br />Synopsis: " + objBooks.getSynopsis() + "<br />Topics covered: " + objBooks.getTopicsCovered() + "<br /></p><br/><p>Thank you for using  this site.<br /></p><br/><br/><p>Regards,<br /> Bookshop<br /></p><p><br /><br />THIS IS AN AUTOMATED MESSAGE; PLEASE DO NOT REPLY. </p></td></tr></table></body></html>";
                    sendMail.sendMail(bundle.getString("emailFrom"), bundle.getString("emailUser"), bundle.getString("emailFromPasswd"), toEmailAddress, emailSubject, emailMessage);
                }
            }
        }
        finally 
        {
            session.close();
        }
    }
    public void notifyUpdatesToCustomers(Books objBooks) throws Exception
    {
        Session session = HibernateUtil.getSession();

        try 
        {
            Locale locale = ActionContext.getContext().getLocale();
            ResourceBundle bundle = ResourceBundle.getBundle("bookshop", locale);
            if(!bundle.getString("emailFrom").equals("") && !bundle.getString("emailUser").equals("") && !bundle.getString("emailFromPasswd").equals("")) 
            {
                session.beginTransaction();
                List<Customers> customers = session.createQuery("FROM Customers WHERE BookUpdates = 'true'").list();

                for (Iterator i = customers.iterator(); i.hasNext(); ) 
                {
                    Customers objCustomer = (Customers) i.next();
                    String toEmailAddress = objCustomer.getEmailAddress();
                    String emailSubject = "Bookshop: " + objBooks.getBookName() + " has been updated.";
                    String emailMessage = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'/><title>" + objBooks.getBookName() + " has been updated.</title></head><body><table width='500' border='0' align='center' cellpadding='15' cellspacing='0' style='font-family: Verdana, Arial, Helvetica, sans-serif; font-size:12pt; color: #5a5a5a;'><tr><td align='left'><p>Dear " + objCustomer.getFirstName() + ",</p></td></tr><tr><td align='left'><p>" + objBooks.getBookName() + " has been updated.</p><br/><br/><p>ISBN: " + objBooks.getISBN() + "<br />Edition: " + objBooks.getEdition() + "<br />Synopsis: " + objBooks.getSynopsis() + "<br />Topics covered: " + objBooks.getTopicsCovered() + "<br /></p><br/><p>Thank you for using  this site.<br /></p><br/><br/><p>Regards,<br /> Bookshop<br /></p><p><br /><br />THIS IS AN AUTOMATED MESSAGE; PLEASE DO NOT REPLY. </p></td></tr></table></body></html>";
                    sendMail.sendMail(bundle.getString("emailFrom"), bundle.getString("emailUser"), bundle.getString("emailFromPasswd"), toEmailAddress, emailSubject, emailMessage);
                }
            }
        }
        finally 
        {
            session.close();
        }
    }
}