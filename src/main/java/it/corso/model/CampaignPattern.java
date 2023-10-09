package it.corso.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "campaign_patterns")
public class CampaignPattern 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "basic_daily_budget")
	private double basicDailyBudget;
	
	@Column(name = "basic_daily_result")
	private String basicDailyResult;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBasicDailyBudget() {
		return basicDailyBudget;
	}

	public void setBasicDailyBudget(double basicDailyBudget) {
		this.basicDailyBudget = basicDailyBudget;
	}

	public String getBasicDailyResult() {
		return basicDailyResult;
	}

	public void setBasicDailyResult(String basicDailyResult) {
		this.basicDailyResult = basicDailyResult;
	}
}
