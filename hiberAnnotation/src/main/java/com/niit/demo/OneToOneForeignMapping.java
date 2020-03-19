package com.niit.demo;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OneToOneForeignMapping {
public static void main(String ... args){
	
	SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory
			(new StandardServiceRegistryBuilder().configure().build());
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	Book book=new Book(); 
	book.setTitle("Hibernate Made Easy");
	book.setDescription("Simplified Data Persistence withHibernate and JPA");
	book.setPublishedDate(new Date());
	Author author=new Author("Deepanshu Gupta","deepanshu102@gmail.com");
	book.setAuthor(author);
	author.setBook(book);
	Long bookId=(Long)session.save(book);

	session.getTransaction().commit();	
	 book = (Book) session.get(Book.class,bookId);
	System.out.println("Book's Title: " + book.getTitle());
	System.out.println("Book's Description: " + book.getDescription());

	Author author1 = book.getAuthor();
	System.out.println("Author's Name: " + author1.getName());
	System.out.println("Author's Email: " + author1.getEmail());

	Query query=session.createQuery("from Book");
	List<Book> bookList=query.list();
	for(Book book1:bookList){
		System.out.println("BookId"+book1.getId()+"Book's Title: " + book1.getTitle());
		System.out.println("Book's Description: " + book1.getDescription());

		Author author2 = book.getAuthor();
		System.out.println("Author's Name: " + author2.getName());
		System.out.println("Author's Email: " + author2.getEmail());


	}
	session.close();

}
}
