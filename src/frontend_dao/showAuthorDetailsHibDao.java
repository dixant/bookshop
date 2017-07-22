package frontend_dao;

import java.util.List;
import org.hibernate.*;
import beans.Authors;
import common.HibernateUtil;

public class showAuthorDetailsHibDao 
{
    public Authors getAllAuthors(int AuthorNo) 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            Query query = session.createQuery("FROM Authors WHERE AuthorNo=:AuthorNo");
            query.setInteger("AuthorNo", AuthorNo);
            return (Authors)query.uniqueResult();
        }
        finally 
        {
            session.close();
        }
    }
    public List getAllBooksOfThisAuthor(int AuthorNo) 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            Query query = session.createQuery("FROM Books WHERE Author1No=:AuthorNo OR Author2No=:AuthorNo OR Author3No = :AuthorNo OR Author4No = :AuthorNo");
            query.setInteger("AuthorNo", AuthorNo);
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