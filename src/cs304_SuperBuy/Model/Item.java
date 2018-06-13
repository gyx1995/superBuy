package cs304_SuperBuy.Model;


public class Item {

    private Integer i_id;
    private int num_instock;
    private float price;
    private Integer m_id;



    /////////????????????????????????????????
//    // default constructor
    public Item(){}
//
//    // minimal constructor
    public Item(Integer i_id){
        this.i_id = i_id;
    }
//////////////???????????????????????????
    // full constructor
    public Item(Integer iid, int num_instock, float price, Integer mid){
        this.i_id = iid;
        this.num_instock = num_instock; //cannot input a negative number
        this.price = price;
        this.m_id = m_id;
    }

    // getters
    public Integer getI_id() {
        return this.i_id;
    }

    public int getNum_instock() {
        return this.num_instock;
    }

    public Integer getM_id () {
        return this.m_id;
    }

    public double getPrice() {
        return this.price;
    }


    // setters
    public void setPrice(float p) {
        this.price = p;
    }
    public void setM_id(Integer mid) {
        this.m_id = mid;
    }
    public void setI_id(Integer iid) {
        this.i_id = iid;
    }

    public void setNum_instock(int i){
        // if statement cannot pass a negative integer here!
        this.num_instock = i;
    }

}
