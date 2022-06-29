package blog.entity;

//테그 
public class BlogTag {

	// 테그 아이디
	private Integer id;

	// 게시글 아이디
	private Integer postId;

	// 테그 내용
	private String tag;

	// 수정된 태그 내용
	private String tagClean;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTagClean() {
		return tagClean;
	}

	public void setTagClean(String tagClean) {
		this.tagClean = tagClean;
	}

	// BlogTag 모델 복사
	public void CopyData(BlogTag param) {
		this.id = param.getId();
		this.postId = param.getPostId();
		this.tag = param.getTag();
		this.tagClean = param.getTagClean();
	}
}
