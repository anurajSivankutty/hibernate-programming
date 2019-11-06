package me.anuraj;

import java.util.List;

public class Book {
	private int id;
	private String name;
	private List<String> authors;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "["+this.getClass().getName()+"] Name:" + this.getName();
	}
}
