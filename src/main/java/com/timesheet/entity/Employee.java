package com.timesheet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String clientId;
     private String projectName;
     private String addEntry;
     private int timeSpend;
     private String tag;
     private String remarks;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getAddEntry() {
		return addEntry;
	}
	public void setAddEntry(String addEntry) {
		this.addEntry = addEntry;
	}
	public int getTimeSpend() {
		return timeSpend;
	}
	public void setTimeSpend(int timeSpend) {
		this.timeSpend = timeSpend;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", clientId=" + clientId + ", projectName=" + projectName + ", addEntry="
				+ addEntry + ", timeSpend=" + timeSpend + ", tag=" + tag + ", remarks=" + remarks + "]";
	}
	
     
     
	
	
}
