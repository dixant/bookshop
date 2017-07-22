package frontend;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import beans.*;
import frontend_dao.showAuthorDetailsHibDao;

public class showAuthorDetailsAction extends ActionSupport
{
    private showAuthorDetailsHibDao authorDetailsService = new showAuthorDetailsHibDao();
    
    private Authors author;
    private List<Books> books;
    
    public Authors getAuthor() 
    {
        return author;
    }
    public void setAuthor(Authors author) 
    {
        this.author = author;
    }
    public List<Books> getBooks() 
    {
        return books;
    }
    public void setBooks(List<Books> books) 
    {
        this.books = books;
    }
    public String viewAuthorBooks() throws Exception
    {
        author=authorDetailsService.getAllAuthors(author.getAuthorNo());
        books=authorDetailsService.getAllBooksOfThisAuthor(author.getAuthorNo());
        return SUCCESS;
    }
}