package frontend;

import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import beans.*;
import frontend_dao.performTransactionHibDao;
import org.apache.struts2.interceptor.SessionAware;

public class performTransactionAction extends ActionSupport implements SessionAware
{
    private performTransactionHibDao transactionsHibDao = new performTransactionHibDao();
    
    private List cartItems;
    private Map session;
    
    public List getCartItems() {
        return cartItems;
    }
    public void setCartItems(List cartItems) {
        this.cartItems = cartItems;
    }
    public Map getSession() {
        return session;
    }
    public void setSession(Map session) {
        this.session = session;
    }
    public String addTransactions() throws Exception
    {
        cartItems = new ArrayList();
        
        for (Iterator it=session.entrySet().iterator(); it.hasNext();) 
        {
            Map.Entry entry = (Map.Entry)it.next();
            Object key=entry.getKey();
            Object value=entry.getValue();
            int transactionNo=transactionsHibDao.getNextTransactionNo();

            if(!(key.toString().equals("username") || key.toString().equals("lastlogin") || key.toString().equals("lastip"))) 
            {
                Transactions transaction = new Transactions();
                
                transaction.setUsername(session.get("username").toString());
                transaction.setBookName(key.toString());
                transaction.setCost(Integer.parseInt(value.toString()));
                transaction.setQty(1);
                transaction.setTransactionDate(new Date());
                transaction.setTransactionNo(transactionNo);
                
                transactionsHibDao.insert(transaction);

                CartItem cart = new CartItem();
                cart.setBookName(key.toString());
                cart.setCost(value.toString());
                cartItems.add(cart);
            }
        }
        return SUCCESS;
    }
}