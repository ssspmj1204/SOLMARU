package dasolo;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodDAO extends DAO {

	public void insert(FoodVO vo) {
		connect();
		String sql = "insert into Food values(?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,vo.getFoodName());
			pst.setInt(2,vo.getPrice());
			pst.setInt(3,vo.getFoodtime());
			pst.setString(4,vo.getStoreName());
			pst.setString(5,vo.getCal());
			pst.setString(6, vo.getFoodimage());
			int cnt = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public FoodVO select_by_food(String foodname) {
		connect();
		String sql = "select * from food where food_name = ? ";
		FoodVO foodvo = null;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,foodname);
			rs = pst.executeQuery();
			while (rs.next()) {
				foodvo = new FoodVO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}
		return foodvo;
	}
	
	public ArrayList<FoodVO> selectStorefood(String storeName) {
		connect();
		//String foodName, int price, int foodtime, String storeName, String cal
		String sql = "select * from food where store_name = ?";
		ArrayList<FoodVO> foodlist = new ArrayList<FoodVO>();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, storeName);
			rs = pst.executeQuery();
			while(rs.next()) {
				
				foodlist.add(new FoodVO(rs.getString(1), rs.getInt(2)
						, rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
			
		}
		return foodlist;
		
	}
		public void delete(String Store_name, String Food_name) {
			connect();
			String sql = "delete from food where store_name = ? and food_name =? ";
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1,Store_name);
				pst.setString(2,Food_name);
				int cnt = pst.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			
		}


}
