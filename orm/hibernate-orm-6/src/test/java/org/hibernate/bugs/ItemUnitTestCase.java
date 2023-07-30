package org.hibernate.bugs;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.bugs.entity.TBook;
import org.hibernate.bugs.entity.TDVD;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.print.Book;
import java.io.Serializable;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class ItemUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh123Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		TBook book = new TBook();

		book.setManufacturer("新华社");
		book.setName("红楼梦");
		book.setPageCount("1089");

		TDVD tdvd = new TDVD();
		tdvd.setManufacturer("华语");
		tdvd.setName("突然的自我");
		tdvd.setRegionCode("111");

		entityManager.persist(book);
		entityManager.persist(tdvd);

		entityManager.getTransaction().commit();
		entityManager.close();
	}


	@Test
	public void hhh456Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
