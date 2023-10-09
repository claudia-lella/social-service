package it.corso.dto;

import java.time.LocalDateTime;

public class UserFriendshipsReceivedDto {

	private int id;
	private LocalDateTime timing;
	private String status;
	private UserFriendshipsUserDto applicant;

	public UserFriendshipsUserDto getApplicant() {
		return applicant;
	}
	public void setApplicant(UserFriendshipsUserDto applicant) {
		this.applicant = applicant;
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
