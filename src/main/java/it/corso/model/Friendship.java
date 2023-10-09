package it.corso.model;

import java.time.LocalDateTime;
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
@Table(name = "friendships")
public class Friendship 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "timing")
	private LocalDateTime timing;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "applicant_id", referencedColumnName = "id")
	private User applicant;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "requested_id", referencedColumnName = "id")
	private User requested;

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

	public User getApplicant() {
		return applicant;
	}

	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}

	public User getRequested() {
		return requested;
	}

	public void setRequested(User requested) {
		this.requested = requested;
	}
	
	
	
	
	
}
