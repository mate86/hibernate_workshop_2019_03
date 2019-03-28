package hibernate.crud.operations;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student", schema = "public")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "roll_number")
    private int rollNumber;

    @Column(name = "course")
    private String course;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<Book>();

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Phone studentsPhone;

    public Student(String studentName, int rollNumber, String course) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.course = course;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Phone getStudentsPhone() {
        return studentsPhone;
    }

    public void setStudentsPhone(Phone phone) {
        this.studentsPhone = phone;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
