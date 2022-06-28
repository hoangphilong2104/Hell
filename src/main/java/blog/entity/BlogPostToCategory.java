package blog.entity;

/**
 * Entity : Value Object, data 들을 저장하는 class - 1 table in database
 * 
 * @author bitcamp
 *
 */
//게시글 카테고리 
public class BlogPostToCategory {

	// 카테고리 아이디
	private Integer categoryId;// category_id in DB

	// 게시글 아이디
	private Integer postId;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	// BlogPostToCategory 모델 복사
	public void CopyData(BlogPostToCategory param) {
		this.categoryId = param.getCategoryId();
		this.postId = param.getPostId();
	}

}