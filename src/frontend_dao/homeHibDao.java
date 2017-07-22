package frontend_dao;

import java.util.*;
import org.hibernate.*;
import beans.PopularSearches;
import common.HibernateUtil;

public class homeHibDao 
{
    public List getAllNewReleases() 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            return session.createQuery("FROM Books ORDER BY Year DESC").setMaxResults(10).list();
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
    public List getAllShowAuthors() 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            return session.createQuery("FROM Authors").setMaxResults(10).list();
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
    public List getAllShowPublishers() 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            return session.createQuery("FROM Publishers").setMaxResults(10).list();
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
    public List getAllUpdatedBooks() 
    {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            return session.createQuery("FROM Books WHERE Edition <> 'First' ORDER BY Year DESC").setMaxResults(10).list();
        }
        catch(Exception e) {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally {
            session.close();
        }
    }

    public List getAllTopTitles() 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            return session.createQuery("FROM Books ORDER BY Hits DESC").setMaxResults(10).list();
        }
        catch(Exception e) 
        {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally {
            session.close();
        }
    }
    public List getAllCategories() 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            return session.createQuery("FROM Categories ORDER BY Category").list();
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
    public List getAllBooksForThisCategory(int CategoryNo) 
    {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            return session.createQuery("FROM Books WHERE CategoryNo=:CategoryNo").setInteger("CategoryNo", CategoryNo).setMaxResults(3).list();
        }
        catch(Exception e) {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally {
            session.close();
        }
    }
    public List getAllPopularSearches() 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            deletePopularSearches();
            session.beginTransaction();
            return session.createSQLQuery("SELECT Criteria, Value, COUNT(*) AS Weight FROM PopularSearches GROUP BY Criteria, Value").list();
        }
        catch(Exception e) {
            System.out.print("Error while fetching" + e);
            return null;
        }
        finally {
            session.close();
        }
    }
    public int getTotalPopularSearches()
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            Object TransactionNo = session.createSQLQuery("SELECT COUNT(*) AS Total FROM PopularSearches").addScalar("Total").uniqueResult();
            return Integer.parseInt(TransactionNo.toString());
        }
        finally 
        {
            session.close();
        }
    }
    public void deletePopularSearches() 
    {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try 
        {
            if(getTotalPopularSearches()>600) 
            {
                session.beginTransaction();
                List<PopularSearches> ps = session.createQuery("FROM PopularSearches").setMaxResults(10).list();

                for (Iterator i = ps.iterator(); i.hasNext();) 
                {
                    tx = session.beginTransaction();
                    Object objPs = i.next();
                    session.delete(objPs);
                    tx.commit();
                }
            }
        }
        catch(Exception e) 
        {
            System.out.print("Error while deleting" + e);
        }
        finally 
        {
            session.close();
        }
    }
}