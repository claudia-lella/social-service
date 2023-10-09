package it.corso.dto;

import java.time.LocalDateTime;

public class CampaignPostDto {
	
	private int id;
	private LocalDateTime timing;
	private String content;
	private String image;
	private PostUserDto user;
	
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
	public PostUserDto getUser() {
		return user;
	}
	public void setUser(PostUserDto user) {
		this.user = user;
	}

	
}
