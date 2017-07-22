package frontend_dao;

import org.hibernate.*;

import beans.Transactions;
import common.HibernateUtil;

public class performTransactionHibDao 
{
    public void insert(Transactions objTransactions)
    {
        Session session=HibernateUtil.getSession();
        Transaction tx=null;
        try 
        {
            tx=session.beginTransaction();
            session.save(objTransactions);
            tx.commit();
        }
        catch (RuntimeException e) 
        {
            if(objTransactions != null)
            	tx.rollback();
            throw e;
        }
        finally 
        {
            session.close();
        }
    }
    public int getNextTransactionNo()
    {
        Session session=HibernateUtil.getSession();
        try
        {
            session.beginTransaction();
            Object TransactionNo=session.createSQLQuery("SELECT MAX(TransactionNo)+1 AS TransactionNo FROM Transactions").addScalar("TransactionNo").uniqueResult();
            return Integer.parseInt(TransactionNo.toString());
        }
        catch(RuntimeException e)
        {
        	e.printStackTrace();
            return 1;
        }
        finally
        {
            session.close();
        }
    }
}