//package test.java.org.hibernate.bugs.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import org.hibernate.annotations.JoinColumnOrFormula;
//import org.hibernate.annotations.JoinFormula;
//import org.hibernate.bugs.entity.BookShelf;
//
//@Data
//@Entity(name = "Book")
//@Table(name = "book")
//public class Book {
//
//    @Id
//    @Column(name = "id", insertable = false, updatable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name = "name")
//    private String name;
//
//    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinFormula(value = "select bs.id from bookshelf bs where id = any(bs.book_ids)")
//    @JoinColumnOrFormula(formula = @JoinFormula(value = "1", referencedColumnName = "is_deleted"))
//    private BookShelf bookShelf;
//
//    @Column(name = "is_deleted")
//    private Integer isDeleted;
//}
