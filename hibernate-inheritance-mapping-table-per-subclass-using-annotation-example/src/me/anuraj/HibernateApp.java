package me.anuraj;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class HibernateApp {   
	public static void main(String[] args) throws FileNotFoundException, IOException{
		saveEmployeeData();
	}
	public static void saveEmployeeData(){
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  

		// Get current session
		Session session = factory.getCurrentSession();
		// Begin transaction
		session.getTransaction().begin();

		// Print out all required information
		System.out.println("Session Is Opened :: "+session.isOpen());
		System.out.println("Session Is Connected :: "+session.isConnected()); 

		Employee employee1 = new Employee();      
		employee1.setFirstName("Anuraj");    
		employee1.setLastName("Sivankutty");    
		session.save(employee1); 
		System.out.println("employee 1 data populated,saved");

		ContractEmployee employee2 = new ContractEmployee();       
		employee2.setFirstName("Nipo");    
		employee2.setLastName("Dwan");
		employee2.setPayPerHour(15);
		session.save(employee2);
		System.out.println("employee 2 data populated ,saved");

		Employee employee3 = new RegularEmployee();
		employee3.setFirstName("Nipo");    
		employee3.setLastName("LastName3");    
		session.save(employee3);  
		System.out.println("employee 3 data populated ,saved");

		System.out.println("successfully saved");  
		
		TypedQuery<Employee> query = session.createQuery("select e from Employee e where e.firstName=:name",Employee.class);
		query.setParameter("name", "Nipo");
		List<Employee> employeeList = query.getResultList();
		if(employeeList != null && !employeeList.isEmpty()) {
			System.out.println("size:" + employeeList.size());
			employeeList.stream().forEach((element)->System.out.println("Employee :" + element));
		} else {
			System.out.println("NO result!!");
		}
		 

		// Commit transaction
		session.getTransaction().commit();
		
		factory.close();  
		session.close();   
		ssr.close();
	}
}   
