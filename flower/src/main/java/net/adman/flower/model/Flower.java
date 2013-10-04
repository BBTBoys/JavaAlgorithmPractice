package net.adman.flower.model;


public class Flower {

	private Integer id;
	private Integer durationId;
	private String fallingDay;
	private String bloomingDay;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getDurationId() {
		return durationId;
	}


	public void setDurationId(Integer durationId) {
		this.durationId = durationId;
	}


	public String getBloomingDay() {
		return bloomingDay;
	}

	public void setBloomingDay(String bloomingDay) {
		this.bloomingDay = bloomingDay;
	}

	public String getFallingDay() {
		return fallingDay;
	}

	public void setFallingDay(String fallingDay) {
		this.fallingDay = fallingDay;
	}
}
