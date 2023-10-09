package it.corso.dto;

public class PostLikeDto {

	private int id;
	private PostLikeUserDto user;

	public PostLikeUserDto getUser() {
		return user;
	}

	public void setUser(PostLikeUserDto user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
