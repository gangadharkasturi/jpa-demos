package com.kasturi.jpa.basic.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kasturi.jpa.entity.MotorBike;


/**
 * 
 * @author Gangadhar , Kasturi
 *
 */
public class MyApplication {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Starting the transaction..");
		entityManager.getTransaction().begin();
		
		MotorBike bike = new MotorBike();
		bike.setChassisNo("12AA14DFG5G");
		bike.setEngineNo("5SDDF5D87D");
		bike.setManufacturer("HONDA");
		bike.setModel("CBR 20");
		
		entityManager.persist(bike);
		entityManager.getTransaction().commit();
		
		System.out.println("Bike with Chassis No: "+bike.getChassisNo()+" has been saved to database..!");
	}
}
