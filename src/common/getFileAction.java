package common;

import java.sql.*;
import java.io.InputStream;
import org.hibernate.*;
import com.opensymphony.xwork2.ActionSupport;

public class getFileAction extends ActionSupport
{
	private String columnName, tableName, whereClause, whereClauseValue;
	private InputStream iStream=null;
	
	public getFileAction(){}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getWhereClause() {
		return whereClause;
	}
	public void setWhereClause(String whereClause) {
		this.whereClause = whereClause;
	}
	public String getWhereClauseValue() {
		return whereClauseValue;
	}
	public void setWhereClauseName(String whereClauseValue) {
		this.whereClauseValue = whereClauseValue;
	}
	public InputStream getiStream() {
		return iStream;
	}
	public void setiStream(InputStream iStream) {
		this.iStream = iStream;
	}
	@Override
	public String execute() throws Exception
	{
		Session session=HibernateUtil.getSession();
		try
		{
			session.beginTransaction();
			String strQuery="SELECT "+columnName+" FROM "+tableName+" WHERE "+whereClause+"="+whereClauseValue;
			Query query=session.createSQLQuery(strQuery).addScalar(columnName,Hibernate.BLOB);
			Blob blobFile=(Blob)query.uniqueResult();
			iStream=blobFile.getBinaryStream();
		}
		catch(Exception e)
		{
			session.beginTransaction();
			String strQuery="SELECT Image FROM DefaultValues";
			Query query=session.createSQLQuery(strQuery).addScalar("Image", Hibernate.BLOB);
			Blob blobFile=(Blob)query.uniqueResult();
			iStream=blobFile.getBinaryStream();
		}
		finally
		{
			session.close();
		}
		return SUCCESS;
	}
}