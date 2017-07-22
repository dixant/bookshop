package frontend;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import beans.*;
import frontend_dao.*;

public class SearchResultsAction extends ActionSupport
{
    private SearchResultsHibDao SearchResultsService = new SearchResultsHibDao();
    
    private Authors author;
    private Publishers publisher;
    private List<Books> books, authoredBooks, publishedBooks;
    private List<Authors> authors;
    private List<Publishers> publishers;
    private String SearchCriteria, searchType;
    
    public String getSearchCriteria() {
        return SearchCriteria;
    }
    public void setSearchCriteria(String SearchCriteria) {
        this.SearchCriteria = SearchCriteria;
    }
    public String getSearchType() {
        return searchType;
    }
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
    public Authors getAuthor() {
        return author;
    }
    public void setAuthor(Authors author) {
        this.author = author;
    }
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
    public List<Books> getAuthoredBooks() {
        return authoredBooks;
    }
    public void setAuthoredBooks(List<Books> authoredBooks) {
        this.authoredBooks = authoredBooks;
    }
    public List<Books> getPublishedBooks() {
        return publishedBooks;
    }
    public void setPublishedBooks(List<Books> publishedBooks) {
        this.publishedBooks = publishedBooks;
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
    
    public String viewBooksSearchResults() throws Exception
    {
        books = SearchResultsService.getAllBooksSearchResults(SearchCriteria);
        return SUCCESS;
    }
    public String viewAuthorsSearchResults() throws Exception
    {
        authors = SearchResultsService.getAllAuthorsSearchResults(SearchCriteria);
        return SUCCESS;
    }
    public String viewBooksOfThisAuthor() throws Exception
    {
        authoredBooks = SearchResultsService.getAllBooksOfThisAuthor(author.getAuthorNo());
        return SUCCESS;
    }
    public String viewPublishersSearchResults() throws Exception
    {
        publishers = SearchResultsService.getAllPublishersSearchResults(SearchCriteria);
        return SUCCESS;
    }
    public String viewBooksOfThisPublisher() throws Exception
    {
        publishedBooks = SearchResultsService.getAllBooksOfThisPublisher(publisher.getPublisherNo());
        return SUCCESS;
    }
    public String performPopularSearch() throws Exception
    {
        if(searchType.equals("author")) 
        {
            viewAuthorsSearchResults();
        }
        else if(searchType.equals("book"))
        {
            viewBooksSearchResults();
        }
        else if(searchType.equals("publisher"))
        {
            viewPublishersSearchResults();
        }
        return SUCCESS;
    }
}