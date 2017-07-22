package frontend_dao;

import java.util.List;
import org.hibernate.*;
import beans.Categories;
import common.HibernateUtil;

public class showAllBooksForCatHibDao 
{
    public Categories getAllCategories(int CategoryNo) 
    {
        Session session=HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            Query query=session.createQuery("FROM Categories WHERE CategoryNo=:CategoryNo");
            query.setInteger("CategoryNo",CategoryNo);
            return (Categories) query.uniqueResult();
        }
        finally 
        {
            session.close();
        }
    }
    public List getAllBooksOfThisCategory(int CategoryNo) 
    {
        Session session = HibernateUtil.getSession();
        try
        {
            Query query = session.createQuery("FROM Books WHERE CategoryNo=:CategoryNo");
            query.setInteger("CategoryNo",CategoryNo);
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