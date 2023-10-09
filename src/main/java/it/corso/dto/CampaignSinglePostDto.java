package it.corso.dto;

import java.time.LocalDateTime;

public class CampaignSinglePostDto {

	private int id;
	private LocalDateTime timing;
	private String content;
	
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
}
