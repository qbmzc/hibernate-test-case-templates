package org.hibernate.bugs;

import jakarta.persistence.*;

import lombok.Data;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinFormula;
//import org.hibernate.bugs.entity.BookShelf;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import test.java.org.hibernate.bugs.entity.Book;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

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
		// Do stuff...
//		Book book = new Book();
//		book.setName("水浒传");
//		book.setIsDeleted(0);
//		BookShelf bookShelf = new BookShelf();
//		bookShelf.setIsDeleted(0);
//		book.setBookShelf(bookShelf);
//		entityManager.persist(bookShelf);
//		entityManager.persist(book);

//		Country US = new Country();
//		US.setId(1);
//		US.set_default(true);
//		US.setPrimaryLanguage("English");
//		US.setName("United States");
//
//		Country Romania = new Country();
//		Romania.setId(40);
//		Romania.set_default(true);
//		Romania.setName("Romania");
//		Romania.setPrimaryLanguage("Romanian");
//
//		entityManager.persist(US);
//		entityManager.persist(Romania);
//
//		User user1 = new User();
//		user1.setId(1L);
//		user1.setFirstName("John");
//		user1.setLastName("Doe");
//		user1.setLanguage("English");
//		entityManager.persist(user1);
//
//		User user2 = new User();
//		user2.setId(2L);
//		user2.setFirstName("Vlad");
//		user2.setLastName("Mihalcea");
//		user2.setLanguage("Romanian");
//		entityManager.persist(user2);
//
//		entityManager.flush();
//		entityManager.getTransaction().commit();
//		entityManager.getTransaction().begin();
		System.out.println("Fetch User entities");

		User john = entityManager.find(User.class, 1L);
		System.out.println(john);

		User vlad = entityManager.find(User.class, 2L);
		System.out.println(vlad);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Data
	@Entity(name = "User")
	@Table(name = "users")
	public static class User {

		@Id
		private Long id;

		private String firstName;

		private String lastName;

		private String language;

		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumnOrFormula(column =
		@JoinColumn(
				name = "language",
				referencedColumnName = "primaryLanguage",
				insertable = false,
				updatable = false
		)
		)
		@JoinColumnOrFormula(formula =
		@JoinFormula(
				value = "true",
				referencedColumnName = "is_default"
		)
		)
		private Country country;

		//Getters and setters omitted for brevity

	}

	@Data
	@Entity(name = "Country")
	@Table(name = "countries")
	public static class Country implements Serializable {

		@Id
		private Integer id;

		private String name;

		private String primaryLanguage;

		@Column(name = "is_default")
		private boolean _default;

		//Getters and setters, equals and hashCode methods omitted for brevity

	}
}
