package dasolo;

public class ManageVO {
   String manid;
   String manpw;
   String manname;
   String mantel;
   String manstore;
   public ManageVO(String manid, String manpw, String manname, String mantel, String manstore) {
      this.manid = manid;
      this.manpw = manpw;
      this.manname = manname;
      this.mantel = mantel;
      this.manstore = manstore;
   }
   public String getManid() {
      return manid;
   }
   public String getManpw() {
      return manpw;
   }
   public String getManname() {
      return manname;
   }
   public String getMantel() {
      return mantel;
   }
   public String getManstore() {
      return manstore;
   }
   public void setManid(String manid) {
      this.manid = manid;
   }
   public void setManpw(String manpw) {
      this.manpw = manpw;
   }
   public void setManname(String manname) {
      this.manname = manname;
   }
   public void setMantel(String mantel) {
      this.mantel = mantel;
   }
   public void setManstore(String manstore) {
      this.manstore = manstore;
   }
   
   
}