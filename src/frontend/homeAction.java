package frontend;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import beans.*;
import frontend_dao.homeHibDao;

public class homeAction  extends ActionSupport
{
    private homeHibDao homeService=new homeHibDao();
    
    private List<Books> books, newReleasesBooks, updatedBooks, topTitlesBooks;
    private List<Authors> authors;
    private List<Publishers> publishers;
    private List<Categories> categories;
    private List popularSearches;
    private int CategoryNo;
    
    public int getCategoryNo() 
    {
        return CategoryNo;
    }
    public void setCategoryNo(int CategoryNo) {
        this.CategoryNo = CategoryNo;
    }
    public List getPopularSearches() {
        return popularSearches;
    }
    public void setPopularSearches(List popularSearches) {
        this.popularSearches = popularSearches;
    }
    public List<Books> getBooks() {
        return books;
    }
    public void setBooks(List<Books> books) {
        this.books = books;
    }
    public List<Books> getNewReleasesBooks() {
        return newReleasesBooks;
    }
    public void setNewReleasesBooks(List<Books> newReleasesBooks) {
        this.newReleasesBooks = newReleasesBooks;
    }
    public List<Books> getUpdatedBooks() {
        return updatedBooks;
    }
    public void setUpdatedBooks(List<Books> updatedBooks) {
        this.updatedBooks = updatedBooks;
    }
    public List<Books> getTopTitlesBooks() {
        return topTitlesBooks;
    }
    public void setTopTitlesBooks(List<Books> topTitlesBooks) {
        this.topTitlesBooks = topTitlesBooks;
    }
    public List<Authors> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }
    public List<Publishers> getPublishers() {
        return publishers;
    }
    public void setPublishers(List<Publishers> publishers) {
        this.publishers = publishers;
    }
    public List<Categories> getCategories() {
        return categories;
    }
    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }
    public String viewBooksForThisCategory() throws Exception
    {
        books=homeService.getAllBooksForThisCategory(CategoryNo);
        return SUCCESS;
    }
    public String view() throws Exception
    {
        newReleasesBooks=homeService.getAllNewReleases();
        authors=homeService.getAllShowAuthors();
        publishers=homeService.getAllShowPublishers();
        updatedBooks=homeService.getAllUpdatedBooks();
        topTitlesBooks=homeService.getAllTopTitles();
        categories=homeService.getAllCategories();
        popularSearches=homeService.getAllPopularSearches();
        return SUCCESS;
    }
}