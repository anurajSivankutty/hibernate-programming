package me.anuraj;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "regular_employee")
@AttributeOverrides({  
	   @AttributeOverride(name="firstName", column=@Column(name ="firstName")),
	   @AttributeOverride(name="lastName", column=@Column(name="lastName"))  
	   }) 
public class RegularEmployee extends Employee{  
	private float salary;
	private float bonus;
	
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	
}  