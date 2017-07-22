package frontend_dao;

import org.hibernate.*;
import beans.Customers;
import common.HibernateUtil;

public class customerLoginHibDao 
{
    public Object validateLogin(String Username, String Password, String LastIP) 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            Query query = session.createQuery("FROM Customers WHERE Username = :Username AND Password = :Password");
            query.setString("Username", Username);
            query.setString("Password", Password);
            Customers objCustomer = (Customers) query.uniqueResult();

            if(objCustomer!=null)
            {
                objCustomer.setLastIP(LastIP);
                objCustomer.setLastLogin((new java.util.Date().toString()));
                updateLastLoginDetails(objCustomer);
            }
            return objCustomer;
        }
        finally
        {
            session.close();
        }
    }
    public void updateLastLoginDetails(Customers objCustomers) 
    {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try 
        {
            tx = session.beginTransaction();
            session.update(objCustomers);
            tx.commit();
        }
        catch (RuntimeException e) 
        {
            if(objCustomers != null)
                tx.rollback();
            throw e;
        }
        finally 
        {
            session.close();
        }
    }
	public Object getPassword(String Username, String EmailAddress) 
	{
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            Query query = session.createQuery("FROM Customers WHERE Username = :Username AND EmailAddress = :EmailAddress");
            query.setString("Username", Username);
            query.setString("EmailAddress", EmailAddress);
            return query.uniqueResult();
        }
        finally 
        {
            session.close();
        }
    }
}