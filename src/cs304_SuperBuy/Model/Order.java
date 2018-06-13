package cs304_SuperBuy.Model;

public class Order {
     private OrderStatus status;
     private static Integer oid;

     public Order(Integer id) {
          oid = id;
          status = OrderStatus.IN_PROCESS;
     }

     public static Integer getOid() {
          return oid;
     }

     public OrderStatus getStatus() {
          return status;
     }
     public void setStatus(OrderStatus st){
          status = st;
     }
     public void setOid(Integer id) {
          oid = id;
     }
}
