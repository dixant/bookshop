package frontend;

import com.opensymphony.xwork2.ActionSupport;
import beans.Books;
import frontend_dao.showBookDetailsHibDao;

public class showBookDetailsAction extends ActionSupport
{
    private showBookDetailsHibDao bookDetailsService = new showBookDetailsHibDao();
    
    private Books book;
    
    public Books getBook() 
    {
        return book;
    }
    public void setBook(Books book) 
    {
        this.book = book;
    }
    public String viewBooks() throws Exception
    {
        book = bookDetailsService.getAllBooks(book.getBookNo());
        return SUCCESS;
    }
}