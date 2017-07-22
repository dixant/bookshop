package admin_dao;

import org.hibernate.*;
import beans.CityState;
import common.HibernateUtil;

public class CityStateHibDao 
{
	public void insert(CityState objCityState)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.save(objCityState);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(objCityState!=null)
			{
				tx.rollback();
			}
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public void update(CityState objCityState)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		
		try
		{
			tx=session.beginTransaction();
			session.update(objCityState);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(objCityState!=null)
			{
				tx.rollback();
			}
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public void delete(int CityStateNo)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		Object CityState=null;
		
		try
		{
			tx=session.beginTransaction();
			CityState=session.load(CityState.class, CityStateNo);
			session.delete(CityState);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(CityState!=null)
				tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	public CityState edit(int CityStateNo)
	{
		Session session=HibernateUtil.getSession();
		try
		{
			session.beginTransaction();
			Query query=session.createQuery("FROM CityState WHERE CityStateNo=:CityStateNo");
			query.setInteger("CityStateNo", CityStateNo);
			return(CityState)query.uniqueResult();
		}
		finally
		{
			session.close();
		}
	}
}