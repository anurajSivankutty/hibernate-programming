package me.anuraj;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
		saveBookData();
	}
	public static void saveBookData(){
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
		
		List<String> authors = new ArrayList<String>();
		authors.add("Author1");
		authors.add("Author2");
		authors.add("Author3");
		
		Book book1 = new Book();
		book1.setName("Java Fundamentals");
		book1.setAuthors(authors);
		 
		List<String> authors2 = new ArrayList<String>();
		authors2.add("Author 4");
		authors2.add("Author 5");
		
		Book book2 = new Book();
		book2.setName("Javaca Complete Referance");
		book2.setAuthors(authors2);
		
		session.save(book1);
		session.save(book2);
		
		TypedQuery<Book> query = session.createQuery("select b from Book b where b.name=:name",Book.class);
		query.setParameter("name", "Java Fundamentals");
		
		List<Book> employeeList = query.getResultList();
		if(employeeList != null && !employeeList.isEmpty()) {
			System.out.println("size:" + employeeList.size());
			employeeList.stream().forEach((element)->System.out.println("Book :" + element));
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
