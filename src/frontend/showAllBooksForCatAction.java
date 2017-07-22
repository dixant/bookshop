package frontend;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import beans.*;
import frontend_dao.showAllBooksForCatHibDao;

public class showAllBooksForCatAction extends ActionSupport
{
    private showAllBooksForCatHibDao booksForCatService = new showAllBooksForCatHibDao();
    
    private Categories category;
    private List<Books> books;
    
    public Categories getCategory() {
        return category;
    }
    public void setCategory(Categories category) {
        this.category = category;
    }
    public List<Books> getBooks() {
        return books;
    }
    public void setBooks(List<Books> books) {
        this.books = books;
    }
    public String viewCategoryBooks() throws Exception
    {
        category=booksForCatService.getAllCategories(category.getCategoryNo());
        books=booksForCatService.getAllBooksOfThisCategory(category.getCategoryNo());
        return SUCCESS;
    }
}