package dasolo;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO extends DAO {
	public ArrayList<OrderVO> select(int order_num) {
		connect();
		// String foodName, int price, int foodtime, String storeName, String cal
		String sql = "select * from foodorder where order_num = ?";
		ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, order_num);

			rs = pst.executeQuery();
			// String usrId, String foodName, int money, int basketkey, int foodCnt
			while (rs.next()) {
				orderlist.add(new OrderVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}
		return orderlist;

	}

	public ArrayList<OrderVO> select() {
		connect();
		// String foodName, int price, int foodtime, String storeName, String cal
		String sql = "select * from foodorder";
		ArrayList<OrderVO> orderlist = new ArrayList<OrderVO>();

		try {
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();
			// String usrId, String foodName, int money, int basketkey, int foodCnt
			while (rs.next()) {
				orderlist.add(new OrderVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}
		return orderlist;

	}

	public BasketVO get_basket(OrderVO ovo) {
		BasketDAO bdao = new BasketDAO();
		BasketVO bvo = bdao.select_by_basketkey(ovo.getBasket_key());
		return bvo;
	}

	public OrderVO select(String basketkey) {
		connect();
		// String foodName, int price, int foodtime, String storeName, String cal
		String sql = "select * from foodorder where basket = ?";
		OrderVO ovo = null;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, basketkey);
			rs = pst.executeQuery();
			// String usrId, String foodName, int money, int basketkey, int foodCnt
			while (rs.next()) {
				ovo = new OrderVO(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}
		return ovo;

	}

	public ArrayList<OrderVO> find_store_order(String Store_name) {
		BasketDAO bdao = new BasketDAO();
		FoodDAO fdao = new FoodDAO();
		ArrayList<OrderVO> ovolist = select();
		ArrayList<BasketVO> bvolist = bdao.select();
		ArrayList<FoodVO> fvolist = fdao.selectStorefood(Store_name);
		ArrayList<OrderVO> newlist = new ArrayList<OrderVO>();
		FoodDAO fdao1 = new FoodDAO();
		for(int i = 0 ; i < ovolist.size(); i++) {
			BasketVO nbvo = get_basket(ovolist.get(i));
			String foodname = nbvo.getFoodName();
			FoodVO nfvo = fdao1.select_by_food(foodname);
			String storename = nfvo.getStoreName();
			if(Store_name.equals(storename)) {
				newlist.add(ovolist.get(i));
			}
		}
		
		return newlist;
	}
	public ArrayList<OrderVO> find_usr_order(String usrid) {
		BasketDAO bdao = new BasketDAO();
		FoodDAO fdao = new FoodDAO();
		ArrayList<OrderVO> ovolist = select();
		ArrayList<BasketVO> bvolist = bdao.select(usrid);
		ArrayList<OrderVO> newlist = new ArrayList<OrderVO>();
		FoodDAO fdao1 = new FoodDAO();
		for(int i = 0 ; i < ovolist.size(); i++) {
			for(int j = 0 ; j < bvolist.size() ; j++) {
				if(ovolist.get(i).getBasket_key().equals(bvolist.get(j).getBasketkey())) {
					newlist.add(ovolist.get(i));
				}
			}
		}
		
		return newlist;
	}

	public void insert(ArrayList<BasketVO> volist, String Storename) {
		connect();
		int seqnum = 0;
		if (Storename.equals("제라진돈까스"))
			seqnum = 1;
		else if (Storename.equals("중화가정"))
			seqnum = 2;
		else if (Storename.equals("salady"))
			seqnum = 3;
		else if (Storename.equals("더큰도시락"))
			seqnum = 4;
		String sql = "insert into foodorder values(seq" + seqnum + ".NEXTVAL,?,sysdate)";
		String next_sql = "insert into foodorder values(seq" + seqnum + ".CURRVAL,?,sysdate)";
		try {
			for (int i = 0; i < volist.size(); i++) {
				if (i == 0) {
					pst = conn.prepareStatement(sql);
				} else {
					pst = conn.prepareStatement(next_sql);
				}
				pst.setString(1, volist.get(i).getBasketkey());

				int cnt = pst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void delete(int ordernum) { // 주문 삭제하면 자동으로 배스킷에서도 삭제
		connect();
		ArrayList<OrderVO> ovolist = select(ordernum);
		connect();
		BasketDAO bdao = new BasketDAO();
		String sql = "delete from foodorder where order_num = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, ordernum);
			int cnt = pst.executeUpdate();
			for (int i = 0; i < ovolist.size(); i++)
				bdao.delete_by_basketkey(ovolist.get(i).getBasket_key());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

}
