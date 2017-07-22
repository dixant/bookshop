package frontend_dao;

import org.hibernate.*;
import beans.Books;
import common.HibernateUtil;

public class showBookDetailsHibDao 
{
    public Books getAllBooks(int BookNo) 
    {
        Session session = HibernateUtil.getSession();
        try 
        {
            session.beginTransaction();
            Query query = session.createQuery("FROM Books WHERE BookNo=:BookNo");
            query.setInteger("BookNo", BookNo);
            Books objBook = (Books) query.uniqueResult();
            updateHits(objBook);
            return objBook;
        }
        finally
        {
            session.close();
        }
    }
    public void updateHits(Books objBooks) 
    {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try 
        {
            tx = session.beginTransaction();
            objBooks.setHits(objBooks.getHits()+1);
            session.update(objBooks);
            tx.commit();
        }
        catch (RuntimeException e) 
        {
            if(objBooks != null)
                tx.rollback();
            throw e;
        }
        finally 
        {
            session.close();
        }
    }
}