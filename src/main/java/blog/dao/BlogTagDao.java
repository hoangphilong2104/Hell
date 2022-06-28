package blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import blog.entity.BlogTag;

public class BlogTagDao implements BlogDao<BlogTag>{
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void connect() {
		try {
			Context ctx = new InitialContext();
			Context env = (Context)ctx.lookup("java:/comp/env");
			DataSource ds = (DataSource)env.lookup("jdbc/mysql");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private void closed() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	@Override
	public BlogTag findOne(int id) {
		connect();
		try {
			pstmt = conn.prepareStatement(
					"select * from blog_tag where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				BlogTag tag = new BlogTag();
				tag.setPostId(rs.getInt("post_id"));
				tag.setTag(rs.getString("tag"));
				return tag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed();
		}
		return null;
	}

	@Override
	public List<BlogTag> findAll() {
		connect();
		try {
			pstmt = conn.prepareStatement("select * from blog_tag");
			rs = pstmt.executeQuery();
			List<BlogTag> list = new ArrayList<BlogTag>();
			while(rs.next()) {
				BlogTag tag = new BlogTag();
				tag.setId(rs.getInt("id"));
				tag.setPostId(rs.getInt("post_id"));
				tag.setTag(rs.getString("tag"));
				list.add(tag);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed();
		}
		return null;
	}

	@Override
	public List<BlogTag> find(BlogTag arg) {
		connect();
		try {
			pstmt = conn.prepareStatement(
					"select * from blog_tag where tag=? or post_id=?");
			pstmt.setString(1, arg.getTag());
			pstmt.setInt(2, arg.getPostId());
			rs = pstmt.executeQuery();
			List<BlogTag> list = new ArrayList<BlogTag>();
			while(rs.next()) {
				BlogTag tag = new BlogTag();
				tag.setId(rs.getInt("id"));
				tag.setPostId(rs.getInt("post_id"));
				tag.setTag(rs.getString("tag"));
				list.add(tag);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed();
		}
		return null;
	}

	@Override
	public int insert(BlogTag arg) {
		connect();
		try {
			pstmt = conn.prepareStatement(
					"insert into blog_tag (post_id, tag, tag_clean) "
					+ "values (?,?,'')");
			pstmt.setInt(1, arg.getPostId());
			if(arg.getTag()==null || arg.getTag().isEmpty()) {
				pstmt.setString(2, "");	
			}else {
				pstmt.setString(2, arg.getTag());
			}
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed();
		}
		return 0;
	}

	@Override
	public void update(BlogTag arg) {
		connect();
		try {
			pstmt = conn.prepareStatement(
					"update blog_tag set post_id=?, tag=? where id=?");
			pstmt.setInt(1, arg.getPostId());
			pstmt.setString(2, arg.getTag());
			pstmt.setInt(3, arg.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed();
		}
		
	}

	@Override
	public void delete(int id) {
		connect();
		try {
			pstmt = conn.prepareStatement(
					"delete from blog_tag where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed();
		}
		
	}
	
	

}
