package it.corso.model;
import java.util.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="campaigns")
public class Campaign 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="daily_budget")
	private double dailyBudget;
	
	@Column(name="status")
	private String status;
	
	@Column(name="payment")
	private String payment;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "post_id", referencedColumnName = "id")
	private Post post;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "pattern_id", referencedColumnName = "id")
	private CampaignPattern pattern;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public double getDailyBudget() {
		return dailyBudget;
	}

	public void setDailyBudget(double dailyBudget) {
		this.dailyBudget = dailyBudget;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public CampaignPattern getPattern() {
		return pattern;
	}

	public void setPattern(CampaignPattern pattern) {
		this.pattern = pattern;
	}	
}
