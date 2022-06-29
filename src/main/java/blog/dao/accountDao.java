package blog.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import blog.entity.BlogAccount;

public class accountDao implements BlogDao<BlogAccount> {
//	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs;
	private static SqlSessionFactory sqlFactory;
	
	private static SqlSessionFactory getSqlSessionFactory() {
		if( sqlFactory == null ) {
			String resource = "mybatis/mybatis-config.xml";
			Reader rd=null;
			try {
				// ctx.lookup
				rd = Resources.getResourceAsReader(resource);
				sqlFactory = new SqlSessionFactoryBuilder().build(rd);
			} catch (IOException e) {
				e.printStackTrace();
			} 
			if(rd!=null) {
				try {
					rd.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sqlFactory;
	}
//	
//	private void connect() {
//		try {
//			Context ctx = new InitialContext();
//			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
//			conn = ds.getConnection();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private void closed() {
//		try {
//			if (rs != null)
//				rs.close();
//			if (pstmt != null)
//				pstmt.close();
//			if (conn != null)
//				conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	public Object action(Function<String, Object> action) {
//		connect();
//		try {
//			return action.apply("apply");
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			closed();
//		}
//
//		return null;
//
//	}

	@Override
	public BlogAccount findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public BlogAccount findOne(String username) {
		return null;
	}
	
	public BlogAccount findOne(String username, String password) {
		return null;
	}
//	public BlogAccount findOne(String username) {
//		return (BlogAccount) action((s) -> {
//			try {
//				pstmt = conn.prepareStatement("select * from blog_account where username = ?");
//				pstmt.setString(1, username);
//				rs = pstmt.executeQuery();
//				while (rs.next()) {
//					BlogAccount account = new BlogAccount(rs.getString("username"), rs.getString("password"),
//							rs.getString("email"));
//					return account;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return null;
//		});
//	}

//	public BlogAccount findOne(String username, String password) {
//		return (BlogAccount) action((s) -> {
//			try {
//				pstmt = conn.prepareStatement("select * from blog_account where username = ? and password = ?");
//				pstmt.setString(1, username);
//				pstmt.setString(2, password);
//				rs = pstmt.executeQuery();
//				while (rs.next()) {
//					BlogAccount account = new BlogAccount(rs.getString("username"), rs.getString("password"),
//							rs.getString("email"));
//					return account;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return null;
//		});
//	}

	@Override
	public List<BlogAccount> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogAccount> find(BlogAccount arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BlogAccount arg) {
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		session.insert("blog.account.insert", arg);
		session.commit();
		return 0;
	}
//	public int insert(BlogAccount arg) {
//		connect();
//		try {
//			pstmt = conn.prepareStatement("insert into blog_account (username,password,email) values (?,?,?)");
//			pstmt.setString(1, arg.getUsername());
//			pstmt.setString(2, arg.getPassword());
//			pstmt.setString(3, arg.getEmail());
//			return pstmt.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			closed();
//		}
//		return 0;
//	}

	@Override
	public void update(BlogAccount arg) {

	}

	@Override
	public void delete(int id) {

	}
	
	public BlogAccount findUsername(String username) {
		// sql ? SELECT * FROM blog_post ORDER BY id desc LIMIT 1;
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		return (BlogAccount) session.selectOne("blog.account.findUsername", username);
//		session.commit();		
//		return null;
	}
	
	public BlogAccount findAccount(String username,String password) {
		// sql ? SELECT * FROM blog_post ORDER BY id desc LIMIT 1;
		sqlFactory = getSqlSessionFactory();
		SqlSession session = sqlFactory.openSession();
		BlogAccount account = new BlogAccount(username, password, "");
		return (BlogAccount) session.selectOne("blog.account.findAccount", account);
//		session.commit();		
//		return null;
	}
}
