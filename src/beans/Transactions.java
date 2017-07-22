package beans;

import java.util.Date;

public class Transactions implements java.io.Serializable
{
	private int TransactionDetailNo, TransactionNo, Cost, Qty;
	private Date TransactionDate;
	private String Username, BookName;
	
	public Transactions(){}
	public int getTransactionDetailNo() {
		return TransactionDetailNo;
	}
	public void setTransactionDetailNo(int transactionDetailNo) {
		TransactionDetailNo = transactionDetailNo;
	}
	public int getTransactionNo() {
		return TransactionNo;
	}
	public void setTransactionNo(int transactionNo) {
		TransactionNo = transactionNo;
	}

	public int getCost() {
		return Cost;
	}

	public void setCost(int cost) {
		Cost = cost;
	}

	public int getQty() {
		return Qty;
	}

	public void setQty(int qty) {
		Qty = qty;
	}

	public Date getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		TransactionDate = transactionDate;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	
	
	
}