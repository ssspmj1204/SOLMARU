package dasolo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreDAO extends DAO {
	public ArrayList<StoreVO> select() {
		connect();
		String sql = "select * from Store";
		ArrayList<StoreVO> storelist = new ArrayList<StoreVO>();

		try {
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				storelist.add(new StoreVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}
		return storelist;

	}

	public void insert(StoreVO vo) {
		connect();
		String sql = "insert into Store values(?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getStorename());
			pst.setString(2, vo.getStoretel());
			pst.setString(3, vo.getMaster());
			pst.setInt(4, vo.getDelaynum());

			int cnt = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}
	public void update_cnt_plus(String storename) {
		StoreVO svo = select(storename);
		
		connect();
		String sql = "update STORE set delaynum = ? where store_name = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, svo.getDelaynum()+1);
			pst.setString(2, storename);


			int cnt = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}
	public void update_cnt_minus(String storename) {
		connect();
		StoreVO svo = select(storename);
		String sql = "update set delaynum = ? where storename = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, svo.getDelaynum()-1);
			pst.setString(2, storename);


			int cnt = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void delete(String storename) {
		connect();
		String sql = "delete from Store where Store_name = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, storename);
			int cnt = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}
	public StoreVO select(String storename) {
		connect();
		String sql = "select * from Store where store_name = ? ";
		StoreVO storevo = null;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,storename);
			rs = pst.executeQuery();
			while (rs.next()) {
				storevo = new StoreVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();

		}
		return storevo;
	}
}
