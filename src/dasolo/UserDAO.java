package dasolo;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends DAO {

	public void insert(UserVO vo) {
		connect();
		// id , name , pw , tel
		String sql = "insert into MEMBER values(?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getUsrid());
			pst.setString(2, vo.getUsrpw());
			pst.setString(3, vo.getUsrname());
			pst.setString(4, vo.getUsrtel());
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

	public ArrayList<String> check_id() {
		connect();
		String sql = "select id from MEMBER";
		ArrayList<String> idlist = new ArrayList<String>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				idlist.add(rs.getString(1));
			}
			// -1���̵� ���� 0��й�ȣ Ʋ�� 1�α��� ����
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return idlist;
	}
	public UserVO get_usrinfo(String id) {
		connect();
		String sql = "select * from MEMBER where id = ?";
		UserVO uvo = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				uvo = new UserVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			// -1���̵� ���� 0��й�ȣ Ʋ�� 1�α��� ����
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return uvo;
	}

	// id, pw �ָ� db�� ��� id,pw�� ���ϰ�
	// id�� ������ pw �� ����
	// -1 아이디 없음 0 비밀번호 틀림 1 성공
	public int login(String id, String pw) {
		connect();
		String sql = "select id,pw from MEMBER";
		int result = 0;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String nowid = rs.getString(1);
				String nowpw = rs.getString(2);
				if (nowid.equals(id)) {
					if (nowpw.equals(pw)) {
						System.out.println("pw맞음");
						close();
						return 1;
					}
					else {
						System.out.println("pw틀림");
						close();
						return 0;
					}
				}
			}
			System.out.println("id없음");
			close();
			return -1;

			// -1���̵� ���� 0��й�ȣ Ʋ�� 1�α��� ����
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public void delete(String usrid) {
		connect();
		String sql = "delete from member where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, usrid);
			int cnt = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void update(String pw, String tel, String id) {
		connect();
		String sql = "update member set pw = ?, tel = ? where id = ?";
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