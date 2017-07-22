package admin_dao;

import org.hibernate.*;
import beans.SystemUsers;
import common.HibernateUtil;

public class SystemUsersHibDao 
{
	public void insert(SystemUsers objSystemUsers)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.save(objSystemUsers);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(objSystemUsers!=null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public void update(SystemUsers objSystemUsers)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		
		try
		{
			tx=session.beginTransaction();
			session.update(objSystemUsers);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(objSystemUsers!=null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public void delete(int UserNo)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		Object SystemUsers=null;
		
		try
		{
			tx=session.beginTransaction();
			SystemUsers=session.load(SystemUsers.class, UserNo);
			session.delete(SystemUsers);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(SystemUsers!=null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public SystemUsers edit(int UserNo)
	{
		Session session=HibernateUtil.getSession();
		try
		{
			session.beginTransaction();
			Query query=session.createQuery("FROM SystemUsers WHERE UserNo=:UserNo");
			query.setInteger("UserNo", UserNo);
			return (SystemUsers)query.uniqueResult();
		}
		finally
		{
			session.close();
		}
	}
}