package beans;

public class PopularSearches implements java.io.Serializable 
{
	private Integer SearchNo;
    private String Criteria;
    private String Value;

    public PopularSearches() 
    {}

    public Integer getSearchNo() {
		return SearchNo;
	}

	public void setSearchNo(Integer searchNo) {
		SearchNo = searchNo;
	}

	public String getCriteria() {
		return Criteria;
	}

	public void setCriteria(String criteria) {
		Criteria = criteria;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}
}