package com.kasturi.jpa.basic.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

		System.out.println("====================================================================");

		/**
		 * Older way with hibernate
		 * 
		 * Criteria criteria = session.createCriteria(MotorBike.class);
		 * 
		 * In jpa, We use criteriaBuilder with combination of entityManager
		 *
		 */

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		/**
		 * Create criteria query and pass the value object which needs to be populated
		 * as result
		 */

		CriteriaQuery<MotorBike> criteriaQuery = criteriaBuilder.createQuery(MotorBike.class);

		/**
		 * Inform criteria query which tables/entities you want to fetch
		 * 
		 */

		Root<MotorBike> from = criteriaQuery.from(MotorBike.class);

		System.out.println("Display all bikes..");

		CriteriaQuery<MotorBike> selectQuery = criteriaQuery.select(from);

		TypedQuery<MotorBike> typedQuery = entityManager.createQuery(selectQuery);

		List<MotorBike> bikes = typedQuery.getResultList();
		if (bikes != null && bikes.size() != 0) {
			for (MotorBike m : bikes) {
				System.out.println(m);
			}
		} else {
			System.out.println("No data in db");
		}
		
		
		System.out.println("====================================================================");
		
		
		CriteriaQuery<MotorBike> dscQuery = criteriaQuery.select(from);
		dscQuery.orderBy(criteriaBuilder.desc(from.get("bikeId")));
		TypedQuery<MotorBike> tQuery = entityManager.createQuery(dscQuery);
		List<MotorBike> descList = tQuery.getResultList();
		
		if (descList != null && descList.size() != 0) {
			for (MotorBike m : descList) {
				System.out.println(m);
			}
		} else {
			System.out.println("No data in db");
		}
		
		
		System.out.println("====================================================================");
		
		
	}
}
