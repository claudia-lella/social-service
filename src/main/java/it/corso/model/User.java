package it.corso.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "entry_date")
	private LocalDate entryDate;
	
	@Pattern(regexp = "[a-zA-Z\\sàèìòù']{1,100}", message = "Error on name field")
	@Column(name = "name")
	private String name;
	
	@Pattern(regexp = "[a-zA-Z\\sàèìòù']{1,100}", message = "Error on lastname field")
	@Column(name = "lastname")
	private String lastname;

	@Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Error on email field")
	@Column(name = "mail")
	private String mail;
	
	@Pattern(regexp = "[a-zA-Z0-9.]{1,20}", message = "Error on nickname field")
	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "profile_image")
	private String profileImage;
	
	@Column(name = "profile_type")
	private String profileType;
	
	@Column(name = "auth_token")
	private String authToken;
	
	@OneToMany
	(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
	)
	private List<Post> posts = new ArrayList<>();

	@OneToMany
	(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
	)
	private List<Comment> comments = new ArrayList<>();

	@OneToMany
	(
			mappedBy = "requested",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
	)
	private List<Friendship> receivedFriendships = new ArrayList<>();
	
	@OneToMany
	(
			mappedBy = "applicant",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
	)
	private List<Friendship> requestedFriendships = new ArrayList<>();
	
	@OneToMany
	(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
	)
	private List<Campaign> campaigns = new ArrayList<>();
	
	@OneToMany
	(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			orphanRemoval = true
	)
	private List<Like> likes = new ArrayList<>();
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
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

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Friendship> getReceivedFriendships() {
		return receivedFriendships;
	}

	public void setReceivedFriendships(List<Friendship> receivedFriendships) {
		this.receivedFriendships = receivedFriendships;
	}

	public List<Friendship> getRequestedFriendships() {
		return requestedFriendships;
	}

	public void setRequestedFriendships(List<Friendship> requestedFriendships) {
		this.requestedFriendships = requestedFriendships;
	}

	public List<Campaign> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}
	
	
	
}
