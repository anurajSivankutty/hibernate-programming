package me.anuraj;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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
		employee1.setId(101);    
		employee1.setFirstName("Anuraj");    
		employee1.setLastName("Sivankutty");    
		//session.save(employee1); 
		System.out.println("employee 1 data populated, Not saved");
		
		Employee employee2 = new Employee();       
		employee2.setFirstName("Nipo");    
		employee2.setLastName("Dwan");    
		session.save(employee2);
		System.out.println("employee 2 data populated ,saved");
		
		Employee employee3 = new Employee();
		employee3.setId(3);
		employee3.setFirstName("Name3");    
		employee3.setLastName("LastName3");    
		session.save(employee3);  
		System.out.println("employee 3 data populated ,saved");
		

		System.out.println("successfully saved");    

		// Commit transaction
		session.getTransaction().commit();

		factory.close();  
		session.close();   
		ssr.close();
	}
}   
