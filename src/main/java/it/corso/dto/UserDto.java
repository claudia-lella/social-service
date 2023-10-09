package it.corso.dto;

import java.util.List;

public class UserDto {

	private int id;
	private String name;
	private String lastname;
	private String mail;
	private String nickname;
	private String password;
	private String profileImage;
	private String profileType;
	List<UserFriendshipsReceivedDto> receivedFriendships;
	List<UserFriendshipsRequestedDto> requestedFriendships;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public String getProfileType() {
		return profileType;
	}
	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}
	public List<UserFriendshipsReceivedDto> getReceivedFriendships() {
		return receivedFriendships;
	}
	public void setReceivedFriendships(List<UserFriendshipsReceivedDto> receivedFriendships) {
		this.receivedFriendships = receivedFriendships;
	}
	public List<UserFriendshipsRequestedDto> getRequestedFriendships() {
		return requestedFriendships;
	}
	public void setRequestedFriendships(List<UserFriendshipsRequestedDto> requestedFriendships) {
		this.requestedFriendships = requestedFriendships;
	}

	
	
	
	
	
	
}
