package admin_dao;

import org.hibernate.*;
import beans.Customers;
import common.HibernateUtil;

public class CustomersHibDao 
{
	public void insert(Customers objCustomers)
    {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try 
        {
            tx = session.beginTransaction();
            session.save(objCustomers);
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
    public void update(Customers objCustomers)
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
        finally {
            session.close();
        }
    }
    public void delete(int CustomerNo) 
    {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Object Customers = null;
        try 
        {
            tx = session.beginTransaction();
            Customers = session.load(Customers.class, CustomerNo);
            session.delete(Customers);
            tx.commit();
        }
        catch (RuntimeException e) 
        {
            if(Customers != null)
                tx.rollback();
            throw e;
        }
        finally 
        {
            session.close();
        }
    }
    public Customers edit(int CustomerNo) 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            Query query = session.createQuery("FROM Customers WHERE CustomerNo = :CustomerNo");
            query.setInteger("CustomerNo", CustomerNo);
            return (Customers) query.uniqueResult();
        }
        finally 
        {
            session.close();
        }
    }
}