package blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.function.Function;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import blog.entity.BlogUser;

public class BlogUserDao implements BlogDao<BlogUser> {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private void connect() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closed() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object action(Function<String, Object> action) {
		connect();
		try {
			return action.apply("apply");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closed();
		}

		return null;

	}

	@Override
	public BlogUser findOne(int id) {
		return (BlogUser) action((s) -> {
			String sql = "select * from blog_user where user_id=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					BlogUser user = new BlogUser(rs.getInt("user_id"), rs.getString("name"), rs.getString("email"));
					return user;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});

	}

	@Override
	public List<BlogUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogUser> find(BlogUser arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BlogUser arg) {

		return 0;
	}

	@Override
	public void update(BlogUser arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}
}
