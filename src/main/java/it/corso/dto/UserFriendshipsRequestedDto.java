package it.corso.dto;

import java.time.LocalDateTime;

public class UserFriendshipsRequestedDto {

	private int id;
	private LocalDateTime timing;
	private String status;
	private UserFriendshipsUserDto requested;
	
	public UserFriendshipsUserDto getRequested() {
		return requested;
	}
	public void setRequested(UserFriendshipsUserDto requested) {
		this.requested = requested;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
