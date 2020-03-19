package com.niit.demo;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Customer customer=new Customer();
		customer.setName("Deepanshu Gupta");
		customer.setEmail("Deepanshu@gmail.com");
		Address address=new Address();
		address.setAddressLine1("2558/194");
		address.setCity("New Delhi");
		address.setCountry("India");
		address.setPincode(110035);
		address.setState("new Delhi");
		address.setCustomer(customer);
		customer.setAddress(address);
		session.persist(customer);//Update Object Properties if any before its commited
		
		session.getTransaction().commit();
		System.out.println("---------------------Display Data------------");
		TypedQuery<Customer> query=session.createQuery("from Customer",Customer.class);
		List<Customer> list=query.getResultList();
		Iterator<Customer> itr=list.iterator();
		while(itr.hasNext()){
			Customer cust=itr.next();
			System.out.print(cust.getName()+"\t"+cust.getEmail()+cust.getCustomerId()+"\n");
			address=cust.getAddress();
			System.out.println(address.getAddressLine1()+"\t"+address.getCity()+":-"+address.getPincode()+"\n"+address.getCountry());
		}
		session.close();
		
	}

}
