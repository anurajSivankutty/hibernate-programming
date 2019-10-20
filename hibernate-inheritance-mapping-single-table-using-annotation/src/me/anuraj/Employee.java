package me.anuraj;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employee")
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)  
@DiscriminatorValue(value="emp")  
public class Employee {  
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator (
			 parameters = {
		                @org.hibernate.annotations.Parameter(
		                    name = "separator", 
		                    value = "-")}, name = "UUID", strategy = "uuid")
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