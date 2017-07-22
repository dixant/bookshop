package frontend_dao;

import java.util.List;
import org.hibernate.*;
import beans.Publishers;
import common.HibernateUtil;

public class showPublisherDetailsHibDao 
{
    public Publishers getAllPublishers(int PublisherNo) 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            Query query = session.createQuery("FROM Publishers WHERE PublisherNo=:PublisherNo");
            query.setInteger("PublisherNo", PublisherNo);
            return (Publishers) query.uniqueResult();
        }
        finally 
        {
            session.close();
        }
    }
    public List getAllBooksOfThisPublisher(int PublisherNo) 
    {
        Session session=HibernateUtil.getSession();
        try 
        {
            Query query = session.createQuery("FROM Books WHERE PublisherNo = :PublisherNo");
            query.setInteger("PublisherNo", PublisherNo);
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