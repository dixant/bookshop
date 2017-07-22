package common;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class HibernateUtil 
{
	private static SessionFactory sessionFactory;
	public static void createSessionFactory()
	{
		//It will read session-factory information from hibernate.cfg.xml
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	public static Session getSession()
	{
		return sessionFactory.openSession();
	}
}
