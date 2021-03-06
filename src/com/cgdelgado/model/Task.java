package com.cgdelgado.model;

public class Task {	
	
	private int id;	
	private String name;	
	private String description;
	private String start;	
	private String end;
	private int done;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getDone() {
		return done;
	}
	public void setDone(int done) {
		this.done = done;
	}
	
	
	@Override
	public String toString() {
		return "Task [id="+ id +", name=" + name + ", description=" + description + ", start=" + start + ", end=" + end + ", done="+ done +"]";
	}


}
