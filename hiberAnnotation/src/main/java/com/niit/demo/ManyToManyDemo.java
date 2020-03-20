package com.niit.demo;

import static java.lang.System.out;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ManyToManyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory
					(new StandardServiceRegistryBuilder().configure().build());
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Item item1=new Item();
		item1.setDescription("Samsung");
		item1.setPrice(300);
		Item item2=new Item();
		item2.setDescription("Nokia");
		item2.setPrice(200);
		
		Cart cart1=new Cart();
		cart1.setTotal(500);
		HashSet<Item> itemSet1=new HashSet<Item>();
		itemSet1.add(item1);
		itemSet1.add(item2);
		cart1.setItems(itemSet1);
		session.persist(cart1);
		
		session.getTransaction().commit();
		System.out.println("Sucessfully Run");
		session.close();
		session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart");
		List<Cart> cart_list=query.list();
		for(Cart cart:cart_list){
			
			Set<Item>itemSet=cart.getItems();
			System.out.println("*********Cart Items**************");
			System.out.println("Cart ID="+cart1.getId());
		
			for(Item item:itemSet){
			out.println("Item1 ID="+item.getId());
			out.println("Product="+item.getDescription());
			out.println("Price="+item.getPrice());

			}
			
		}
	
		}catch(Exception e){System.out.println(e.getMessage());}
	}

}
