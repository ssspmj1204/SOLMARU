package dasolo;

import java.util.ArrayList;

public class BasketVO {
	String usrId;
	String foodName;
	int money;
	String basketkey;
	int foodCnt;

	public BasketVO(String usrId, String foodName, int money, String basketkey, int foodCnt) {
		super();
		this.usrId = usrId;
		this.foodName = foodName;
		this.money = money;
		this.basketkey = basketkey;
		this.foodCnt = foodCnt;
	}
	
	
	public String getUsrId() {
		return usrId;
	}
	public String getFoodName() {
		return foodName;
	}
	public int getMoney() {
		return money;
	}
	public int getFoodCnt() {
		return foodCnt;
	}
	public String getBasketkey() {
		return basketkey;
	}
	
	
	

}
