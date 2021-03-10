package dasolo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManagerOrderListDAO extends DAO{
//   int order_num;
//   String food_name;
//   int cnt;
      //주문번호 별 상품
   PreparedStatement pst1, pst2;
   ResultSet rs1, rs2;
   public ArrayList<ManagerOrderListVO> select() {
      connect();
      String sql1 = "select order_num from foodorder";
      String sql2 = "select food, cnt from basket where basketkey = foodorder.basket";
      ArrayList<ManagerOrderListVO> orderlist = new ArrayList<ManagerOrderListVO>();

      try {
         pst1 = conn.prepareStatement(sql1);
         pst2 = conn.prepareStatement(sql2);
         rs1 = pst.executeQuery();
         rs2 = pst.executeQuery();
         // String usrId, String foodName, int money, int basketkey, int foodCnt
         while (rs1.next()) {
            orderlist.add(new ManagerOrderListVO(rs1.getInt(1), rs2.getString(1), rs2.getInt(2)));
         }
         
         return orderlist;

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();

      }
      return orderlist;

   }
   //complate  
   // 삭제 컴럼에 해당하는 (1. orderlist 2. foodorder, 3. basket ) 삭제
   public void delete() {  
      connect();
      
   }
   
   
   
   
}