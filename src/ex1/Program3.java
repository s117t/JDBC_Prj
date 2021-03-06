package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// INSERT Program
public class Program3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String title = "TEST4";
		String content = "UDATE PROGRAM";
		String files = "";
		int id = 5;
		
		String url = "jdbc:mysql://localhost:3306/jspdb?serverTimezone=UTC";
		String sql = "UPDATE NOTICE SET TITLE = ?, CONTENT=?, FILES =? WHERE ID = ?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","3302");
//		Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		
		int  result = st.executeUpdate();
		
		System.out.println(result);
		
		
		st.close();
		con.close();
	}

}
