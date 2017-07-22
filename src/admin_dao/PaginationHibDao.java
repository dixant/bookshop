package admin_dao;

import org.hibernate.Session;
import common.HibernateUtil;
import common.Page;

public class PaginationHibDao 
{
    public Page getPage(int page, String tableName) 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            String query = "FROM " + tableName;
            session.beginTransaction();
            return new Page(session.createQuery(query), page, 10);
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
    public int getTotalPages(String tableName) 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            String total = session.createSQLQuery("SELECT COUNT(*) AS Total FROM " + tableName).addScalar("Total").uniqueResult().toString();
            return (int) Math.ceil(Double.parseDouble(total)/10);
        }
        catch(Exception e) 
        {
            System.out.print("Error while fetching" + e);
            return 0;
        }
        finally 
        {
            session.close();
        }
    }
}