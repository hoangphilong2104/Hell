package blog.entity;

//회원 상세
public class BlogUserDetail {

	// 회원 아이디
	private Integer userId;

	// 전화번호
	private String phonenumber;

	// 웹사이트
	private String website;

	// 회원 사진
	private String userPicture;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	// BlogUserDetail 모델 복사
	public void CopyData(BlogUserDetail param) {
		this.userId = param.getUserId();
		this.phonenumber = param.getPhonenumber();
		this.website = param.getWebsite();
		this.userPicture = param.getUserPicture();
	}
}