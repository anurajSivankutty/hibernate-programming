package me.anuraj;

public class Employee {  
	private String id;  
	private String firstName,lastName;  

	public String getId() {  
		return id;  
	}  
	public void setId(String string) {  
		this.id = string;  
	}  
	public String getFirstName() {  
		return firstName;  
	}  
	public void setFirstName(String firstName) {  
		this.firstName = firstName;  
	}  
	public String getLastName() {  
		return lastName;  
	}  
	public void setLastName(String lastName) {  
		this.lastName = lastName;  
	}  

	@Override
	public String toString() {
		return "["+this.getClass().getName()+"] Name:" + this.getFirstName() + " " + this.getLastName();
	}
}  