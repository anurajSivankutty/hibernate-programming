package me.anuraj;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contract_employee")
@AttributeOverrides({  
   @AttributeOverride(name="firstName", column=@Column(name ="firstName")),
   @AttributeOverride(name="lastName", column=@Column(name="lastName"))  
})  
public class ContractEmployee extends Employee{
	private float payPerHour;
	private int contractDuration;
	public float getPayPerHour() {
		return payPerHour;
	}
	public void setPayPerHour(float payPerHour) {
		this.payPerHour = payPerHour;
	}
	public int getContractDuration() {
		return contractDuration;
	}
	public void setContractDuration(int contractDuration) {
		this.contractDuration = contractDuration;
	}
	
}
