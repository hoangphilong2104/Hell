package blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/blog";
		String user = "root";// 권한의 최소화
		String password = "";
		
		try {
			// load DataSource
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = "insert into blog_user (name, email) values ('james', 'thay@babo.com')";// DML
			Statement stmt = conn.createStatement();
			boolean result = stmt.execute(sql);
			System.out.println(result);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
