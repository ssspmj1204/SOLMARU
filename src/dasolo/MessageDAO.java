package dasolo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MessageDAO extends DAO{
   
   public ArrayList<MessageVO> select() {
      connect();
//      int message_num;
//      String message_time;
//      String notice;
//      String store_name;
      String sql = "select * from message";
      ArrayList<MessageVO> messagelist = new ArrayList<MessageVO>();

      try {
         pst = conn.prepareStatement(sql);

         rs = pst.executeQuery();
         // String usrId, String foodName, int money, int basketkey, int foodCnt
         while (rs.next()) {
            messagelist.add(new MessageVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();

      }
      return messagelist;

   }
   // message_num, message_time, notice, store_name
   public void insert(String text, String managerId) {
      connect();

      String sql = "insert into message values(seq.NEXTVAL, sysdate, ?, ?)";
      String sql2 = "select store_name from manager where id = ?";
      try {
         pst = conn.prepareStatement(sql);
         PreparedStatement pst2 = conn.prepareStatement(sql2);

         pst2.setString(1,managerId);
         String store_name ="";
         rs = pst2.executeQuery();
         if(rs.next()) {
            store_name = rs.getString(1);
         }         
         
//         System.out.println(store_name);
         
         pst.setString(1,text);
         pst.setString(2, store_name);

         int cnt = pst.executeUpdate();

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close();
      }
      
   }   
   
}