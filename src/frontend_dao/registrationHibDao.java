package frontend_dao;

import org.hibernate.*;
import beans.Customers;
import common.HibernateUtil;

public class registrationHibDao 
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
}