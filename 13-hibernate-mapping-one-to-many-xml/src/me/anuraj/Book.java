package me.anuraj;

import java.util.Set;

public class Book {
	private int id;
	private String name;
	private Set<Author> authors;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<Author> authors) {
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
