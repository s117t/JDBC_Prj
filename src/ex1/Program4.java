package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// INSERT Program
public class Program4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int id = 5;
		
		String url = "jdbc:mysql://localhost:3306/jspdb?serverTimezone=UTC";
		String sql = "DELETE FROM NOTICE WHERE ID=?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","3302");
//		Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, id);
		
		int  result = st.executeUpdate();
		
		System.out.println(result);
		
		
		st.close();
		con.close();
	}

}
