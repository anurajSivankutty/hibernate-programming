package me.anuraj;

import java.util.Set;

public class Book {
	private int id;
	private String name;
	private Set<String> authors;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<String> authors2) {
		this.authors = authors2;
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
