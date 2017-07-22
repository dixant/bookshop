package admin_dao;

import org.hibernate.*;
import beans.Categories;
import common.HibernateUtil;

public class CategoriesHibDao 
{
	public void insert(Categories objCategories)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.save(objCategories);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(objCategories!=null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public void update(Categories objCategories)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.update(objCategories);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(objCategories!=null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public void delete(int CategoryNo)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		Object Categories=null;
		
		try
		{
			tx=session.beginTransaction();
			Categories=session.load(Categories.class, CategoryNo);
			session.delete(Categories);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(Categories!=null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public Categories edit(int CategoryNo)
	{
		Session session=HibernateUtil.getSession();
		try
		{
			session.beginTransaction();
			Query query=session.createQuery("FROM Categories WHERE CategoryNo=:CategoryNo");
			query.setInteger("CategoryNo", CategoryNo);
			return (Categories)query.uniqueResult();
		}
		finally
		{
			session.close();
		}
	}
}