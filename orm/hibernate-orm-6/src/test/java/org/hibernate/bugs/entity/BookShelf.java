//package org.hibernate.bugs.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "book_shelf")
//public class BookShelf {
//
//    @Id
//    @Column(name = "id", insertable = false, updatable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @OneToMany(mappedBy = "bookShelf")
//    private List<test.java.org.hibernate.bugs.entity.Book> books = new ArrayList<>();
//
//    @Column(name = "is_deleted")
//    private Integer isDeleted;
//
//}
