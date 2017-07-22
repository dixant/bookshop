package admin_dao;

import java.util.List;
import org.hibernate.*;
import beans.*;
import common.HibernateUtil;

public class populateDdlbsHibDao
{
    private List<Countries> countries;
    private List<CityState> citiesstates;
    private List<Authors> authors;
    private List<Publishers> publishers;
    private List<Categories> categories;

    public List getAllCountries() 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            countries = session.createQuery("FROM Countries").list();
            return countries;
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
    public List getAllCitiesStates() 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            citiesstates = session.createQuery("FROM CityState").list();
            return citiesstates;
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
    public List getAllAuthors() 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            authors = session.createQuery("FROM Authors").list();
            return authors;
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
    public List getAllPublishers()
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            publishers = session.createQuery("FROM Publishers").list();
            return publishers;
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
    public List getAllCategories() 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            categories = session.createQuery("FROM Categories").list();
            return categories;
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