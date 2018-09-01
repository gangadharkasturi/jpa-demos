package com.kasturi.jpa.basic.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.kasturi.jpa.entity.MotorBike;

/**
 * 
 * @author Gangadhar , Kasturi
 *
 */
public class MyApplication {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Starting the transaction..");
		entityManager.getTransaction().begin();

		
		MotorBike bike = new MotorBike();
		/*
		bike.setChassisNo("T44R4RFE33");
		bike.setEngineNo("0S3MPPN9JD");
		bike.setManufacturer("HONDA");
		bike.setModel("CBR 250");
		entityManager.persist(bike);
		entityManager.getTransaction().commit();
		*/
		
		System.out.println("====================================================================");
		
		/*
		 * SELECT * FROM MOTORBIKE WHERE BIKE_ID=2
		 */
		bike = entityManager.find(MotorBike.class, 2);
		System.out.println("BY USING FIND METHOD:" + bike);

		Query myNativeQuery = entityManager.createNativeQuery("SELECT * FROM MotorBike");
		List<Object[]> motorbikes = myNativeQuery.getResultList();

		for (Object[] motorBike : motorbikes) {
			System.out.println(
					"BIKE_ID:" + motorBike[0] + "\n" + "CHASSIS_NO:" + motorBike[1] + "\nENGINE_NO" + motorBike[2]);
		}

		System.out.println("====================================================================");
		//native query is actual SQL query, i,e DB DEPENDENT QUERY
		Query myNativeQuery2 = entityManager.createNativeQuery("SELECT m.bikeId,m.chassisNo FROM MotorBike m");
		List<Object[]> motorbikes2 = myNativeQuery2.getResultList();

		for (Object[] motorBike : motorbikes2) {
			System.out.println(
					"BIKE_ID:" + motorBike[0] + "\n" + "CHASSIS_NO:" + motorBike[1]);
		}
		
		System.out.println("====================================================================");
		
		Query myNamedQuery = entityManager.createNamedQuery("MOTOR_BIKE_BY_CHASSIS_NO");
		myNamedQuery.setParameter("cn", "T44R4RFE33");
		List<Object[]> motorBikesByChassis = myNamedQuery.getResultList();
		for(Object[] obj : motorBikesByChassis)
		{
			System.out.println("BIKE ID:" +obj[0] + "\t"+ "MODEL:" +obj[1]+"\n");
		}
		
		System.out.println("====================================================================");
		
		Query myNamedNativeQuery = entityManager.createNamedQuery("MOTOR_BIKE_BY_MODEL");
		myNamedNativeQuery.setParameter(1, "CBR 250");
				List<MotorBike> bikes = myNamedNativeQuery.getResultList(); //here the return type is MotorBike because we already declared result class at the time of declaration of MOTOR_BIKE_BY_MODEL QUERY
		for(MotorBike moto : bikes )
		{
			System.out.println(moto+"\n");
		}
		
		System.out.println("====================================================================");
	
		
	
	
	
	
	
	}
	
	
	
	
}
