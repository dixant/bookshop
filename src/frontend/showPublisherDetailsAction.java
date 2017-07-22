package frontend;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import beans.*;
import frontend_dao.showPublisherDetailsHibDao;

public class showPublisherDetailsAction extends ActionSupport
{
    private showPublisherDetailsHibDao publisherDetailsService = new showPublisherDetailsHibDao();
   
    private Publishers publisher;
    private List<Books> books;
    
    public Publishers getPublisher() {
        return publisher;
    }
    public void setPublisher(Publishers publisher) {
        this.publisher = publisher;
    }
    public List<Books> getBooks() {
        return books;
    }
    public void setBooks(List<Books> books) {
        this.books = books;
    }
    public String viewPublisherBooks() throws Exception
    {
        publisher = publisherDetailsService.getAllPublishers(publisher.getPublisherNo());
        books = publisherDetailsService.getAllBooksOfThisPublisher(publisher.getPublisherNo());
        return SUCCESS;
    }
}