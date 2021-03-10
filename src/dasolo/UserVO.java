package dasolo;

public class UserVO {
	String usrid;
	String usrpw;
	String usrname;
	String usrtel;

	public UserVO(String usrid, String usrpw, String usrname, String usrtel) {
		super();
		this.usrid = usrid;
		this.usrpw = usrpw;
		this.usrname = usrname;
		this.usrtel = usrtel;
	}
	public String getUsrid() {
		return usrid;
	}
	public String getUsrpw() {
		return usrpw;
	}
	public String getUsrname() {
		return usrname;
	}
	public String getUsrtel() {
		return usrtel;
	}
	
}
