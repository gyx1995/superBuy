package cs304_SuperBuy.Model;

public class ItemOnSale extends Item {
    private static int discountrate;

    public ItemOnSale(Integer i_id, int dr) {
        super(i_id);
        discountrate = dr;
    }

    public int getDR(){
        return discountrate;
    }
    public void setDR(int dr) {
        discountrate = dr;
    }
}
