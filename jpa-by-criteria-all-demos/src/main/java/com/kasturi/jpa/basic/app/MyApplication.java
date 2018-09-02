package com.kasturi.jpa.basic.app;

import java.util.ArrayList;
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Starting the transaction..");
		entityManager.getTransaction().begin();

		System.out.println("====================================================================");

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<MotorBike> criteriaQuery = criteriaBuilder.createQuery(MotorBike.class); // result type

		Root<MotorBike> from = criteriaQuery.from(MotorBike.class); // from table

		CriteriaQuery<MotorBike> selectQuery = criteriaQuery.select(from);

		TypedQuery<MotorBike> selectQueryToExecute = entityManager.createQuery(selectQuery);

		List<MotorBike> bikes = selectQueryToExecute.getResultList();

		for (MotorBike mb : bikes) {
			System.out.println(mb);
		}

		System.out.println("====================================================================");

		/**
		 * You can directly assign without using TypedQuery
		 */
		List<MotorBike> bikess = entityManager.createQuery(selectQuery).getResultList();

		for (MotorBike mb : bikess) {
			System.out.println(mb);
		}

		System.out.println("====================================================================");

		/***
		 * Order by two columns
		 */
		List orderByList = new ArrayList();
		orderByList.add(criteriaBuilder.desc(from.get("bikeId")));
		orderByList.add(criteriaBuilder.desc(from.get("chassisNo")));

		CriteriaQuery<MotorBike> descQuery = criteriaQuery.orderBy(orderByList);

		List<MotorBike> descList = entityManager.createQuery(descQuery).getResultList();
		for (MotorBike m : descList) {
			System.out.println(m);
		}

		System.out.println("====================================================================");
		/**
		 * Criteria with bikeId equals to 1 , chassisNo not equals to 1DDF8RT54 and
		 * ordered by model ascending
		 */

		CriteriaQuery<MotorBike> selectWithWhereCondition = criteriaQuery.select(from);
		selectWithWhereCondition.where(criteriaBuilder.equal(from.get("bikeId"), 1),
				criteriaBuilder.notEqual(from.get("chassisNo"), "1DDF8RT54"));

		selectWithWhereCondition.orderBy(criteriaBuilder.asc(from.get("model")));

		List<MotorBike> dList = entityManager.createQuery(selectWithWhereCondition).getResultList();
		for (MotorBike m : dList) {
			System.out.println(m);
		}

		System.out.println("====================================================================");

		CriteriaQuery<MotorBike> withWhere = criteriaQuery.select(from)
				.where(criteriaBuilder.equal(from.get("bikeId"), 2));

		List<MotorBike> wList = entityManager.createQuery(withWhere).getResultList();
		for (MotorBike m : wList) {
			System.out.println(m);
		}
		System.out.println("====================================================================");
		
	}
}
