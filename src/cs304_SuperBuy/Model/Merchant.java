package cs304_SuperBuy.Model;
import java.util.*;

public class Merchant {


    private Integer m_id;
    private String m_name;
    private int rating; // cannot be null full-5 stars
    private MerchantType type;
    private int sales; // number of items sold, need to update in formal specs

    ////////important
    private List<Item> items;
    private List<Auction> auctions;
    private List<Order> orders;

    //private String m_address; // need to update on form specs, dont need merchant address any more
    //private static password?????


    //default constructor
    public Merchant(){}

    //minimal constructor
    public Merchant(Integer m_id){
        this.m_id = m_id;
    }

    //full constructor
    public Merchant(Integer m_id, String name){
        this.m_id= m_id;
        this.m_name= name;
        this.rating= 1; //set rating to 1 when a shop opens
        this.sales = 0;
        items = new ArrayList<Item>();
        auctions = new ArrayList<Auction>();
        orders = new ArrayList<Order>();
    }

    //getters
    public Integer getM_id(){return this.m_id;}

    public String getM_name() {return this.m_name;}

    public int getRating() {return this.rating;}

    public int getSales() {return this.sales;}
    // the getters about a list should be done using SQL query

    //setters
    // public void setM_id(Integer m_id){this.m_id = m_id;}

    public void setM_name(String m_name){this.m_name = m_name;}
    public  void setSales(int sales) {
        this.sales = sales;
    }
    public void setRatng(int r) {
        this.rating = r;
    }


}
