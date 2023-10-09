package it.corso.dto;
import java.sql.Date;

public class CampaignSingleUserDto {

	private int id;
	private Date start;
	private Date end;
	private double dailyBudget;
	private String status;
	private String payment;
	private CampaignSingleUserUserDto user;
	private CampaignSinglePostDto post;
	private CampaignSingleUserPatternDto pattern;
	
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
	public CampaignSingleUserUserDto getUser() {
		return user;
	}
	public void setUser(CampaignSingleUserUserDto user) {
		this.user = user;
	}
	public CampaignSinglePostDto getPost() {
		return post;
	}
	public void setPost(CampaignSinglePostDto post) {
		this.post = post;
	}
	public CampaignSingleUserPatternDto getPattern() {
		return pattern;
	}
	public void setPattern(CampaignSingleUserPatternDto pattern) {
		this.pattern = pattern;
	}

}
