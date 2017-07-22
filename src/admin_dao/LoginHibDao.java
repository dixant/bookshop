package admin_dao;

import org.hibernate.Query;
import org.hibernate.Session;
import common.HibernateUtil;

public class LoginHibDao 
{
	public Object validateLogin(String Username, String Password)
	{
		Session session=HibernateUtil.getSession();
		try
		{
			session.beginTransaction();
			Query query=session.createQuery("FROM SystemUsers WHERE Username=:Username AND Password=:Password");
			query.setString("Username", Username);
			query.setString("Password", Password);
			return query.uniqueResult();
		}
		finally
		{
			session.close();
		}
	}
}