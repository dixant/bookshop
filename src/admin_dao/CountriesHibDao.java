package admin_dao;

import org.hibernate.*;
import beans.Countries;
import common.HibernateUtil;

public class CountriesHibDao 
{
	public void insert(Countries objCountries)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.save(objCountries);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(objCountries!=null)
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
	public void update(Countries objCountries)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			session.update(objCountries);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(objCountries!=null)
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
	public void delete(int CountryNo)
	{
		Session session=HibernateUtil.getSession();
		Transaction tx=null;
		Object Countries=null;
		try
		{
			tx=session.beginTransaction();
			Countries=session.load(Countries.class, CountryNo);
			session.delete(Countries);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(Countries!=null)
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
	public Countries edit(int CountryNo)
	{
		Session session=HibernateUtil.getSession();
		try
		{
			session.beginTransaction();
			Query query=session.createQuery("FROM Countries WHERE CountryNo=:CountryNo");
			query.setInteger("CountryNo", CountryNo);
			return(Countries)query.uniqueResult();
		}
		finally
		{
			session.close();
		}
	}
}