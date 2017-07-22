package beans;

public class Categories implements java.io.Serializable
{
	private int CategoryNo;
	private String Category, Description;
	
	public Categories(){}
	
	public int getCategoryNo() {
		return CategoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.CategoryNo = categoryNo;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		this.Category = category;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}
}
