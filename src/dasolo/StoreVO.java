package dasolo;

public class StoreVO {
	String storename;
	String storetel;
	String master;
	int delaynum;

	public StoreVO(String storename, String storetel, String master, int delaynum) {
		super();
		this.storename = storename;
		this.storetel = storetel;
		this.master = master;
		this.delaynum = delaynum;
	}
	public int getDelaynum() {
		return delaynum;
	}
	public void setDelayman(int delaynum) {
		this.delaynum = delaynum;
	}
	public String getStorename() {
		return storename;
	}
	public String getStoretel() {
		return storetel;
	}
	public String getMaster() {
		return master;
	}
	
	
}
