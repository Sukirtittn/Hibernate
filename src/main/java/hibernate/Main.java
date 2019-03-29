package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;
//Question2. Perform CRUD operation for Author class.

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list =new ArrayList<>();
        list.add("Maths");
        list.add("physics");
        list.add("science");


        Author author = new Author();
        author.setId(1);
        author.setFirstname("Sukirti");
        author.setLastname("k");
        author.setAge(23);
//        question 3
        author.setDob(new Date("24/04/1996"));
        Author author1 = new Author();
        author.setId(2);
        author.setFirstname("Kamal");
        author.setLastname("P");
        author.setAge(23);
        author.setDob(new Date("24/05/1996"));
        Author author2 = new Author();
        author.setId(3);
        author.setFirstname("Shivi");
        author.setLastname("k");
        author.setAge(23);
        author.setDob(new Date("24/06/1996"));
        Author author3 = new Author();
        author.setId(4);
        author.setFirstname("Mudit");
        author.setLastname("k");
        author.setAge(23);
        author.setDob(new Date("24/07/1996"));
        Author author4 = new Author();
        author.setId(5);
        author.setFirstname("Joyi");
        author.setLastname("k");
        author.setAge(23);
        author.setDob(new Date("24/08/1996"));

//        question-11
        Address address1=new Address();
        address1.setStreetNumber(11);
        address1.setLocation("Noida");
        address1.setState("U.P.");
        author.setAddress(address1);
        author1.setAddress(address1);

//---------------------------------------------------------------------------------------------------
//Question 13

        author.setList(list);
        author1.setList(list);
        author2.setList(list);
        author3.setList(list);

//---------------------------------------------------------------------------------------------------
// Question 15
        Book book=new Book();
        book.setBookName("Elements");
        Book book1=new Book();
        book1.setBookName("Elements1");
        Book book2=new Book();
        book2.setBookName("Elements2");

//        one to one mapping!
//        author.setBook(book);
//        author1.setBook(book1);
//        author2.setBook(book2);

//        one to many mapping unidirectional!
//        Collection<Book> bookCollection =new HashSet<>();
//        bookCollection.add(book);
//        bookCollection.add(book2);
//        Collection<Book> bookCollection1 =new HashSet<>();
//        bookCollection1.add(book1);
//        author.setBook(bookCollection);
//        author1.setBook(bookCollection1);



// one to many bidirectional
//        book.setAuthor(author);
//        book2.setAuthor(author);
//        book1.setAuthor(author1);
//        author.getBook().add(book);
//        author.getBook().add(book2);
//        author1.getBook().add(book1);
//        the next will not work it will work in many to many
//        author1.getBook().add(book2);
//

//one to many without additional table!

////
//        Collection<Book> bookCollection =new HashSet<>();
//        bookCollection.add(book);
//        bookCollection.add(book2);
//        Collection<Book> bookCollection1 =new HashSet<>();
//        bookCollection1.add(book1);
//        author.setBook(bookCollection);
//        author1.setBook(bookCollection1);

//many to many
        List<Book> bookList=new ArrayList<Book>();
        bookList.add(book);
        bookList.add(book1);
        bookList.add(book2);

        author.setBook(bookList);
        author1.setBook(bookList);
        author2.setBook(bookList);


//---------------------------------------------------------------------------------------------------
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//      create operation & read

        session.save(author);
        session.save(book);
//        question 4
        session.save(author1);
        session.save(book1);
        session.save(author2);
        session.save(book2);
        session.save(author3);
        session.save(author4);
        Author author5 = session.get(Author.class, 1);
//      update operation
        author5.setLastname("kaushik");
        session.update(author1);
//      delete operation
     //   session.delete(author5);

//        question 16
//        now we don't have to save book object separately!!
//        session.persist(author);
//        session.persist(author1);
//        session.persist(author2);
//        session.persist(author3);

        session.getTransaction().commit();
      //  Author author6 = session.get(Author.class, 1);
        session.close();


      //  System.out.println(author6);
    }
}
