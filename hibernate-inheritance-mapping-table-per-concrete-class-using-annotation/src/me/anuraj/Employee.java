package me.anuraj;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee {  
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid",parameters = {
			@Parameter(name="separator",value ="-" )
	})
	@Column(name = "vana_column")
	private String id;  

	private String firstName;
	private String lastName;  

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