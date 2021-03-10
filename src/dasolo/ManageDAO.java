package dasolo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageDAO extends DAO {
	public void insert(ManageVO vo) {
		// 메니저 회원가입 페이지 ...???
		connect();
		// id , name , pw , ordernum, tel, store
		String sql = "insert into MANAGER values(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getManid());
			pst.setString(2, vo.getManname());
			pst.setString(3, vo.getManpw());
			pst.setString(4, vo.getMantel());
			pst.setString(5, vo.getManstore());
			int cnt = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public ManageVO select(String id) {
		connect();
		String sql = "select * from MANAGER where id = ?";
		ManageVO mvo = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				//id,pw,name,store,tel
				mvo = new ManageVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				return mvo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mvo;
		
	}

	public ManageVO get_maninfo(String id) {
		connect();
		String sql = "select * from MANAGER where id = ?";
		ManageVO mvo = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				mvo = new ManageVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return mvo;
	}
	
	public int login(String id, String pw) {
		connect();
		String sql = "select id,pw from MANAGER";
		try {
			Saveid sid = new Saveid();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String nowid = rs.getString(1);
				String nowpw = rs.getString(2);
				if (nowid.equals(id)) {
					if (nowpw.equals(pw)) {
						sid.saveid(id);
						close();
						return 1;
					} else {
						close();
						return 0;
					}
				}
			}
			close();
			return -1;

			// -1���̵� ���� 0��й�ȣ Ʋ�� 1�α��� ���� ??ㅋㅋㅋ
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	public void delete(String manid) {
		connect();
		String sql = "delete from manager where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, manid);
			int cnt = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void update(String pw, String tel, String id) {
		connect();
		String sql = "update manager set pw = ?, tel = ? where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, pw);
			pst.setString(2, tel);
			pst.setString(3, id);
			int cnt = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}