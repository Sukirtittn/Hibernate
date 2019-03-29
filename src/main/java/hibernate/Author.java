package hibernate;

import javax.persistence.*;
import java.util.*;

// Question1. Create a class Author with instance variables firstName, lastName and age.
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @Column(name = "First_Name")
    private String firstname;
    @Column(name = "Last_Name")
    @Transient
    String lastname;
    @Column(name = "Age")
    private Integer age;
    @Column(name = "Date_of_Birth")
    @Temporal(TemporalType.DATE)
    private Date dob;

    //Question- 11
    @Embedded
    Address address;
    // Question-12
    @ElementCollection
    List<String> list = new ArrayList<>();

    //    Question-15
//    @OneToOne
//    @JoinColumn(name = "bookName")
//    Book book;


//    public Author(String firstname, String lastname, Integer age, Date dob, Address address, List<String> list, Book book) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.age = age;
//        this.dob = dob;
//        this.address = address;
//        this.list = list;
//        this.book = book;
//    }


//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }

//    question 16 one to many
//    unidirectional and bidirectional
//
//    @OneToMany
//    @JoinTable(joinColumns = @JoinColumn(name="id"),
//            inverseJoinColumns = @JoinColumn(name = "bookName"))
//    Collection<Book> book=new HashSet<>();
//
//    public Collection<Book> getBook() {
//        return book;
//    }
//
//    public void setBook(Collection<Book> book) {
//        this.book = book;
//    }

//    without extra table

//    @OneToMany(mappedBy = "author",cascade = CascadeType.PERSIST)
//    Collection<Book> book=new HashSet<>();


//    many to many mapping
    @ManyToMany
    List<Book> book =new ArrayList<>();

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    //    same for all the 3 type of mapping!
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", address=" + address +
                ", list=" + list +
                ", book=" + book +
                '}';
    }
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Author() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

}
