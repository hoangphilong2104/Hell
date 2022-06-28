package blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;
import java.util.function.Function;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import blog.entity.BlogPost;


public class BlogPostDao implements BlogDao<BlogPost>{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private void connect() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void closed() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object action(Function<String, Object> action) {
		connect();
		try {
			return action.apply("apply: ");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			closed();
		}
		return null;
	}
	@Override
	public BlogPost findOne(int id) {
		return (BlogPost)action((s)->{
			String sql = "select * from blog_post where id = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BlogPost post = new BlogPost();
					return post;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}
	@Override
	public List<BlogPost> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BlogPost> find(BlogPost arg) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int insert(BlogPost arg) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void update(BlogPost arg) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
