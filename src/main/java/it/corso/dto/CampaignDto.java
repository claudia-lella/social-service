package it.corso.dto;

import java.sql.Date;
import java.util.List;

import it.corso.model.CampaignPattern;

public class CampaignDto {

	private int id;
	private Date start;
	private Date end;
	private double dailyBudget;
	private String status;
	private String payment;
	List<CampaignPostDto> posts;
	List<CampaignUserDto> users;
	List<CampaignPattern> patterns;
	
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
	public List<CampaignPostDto> getPosts() {
		return posts;
	}
	public void setPosts(List<CampaignPostDto> posts) {
		this.posts = posts;
	}
	public List<CampaignUserDto> getUsers() {
		return users;
	}
	public void setUsers(List<CampaignUserDto> users) {
		this.users = users;
	}
	public List<CampaignPattern> getPatterns() {
		return patterns;
	}
	public void setPatterns(List<CampaignPattern> patterns) {
		this.patterns = patterns;
	}
	
	
}
