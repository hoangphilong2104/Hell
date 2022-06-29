package blog.service;

import blog.dao.BlogFileDao;
import blog.dao.BlogMemoryDao;
import blog.dao.accountDao;
import blog.entity.BlogAccount;

public class BlogWebService extends BlogService {
	private accountDao accountdao;

	public BlogWebService(BlogMemoryDao blogMemoryDao) {
		super(blogMemoryDao);
	}

	public BlogWebService() {
		super(new BlogFileDao());
		accountdao = new accountDao();
	}

	public void addAccount(BlogAccount account) {
		// TODO : validation
		if (account != null) {
			accountdao.insert(account);
		}
	}
	//cach1
//	public BlogAccount findAccount(String username) {
//		return accountdao.findOne(username);
//	}
//
//	public BlogAccount findAccount(String username, String password) {
//		return accountdao.findOne(username, password);
//	}
	//cach2
	public BlogAccount getAccountUsername(String username) {
		return accountdao.findUsername(username);
	}
	public BlogAccount getAccount(String username, String password) {
		return accountdao.findAccount(username, password);
	}
}
