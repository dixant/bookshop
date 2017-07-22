package admin;

import java.io.*;
import com.opensymphony.xwork2.ActionSupport;
import admin_dao.*;
import beans.Books;
import common.populateDdlbs;
import java.util.List;
import org.hibernate.Hibernate;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class manageBooksAction extends ActionSupport
{
    private BooksHibDao booksService = new BooksHibDao();
    private PaginationHibDao pg = new PaginationHibDao();
    
    private populateDdlbs ddlb = new populateDdlbs();
    private Books book;
    private List<Books> books;
    private File CoverPage, Toc, SampleChapter;
    private int pageNo, pageCount;

    public populateDdlbs getDdlb() {
        return ddlb;
    }
    public void setDdlb(populateDdlbs ddlb) {
        this.ddlb = ddlb;
    }
    public int getPageNo() {
        return pageNo;
    }
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public Books getBook() {
        return book;
    }
    public void setBook(Books book) {
        this.book = book;
    }
    public List<Books> getBooks() {
        return books;
    }
    public void setBooks(List<Books> books) {
        this.books = books;
    }
    public File getSampleChapter() {
        return SampleChapter;
    }
    public void setSampleChapter(File SampleChapter) {
        this.SampleChapter = SampleChapter;
    }
    public File getToc() {
        return Toc;
    }
    public void setToc(File Toc) {
        this.Toc = Toc;
    }
    public File getCoverPage() {
        return CoverPage;
    }
    public void setCoverPage(File CoverPage) {
        this.CoverPage = CoverPage;
    }
    public String insertupdate() throws Exception
    {
        File coverpageImage = null;
        InputStream iStreamCoverPage = null;

        if(CoverPage != null) 
        {
            coverpageImage = new File(CoverPage.toString());
            iStreamCoverPage = new FileInputStream(CoverPage);
            book.setCoverPage(Hibernate.createBlob(iStreamCoverPage));
        }
        File TocPDF = null;
        InputStream iStreamToc = null;
        if(Toc != null) 
        {
            TocPDF = new File(Toc.toString());
            iStreamToc = new FileInputStream(Toc);
            book.setToc(Hibernate.createBlob(iStreamToc));
        }
        File samplechapterPDF = null;
        InputStream iStreamSampleChapter = null;

        if(SampleChapter != null) 
        {
            samplechapterPDF = new File(SampleChapter.toString());
            iStreamSampleChapter = new FileInputStream(SampleChapter);
            book.setSampleChapter(Hibernate.createBlob(iStreamSampleChapter));
        }
        if(book.getBookNo()>0) 
        {
            booksService.update(book);
        }
        else 
        {
            booksService.insert(book);
        }
        return SUCCESS;
    }
    @SkipValidation
    public String view() throws Exception{
        pageNo = 1;
        getPage();
        return SUCCESS;
    }
    @SkipValidation
    public String delete() throws Exception{
        booksService.delete(book.getBookNo());
        return SUCCESS;
    }
    @SkipValidation
    public String edit() throws Exception{
        book = booksService.edit(book.getBookNo());
        view();
        return SUCCESS;
    }
    @SkipValidation
    public String getPage() throws Exception{
        pageCount = pg.getTotalPages("Books");
        books = pg.getPage(pageNo-1, "Books").getList();
        return SUCCESS;
    }
}