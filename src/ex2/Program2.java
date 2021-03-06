package ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// INSERT Program
public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String title = "TEST2";
		String writerId = "newlec";
		String content = "hahaha";
		String files = "";
		
		String url = "jdbc:mysql://localhost:3306/jspdb?serverTimezone=UTC";
		String sql = "INSERT INTO `jspdb`.`notice`"
				+ "("
				+ "`TITLE`,"
				+ "`WRITER_ID`,"
				+ "`CONTENT`,"
				+ "`FILES`)"
				+ "VALUES (?,?,?,?)";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","3302");
//		Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int  result = st.executeUpdate();
		
		System.out.println(result);
		
		
		st.close();
		con.close();
	}

}
