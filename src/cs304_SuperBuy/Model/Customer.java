package cs304_SuperBuy.Model;

/**
 * Created by sxdlw on 14/11/2017.
 */
public class Customer {
    private  Integer c_id;
    private  String c_name;
    private  String c_address;
    private  String c_phonenum;
    // a list of orders

    // password?

    // public Customer(){}    // do we need these default constructors? (since attributes of Customer in our database are all null))

    // public Customer(Integer c_id) {this.c_id = c_id;}

    public Customer(Integer c_id, String c_name, String c_address, String c_phonenum) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_address = c_address;
        this.c_phonenum = c_phonenum;
    }

    public Integer getC_id() {
        return this.c_id;
    }
    public String getC_name() {
        return this.c_name;
    }
    public String getC_address() {
        return this.c_address;
    }
    public String getC_phonenum() {
        return this.c_phonenum;
    }
    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
    public void setC_address(String c_address) {
        this.c_address = c_address;
    }
    public void setC_phonenum(String c_phonenum) {
        this.c_phonenum = c_phonenum;
    }

}