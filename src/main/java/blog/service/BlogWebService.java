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

	public BlogAccount findAccount(String username) {
		return accountdao.findOne(username);
	}

	public BlogAccount findAccount(String username, String password) {
		return accountdao.findOne(username, password);
	}

}
