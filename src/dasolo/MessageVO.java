package dasolo;

public class MessageVO {
   int message_num;
   String message_time;
   String notice;
   String store_name;
   
   public MessageVO(int message_num, String message_time, String notice, String store_name) {
      super();
      this.message_num = message_num;
      this.message_time = message_time;
      this.notice = notice;
      this.store_name = store_name;
   }

   public int getMessage_num() {
      return message_num;
   }

   public String getMessage_time() {
      return message_time;
   }

   public String getNotice() {
      return notice;
   }

   public String getStore_name() {
      return store_name;
   }

   public void setStore_name(String store_name) {
      this.store_name = store_name;
   }

   public void setMessage_num(int message_num) {
      this.message_num = message_num;
   }

   public void setMessage_time(String message_time) {
      this.message_time = message_time;
   }

   public void setNotice(String notice) {
      this.notice = notice;
   }
   
   
   
}