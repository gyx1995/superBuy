package cs304_SuperBuy.Model;


import java.sql.Date;

public class Auction {
    private Integer a_id;
    private Integer a_mid;  // foreign key
    private Integer a_iid;  // foreign key when add an auction, needs to check if the item's quantiy > 0
    private Date    a_startdate; //not sure if we need this
    private Date    a_enddate;  //date? String str = String.format("%tF",a_date); //F (2004-02-09) ending date
    private float   askprice;  //double better
    private Float   bidprice;  //double better, null if not reaching the enddate,
    private Integer a_cid;     // keep track of the most potential cid (if pased auction, a_cid would be the final bidder)


    public Auction(Integer aid, Integer mid, Integer iid, Date startdate, Date enddate, float askprice){
        // didn't pass all parameters, need to check if it is working
        this.a_id = aid;
        this.a_mid = mid;
        this.a_iid = iid;
        this.a_startdate = startdate;
        this.a_enddate = enddate;
        this.askprice = askprice;
        this.bidprice = null; //?
        this.a_cid = null;
    }

    public Integer getA_id() {
        return this.a_id;
    }
    public Integer getA_mid() {
        return this.a_mid;
    }
    public Integer getA_iid() {
        return this.a_iid;
    }
    public Date getA_startdate() {
        return this.a_startdate;
    }
    public Date getA_enddate() {
        return this.a_enddate;
    }
    public float getA_askprice() {
        return this.askprice;
    }
    public float getA_bidprice() {
        return this.bidprice;
    }
    public Integer getA_cid() {
        return this.a_cid;
    }
    //setters
    public void setA_id(Integer aid) {
        this.a_id = aid;
    }
    public void setA_mid(Integer mid) {
        this.a_mid = mid;
    }
    public void setA_iid(Integer iid) {
        this.a_iid = iid;
    }
    public void setA_startdate(Date startdate) {
        this.a_startdate = startdate;
    }
    public void setA_enddate(Date enddate) {
        this.a_enddate = enddate;
    }
    public void setA_askprice(float askprice) {
        this.askprice = askprice;
    }
    public void setA_bidprice(float bidprice) {
        this.bidprice = bidprice;
    }
    public void setA_cid(Integer cid) {
        this.a_cid = cid;
    }
}