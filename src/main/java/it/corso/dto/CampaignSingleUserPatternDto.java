package it.corso.dto;

public class CampaignSingleUserPatternDto {
	
	private int id;
	private String type;
	private double basicDailyBudget;
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
