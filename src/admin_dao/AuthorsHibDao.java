package admin_dao;

import org.hibernate.*;
import beans.Authors;
import common.HibernateUtil;

public class AuthorsHibDao 
{
	public void insert(Authors objAuthors)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.save(objAuthors);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(objAuthors!=null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public void update(Authors objAuthors)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.update(objAuthors);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(objAuthors!=null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public void delete(int AuthorNo)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		Object Authors=null;
		
		try
		{
			tx=session.beginTransaction();
			Authors=session.load(Authors.class, AuthorNo);
			session.delete(Authors);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(Authors!=null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public Authors edit(int AuthorNo)
	{
		Session session=HibernateUtil.getSession();
		try
		{
			session.beginTransaction();
			Query query=session.createQuery("FROM Authors WHERE AuthorNo=:AuthorNo");
			query.setInteger("AuthorNo", AuthorNo);
			return (Authors)query.uniqueResult();
		}
		finally
		{
			session.close();
		}
	}
}