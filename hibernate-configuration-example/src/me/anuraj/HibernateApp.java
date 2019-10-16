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
		configureUsingHibernatePropertiesFile(); // Properties file configuration
		//configureUsingHibernateConfigXMLFile(); // XML configuration 
	}
	public static void configureUsingHibernateConfigXMLFile(){
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

		Employee employee = new Employee();    
		employee.setId(101);    
		employee.setFirstName("Anuraj");    
		employee.setLastName("Sivankutty");    
		session.save(employee);  

		System.out.println("successfully saved");    

		// Commit transaction
		session.getTransaction().commit();

		factory.close();  
		session.close();   
		ssr.close();
	}

	public static void configureUsingHibernatePropertiesFile() throws IOException{

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().loadProperties("hibernate.properties").build();  
		Metadata meta = new MetadataSources(ssr).addFile("src/employee.hbm.xml").getMetadataBuilder().build(); 
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  


		// Get current session
		Session session = factory.getCurrentSession();
		
		// Begin transaction
		session.getTransaction().begin();
		Employee employee = new Employee();  

		employee.setId(102);    
		employee.setFirstName("Gaurav");    
		employee.setLastName("Chawla");    
		session.save(employee);  

		// Print out all required information
		System.out.println("Session Is Opened :: "+session.isOpen());
		System.out.println("Session Is Connected :: "+session.isConnected()); 

		// Commit transaction
		session.getTransaction().commit();
		
		session.close();
		factory.close();
		ssr.close();
	}    
}   
