package admin_dao;

import org.hibernate.*;
import beans.Publishers;
import common.HibernateUtil;

public class PublishersHibDao 
{
	public void insert(Publishers objPublishers)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.save(objPublishers);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(objPublishers!=null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public void update(Publishers objPublishers)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;	
		try
		{
			tx=session.beginTransaction();
			session.update(objPublishers);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(objPublishers!=null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public void delete(int PublisherNo)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		Object Publishers=null;
		try
		{
			tx=session.beginTransaction();
			Publishers=session.load(Publishers.class, PublisherNo);
			session.delete(Publishers);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(Publishers!=null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public Publishers edit(int PublisherNo)
	{
		Session session=HibernateUtil.getSession();
		try
		{
			session.beginTransaction();
			Query query=session.createQuery("FROM Publishers WHERE PublisherNo=:PublisherNo");
			query.setInteger("PublisherNo", PublisherNo);
			return (Publishers)query.uniqueResult();
		}
		finally
		{
			session.close();
		}
	}
}