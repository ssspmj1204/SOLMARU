package dasolo;

import java.sql.SQLException;
import java.util.ArrayList;

public class BasketDAO extends DAO {
	public ArrayList<BasketVO> select(String usrid) {
		connect();
		// String foodName, int price, int foodtime, String storeName, String cal
		String sql = "select * from basket where member_id = ?";
		ArrayList<BasketVO> baksetlist = new ArrayList<BasketVO>();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, usrid);

			rs = pst.executeQuery();
			// String usrId, String foodName, int money, int basketkey, int foodCnt
			while (rs.next()) {
				baksetlist.add(new BasketVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}
		return baksetlist;

	}
	public BasketVO select(String usrid,String foodname) {
		connect();
		// String foodName, int price, int foodtime, String storeName, String cal
		String sql = "select * from basket where member_id = ? and food = ?";
		BasketVO bvo = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, usrid);
			pst.setString(2, foodname);

			rs = pst.executeQuery();
			// String usrId, String foodName, int money, int basketkey, int foodCnt
			while (rs.next()) {
				bvo = new BasketVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}
		return bvo;

	}
	public BasketVO select_by_basketkey(String basketkey) {
		connect();
		// String foodName, int price, int foodtime, String storeName, String cal
		String sql = "select * from basket where basketkey = ?";
		BasketVO bvo = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, basketkey);

			rs = pst.executeQuery();
			// String usrId, String foodName, int money, int basketkey, int foodCnt
			while (rs.next()) {
				bvo = new BasketVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}
		return bvo;

	}
	
	public ArrayList<BasketVO> select() {
		connect();
		// String foodName, int price, int foodtime, String storeName, String cal
		String sql = "select * from basket";
		ArrayList<BasketVO> baksetlist = new ArrayList<BasketVO>();

		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			// String usrId, String foodName, int money, int basketkey, int foodCnt
			while (rs.next()) {
				baksetlist.add(new BasketVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}
		return baksetlist;

	}
	//Basketvo�� �޾� DB�� ����
	public void insert(BasketVO vo) {
		connect();
		String sql = "insert into BASKET values(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,vo.getUsrId());
			pst.setString(2,vo.getFoodName());
			pst.setInt(3,vo.getMoney());
			pst.setString(4,vo.getBasketkey());
			pst.setInt(5,vo.getFoodCnt());
			
			int cnt = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	//usrid�� �ָ� basket���� ���̵� �ش��ϴ� ������ ����
	public void delete(String usrid) {
		connect();
		String sql = "delete from basket where member_id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,usrid);
			int cnt = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	public void delete_by_basketkey(String basket) {
		connect();
		String sql = "delete from basket where basketkey = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,basket);
			int cnt = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public void delete(String usrid,String foodname) {
		connect();
		String sql = "delete from basket where member_id = ? and food = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,usrid);
			pst.setString(2,foodname);
			int cnt = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}

	
}

