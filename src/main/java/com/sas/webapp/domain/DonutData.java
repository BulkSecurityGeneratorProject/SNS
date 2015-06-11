package com.sas.webapp.domain;

public class DonutData {

	private Long value;
    private String color;
    private String label;
	public DonutData(String label, Long value, String color) {
		this.value = value;
		this.color = color;
		this.label = label;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
    
}

