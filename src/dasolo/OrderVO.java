package dasolo;

public class OrderVO {
	int order_num;
	String basket_key;
	String order_time;
	
	
	
	public OrderVO(int order_num, String basket_key, String order_time) {
		super();
		this.order_num = order_num;
		this.basket_key = basket_key;
		this.order_time = order_time;
	}
	public int getOrder_num() {
		return order_num;
	}
	public String getBasket_key() {
		return basket_key;
	}
	public String getOrder_time() {
		return order_time;
	}
	
	
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public void setBasket_key(String basket_key) {
		this.basket_key = basket_key;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	
	

}
