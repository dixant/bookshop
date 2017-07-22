package common;

import java.util.List;
import admin_dao.populateDdlbsHibDao;
import beans.*;

public class populateDdlbs 
{
	private List<Countries> ddlbCountries;
	private List<CityState> ddlbCitiesStates;
	private List<Authors> ddlbAuthors;
	private List<Publishers> ddlbPublishers;
	private List<Categories> ddlbCategories;
	
	private populateDdlbsHibDao populateDdlbsService=new populateDdlbsHibDao();
	
	public populateDdlbs()
	{
		ddlbCountries=populateDdlbsService.getAllCountries();
		ddlbCitiesStates=populateDdlbsService.getAllCitiesStates();
		ddlbAuthors=populateDdlbsService.getAllAuthors();
		ddlbPublishers=populateDdlbsService.getAllPublishers();
		ddlbCategories=populateDdlbsService.getAllCategories();
	}
	public List<Countries> getDdlbCountries() {
		return ddlbCountries;
	}
	public void setDdlbCountries(List<Countries> ddlbCountries) {
		this.ddlbCountries = ddlbCountries;
	}
	public List<CityState> getDdlbCitiesStates() {
		return ddlbCitiesStates;
	}
	public void setDdlbCitiesStates(List<CityState> ddlbCitiesStates) {
		this.ddlbCitiesStates = ddlbCitiesStates;
	}
	public List<Authors> getDdlbAuthors() {
		return ddlbAuthors;
	}
	public void setDdlbAuthors(List<Authors> ddlbAuthors) {
		this.ddlbAuthors = ddlbAuthors;
	}
	public List<Publishers> getDdlbPublishers() {
		return ddlbPublishers;
	}
	public void setDdlbPublishers(List<Publishers> ddlbPublishers) {
		this.ddlbPublishers = ddlbPublishers;
	}
	public List<Categories> getDdlbCategories() {
		return ddlbCategories;
	}
	public void setDdlbCategories(List<Categories> ddlbCategories) {
		this.ddlbCategories = ddlbCategories;
	}
}
