package it.corso.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PostDto {

	private int id;
	private LocalDateTime timing;
	private String content;
	private String image;
	private PostUserDto user;
	List<PostCommentDto> comments;
	List<PostLikeDto> likes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getTiming() {
		return timing;
	}
	public void setTiming(LocalDateTime timing) {
		this.timing = timing;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public List<PostCommentDto> getComments() {
		return comments;
	}
	public void setComments(List<PostCommentDto> comments) {
		this.comments = comments;
	}
	public List<PostLikeDto> getLikes() {
		return likes;
	}
	public void setLikes(List<PostLikeDto> likes) {
		this.likes = likes;
	}
	public PostUserDto getUser() {
		return user;
	}
	public void setUser(PostUserDto user) {
		this.user = user;
	}
	
	
}
