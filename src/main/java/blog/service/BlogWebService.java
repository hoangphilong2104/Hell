package blog.service;

import java.util.ArrayList;
import java.util.List;

import blog.dao.BlogAuthorDao;
import blog.dao.BlogFileDao;
import blog.dao.BlogMemoryDao;
import blog.dao.BlogPostDao;
import blog.dao.BlogTagDao;
import blog.dao.BlogUserDao;
import blog.entity.BlogAuthor;
import blog.entity.BlogPost;
import blog.entity.BlogTag;
import blog.entity.BlogUser;

public class BlogWebService extends BlogService{
	private BlogUserDao userdao;
	private BlogTagDao tagdao;
	private BlogAuthorDao authordao;
	private BlogPostDao postdao;
	
	public BlogWebService(BlogMemoryDao blogMemoryDao) {
		super(blogMemoryDao);
		// TODO Auto-generated constructor stub
	}
	public BlogWebService() {
		super(new BlogFileDao());
		// TODO Auto-generated constructor stub
		userdao = new BlogUserDao();
		tagdao = new BlogTagDao();
		postdao = new BlogPostDao();
		
	}
	
	public void addUser(BlogUser user) {
		// TODO : validation
		if( user != null ) {
			if( !user.getEmail().isEmpty() )
				userdao.insert(user);
		}
	}
//add
	public void addTag(BlogTag tag) {
		tagdao.insert(tag);
	}
	public void addPost(BlogPost post) {
		postdao.insert(post);
	}
//Find
	
	//find Tag
	public List<BlogTag> find(BlogTag tag) {
		List<BlogTag> list = tagdao.find(tag);
		return list;
	}
	
	public List<BlogTag> find(String tag) {
		List<BlogTag> listAll = tagdao.findAll();
		List<BlogTag> list = new ArrayList<BlogTag>();
		for(int i = 0; i<listAll.size();i++) {
			if(!listAll.get(i).getTag().isEmpty()) {
				String tmp = String.valueOf(listAll.get(i).getTag());
				if(tmp.equalsIgnoreCase(tag)) {
					BlogTag tmpTag = listAll.get(i);
					list.add(tmpTag);
				}
			}
		}
			return list;
	}
	//find Post
	public List<BlogPost> findPost(BlogPost post) {
		List<BlogPost> list = postdao.find(post);
		return list;
	}
	public BlogPost findPost(int id) {
		BlogPost post = new BlogPost();
		post = postdao.findOne(id);
		return post;
	}
	
	public BlogPost lastPost() {
		List<BlogPost> listAll = postdao.findAll();
		BlogPost post = new BlogPost();
		post = listAll.get(listAll.size()-1);
		return post;
	}
	public BlogPost getPost(int pid) {
//		PageDTO admin;
//			BlogPost post;
//			join
//			BlogUser user;
//			join
//			BlogTag tag;
		return null;
	}
	
	public BlogAuthor getBlogAuthor(int id) {
		BlogAuthor auditor = authordao.findOne(id);
		return auditor;
	}
	
	

}
