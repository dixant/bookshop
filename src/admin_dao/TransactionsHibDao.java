package admin_dao;

import java.util.List;
import org.hibernate.*;
import common.HibernateUtil;

public class TransactionsHibDao 
{
    public List getAllUsernames() 
    {
        Session session = HibernateUtil.getSession();

        try 
        {
            session.beginTransaction();
            return session.createQuery("FROM Customers").list();
        }
        catch(Exception e) 
        {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally 
        {
            session.close();
        }
    }
    public List getAllEntries(String Username) 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
        	session.beginTransaction();
            Query query = session.createQuery("FROM Transactions WHERE Username = :Username");
            query.setString("Username", Username);
            return query.list();
        }
        catch(Exception e) 
        {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally 
        {
            session.close();
        }
    }
}