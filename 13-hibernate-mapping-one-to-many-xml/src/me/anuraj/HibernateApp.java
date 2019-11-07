package me.anuraj;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
		Set<Author> book1authors = new HashSet<>();
		Author author1 = new Author();
		author1.setFirstName("Anuraj");
		author1.setLastName("TS");
		Author author2 = new Author();
		author2.setFirstName("Author2");
		author2.setLastName("LastName2");
		
		book1authors.add(author1);
		book1authors.add(author2);
		
		Book book1 = new Book();
		book1.setName("Java Fundamentals");
		book1.setAuthors(book1authors);
		 
		Set<Author> book2authors2 = new HashSet<>();
		Author author3 = new Author();
		author3.setFirstName("Author3");
		author3.setLastName("LastName3");
		
		Author author4 = new Author();
		author4.setFirstName("Author4");
		author4.setLastName("LastName4");
		
		book2authors2.add(author3);
		book2authors2.add(author4);
		
		
		Book book2 = new Book();
		book2.setName("Javaca Complete Referance");
		book2.setAuthors(book2authors2);
		
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
