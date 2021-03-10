package dasolo;

import java.util.ArrayList;

public class FoodVO {
	
	String foodName;
	int price;
	int foodtime;
	String storeName;
	String cal;
	String foodimage;
	

	public FoodVO(String foodName, int price, int foodtime
			, String storeName, String cal, String foodimage) {
		super();
		this.foodName = foodName;
		this.price = price;
		this.foodtime = foodtime;
		this.storeName = storeName;
		this.cal = cal;
		this.foodimage = foodimage;
	}
	public String getStoreName() {
		return storeName;
	}
	public String getFoodName() {
		return foodName;
	}
	public int getPrice() {
		return price;
	}
	public int getFoodtime() {
		return foodtime;
	}
	public String getCal() {
		return cal;
	}
	public String getFoodimage() {
		return foodimage;
	}

	
	
	

}
