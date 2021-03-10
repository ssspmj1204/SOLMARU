package dasolo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "sol";
	String password = "1234";
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void close() {
		try {
			if(rs != null)rs.close();
			if(pst != null) pst.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
