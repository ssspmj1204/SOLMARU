package dasolo;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManagerOrderListVO extends DAO{
   int order_num;
   String food_name;
   int cnt;
      
   public ManagerOrderListVO(int order_num, String food_name, int cnt) {
      super();
      this.order_num = order_num;
      this.food_name = food_name;
      this.cnt = cnt;
   }

   public int getOrder_num() {
      return order_num;
   }
   public void setOrder_num(int order_num) {
      this.order_num = order_num;
   }
   public String getFood_name() {
      return food_name;
   }
   public void setFood_name(String food_name) {
      this.food_name = food_name;
   }
   public int getCnt() {
      return cnt;
   }
   public void setCnt(int cnt) {
      this.cnt = cnt;
   }
}