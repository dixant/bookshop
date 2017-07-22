package frontend;

import java.util.*;
import com.opensymphony.xwork2.*;
import beans.CartItem;
import org.apache.struts2.interceptor.SessionAware;

public class cartAction extends ActionSupport implements SessionAware
{
    private List cartItems;
    private int BookNo, Cost, totalCost;
    private String BookName;
    private Map session;

    public int getBookNo() {
        return BookNo;
    }
    public void setBookNo(int BookNo) {
        this.BookNo = BookNo;
    }
    public int getCost() {
        return Cost;
    }
    public void setCost(int Cost) {
        this.Cost = Cost;
    }
    public int getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
    public String getBookName() {
        return BookName;
    }
    public void setBookName(String BookName) {
        this.BookName = BookName;
    }
    public Map getSession() {
        return session;
    }
    public void setSession(Map session) {
        this.session = session;
    }
    public List getCartItems() {
        return cartItems;
    }
    public void setCartItems(List cartItems) {
        this.cartItems = cartItems;
    }
    public String show() throws Exception
    {
        cartItems = new ArrayList();
        for (Iterator it = session.entrySet().iterator(); it.hasNext();) 
        {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();

            if(!(key.toString().equals("username") || key.toString().equals("lastlogin") || key.toString().equals("lastip")))
            {
                CartItem cart = new CartItem();
                cart.setBookName(key.toString());
                cart.setCost(value.toString());
                totalCost += Integer.parseInt(value.toString());
                cartItems.add(cart);
            }
        }
        return SUCCESS;
    }
    public String addBook() throws Exception
    {
        String datetime = (new java.util.Date()).toString();
        String book = datetime + " - " + BookName;
        int cost = Cost;
        session = ActionContext.getContext().getSession();
        session.put(book, cost);
        return SUCCESS;
    }
    public String removeBook() throws Exception
    {
        session = ActionContext.getContext().getSession();
        session.remove(BookName);
        return SUCCESS;
    }
}