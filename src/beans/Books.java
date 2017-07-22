package beans;

import java.sql.Blob;

public class Books implements java.io.Serializable
{
	private int BookNo, Year, Cost, Hits;
	private Integer Author1No, Author2No, Author3No, Author4No, PublisherNo, CategoryNo;
	private String BookName, ISBN, Edition, Synopsis, AboutAuthors, TopicsCovered, ContentsCDROM;
	private Blob CoverPage, Toc, SampleChapter;
	
	public Books(){}
	
	public int getBookNo() {
		return BookNo;
	}
	public void setBookNo(int bookNo) {
		BookNo = bookNo;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public int getCost() {
		return Cost;
	}

	public void setCost(int cost) {
		Cost = cost;
	}

	public int getHits() {
		return Hits;
	}

	public void setHits(int hits) {
		Hits = hits;
	}

	public Integer getAuthor1No() {
		return Author1No;
	}

	public void setAuthor1No(Integer author1No) {
		Author1No = author1No;
	}

	public Integer getAuthor2No() {
		return Author2No;
	}

	public void setAuthor2No(Integer author2No) {
		Author2No = author2No;
	}

	public Integer getAuthor3No() {
		return Author3No;
	}

	public void setAuthor3No(Integer author3No) {
		Author3No = author3No;
	}

	public Integer getAuthor4No() {
		return Author4No;
	}

	public void setAuthor4No(Integer author4No) {
		Author4No = author4No;
	}

	public Integer getPublisherNo() {
		return PublisherNo;
	}

	public void setPublisherNo(Integer publisherNo) {
		PublisherNo = publisherNo;
	}

	public Integer getCategoryNo() {
		return CategoryNo;
	}

	public void setCategoryNo(Integer categoryNo) {
		CategoryNo = categoryNo;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getEdition() {
		return Edition;
	}

	public void setEdition(String edition) {
		Edition = edition;
	}

	public String getSynopsis() {
		return Synopsis;
	}

	public void setSynopsis(String synopsis) {
		Synopsis = synopsis;
	}

	public String getAboutAuthors() {
		return AboutAuthors;
	}

	public void setAboutAuthors(String aboutAuthors) {
		AboutAuthors = aboutAuthors;
	}

	public String getTopicsCovered() {
		return TopicsCovered;
	}

	public void setTopicsCovered(String topicsCovered) {
		TopicsCovered = topicsCovered;
	}

	public String getContentsCDROM() {
		return ContentsCDROM;
	}

	public void setContentsCDROM(String contentsCDROM) {
		ContentsCDROM = contentsCDROM;
	}

	public Blob getCoverPage() {
		return CoverPage;
	}

	public void setCoverPage(Blob coverPage) {
		CoverPage = coverPage;
	}

	public Blob getToc() {
		return Toc;
	}

	public void setToc(Blob toc) {
		Toc = toc;
	}

	public Blob getSampleChapter() {
		return SampleChapter;
	}

	public void setSampleChapter(Blob sampleChapter) {
		SampleChapter = sampleChapter;
	}

	
	
}
