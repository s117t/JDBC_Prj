package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/jspdb?serverTimezone=UTC";
		String sql = "SELECT * FROM NOTICE WHERE HIT>=10";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","3302");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		
		while(rs.next()) {			
		
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			String content = rs.getString("CONTENT");
			Timestamp regDate = rs.getTimestamp("REGDATE");
			int hit= rs.getInt("HIT");
		
			System.out.printf("id: %d, title: %s, writerId: %s, regDate: %s, content: %s, hit: %d\n",
					id, title, writerId, regDate, content, hit);
		}
		
		rs.close();
		st.close();
		con.close();
	}

}
