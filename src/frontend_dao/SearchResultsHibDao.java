package frontend_dao;

import java.util.*;
import org.hibernate.*;
import beans.*;
import common.HibernateUtil;

public class SearchResultsHibDao 
{
    public void insertPopularSearches(PopularSearches objPopularSearches) 
    {
        Session session=HibernateUtil.getSession();
        Transaction tx=null;
        try 
        {
            tx=session.beginTransaction();
            session.save(objPopularSearches);
            tx.commit();
        }
        catch (RuntimeException e) 
        {
            if(objPopularSearches != null)
                tx.rollback();
            throw e;
        }
        finally 
        {
            session.close();
        }
    }
    public List getAllBooksSearchResults(String SearchCriteria) 
    {
        Session session=HibernateUtil.getSession();
        try
        {
            session.beginTransaction();
            String strQuery = "SELECT * FROM Books WHERE BookName LIKE '%"+ SearchCriteria + "%' OR ISBN LIKE '%"+ SearchCriteria + "%' OR Edition LIKE '%"+ SearchCriteria + "%' OR Year LIKE '%"+ SearchCriteria + "%' OR Synopsis LIKE '%"+ SearchCriteria + "%' OR AboutAuthors LIKE '%"+ SearchCriteria + "%' OR TopicsCovered LIKE '%"+ SearchCriteria + "%' OR ContentsCDROM LIKE '%"+ SearchCriteria + "%' OR Cost LIKE '%"+ SearchCriteria + "%'";
            Query query = session.createSQLQuery(strQuery).addEntity(Books.class);
            PopularSearches ps = new PopularSearches();
            ps.setCriteria("book");
            ps.setValue(SearchCriteria);
            insertPopularSearches(ps);
            return query.list();
        }
        finally 
        {
            session.close();
        }
    }
    public List getAllAuthorsSearchResults(String SearchCriteria) 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            String strQuery = "SELECT * FROM Authors WHERE FirstName LIKE '%"+ SearchCriteria + "%' OR LastName LIKE '%"+ SearchCriteria + "%' OR Address1 LIKE '%"+ SearchCriteria + "%' OR Address2 LIKE '%"+ SearchCriteria + "%' OR CityStateNo LIKE '%"+ SearchCriteria + "%' OR CountryNo LIKE '%"+ SearchCriteria + "%' OR Pincode LIKE '%"+ SearchCriteria + "%' OR Degree LIKE '%"+ SearchCriteria + "%' OR Speciality LIKE '%"+ SearchCriteria + "%' OR EmailAddress LIKE '%"+ SearchCriteria + "%'";
            Query query = session.createSQLQuery(strQuery).addEntity(Authors.class);
            PopularSearches ps = new PopularSearches();
            ps.setCriteria("author");
            ps.setValue(SearchCriteria);
            insertPopularSearches(ps);
            return query.list();
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
            Query query = session.createQuery("FROM Books WHERE Author1No = :AuthorNo OR Author2No = :AuthorNo OR Author3No = :AuthorNo OR Author4No = :AuthorNo");
            query.setInteger("AuthorNo",AuthorNo);
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
    public List getAllPublishersSearchResults(String SearchCriteria) 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            String strQuery = "SELECT * FROM Publishers WHERE PublisherName LIKE '%"+ SearchCriteria + "%' OR Address1 LIKE '%"+ SearchCriteria + "%' OR Address2 LIKE '%"+ SearchCriteria + "%' OR CityStateNo LIKE '%"+ SearchCriteria + "%' OR CountryNo LIKE '%"+ SearchCriteria + "%' OR Pincode LIKE '%"+ SearchCriteria + "%' OR EmailAddress LIKE '%"+ SearchCriteria + "%'";
            Query query = session.createSQLQuery(strQuery).addEntity(Publishers.class);
            PopularSearches ps = new PopularSearches();
            ps.setCriteria("publisher");
            ps.setValue(SearchCriteria);
            insertPopularSearches(ps);
            return query.list();
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
            Query query = session.createQuery("FROM Books WHERE PublisherNo=:PublisherNo");
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