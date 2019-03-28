package hibernate.crud.operations;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOperations {

    static Session session;

    private static Logger log = Logger.getLogger(DatabaseOperations.class);

    // This Method Is Used To Create The Hibernate's SessionFactory Object
    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        return new Configuration().configure().buildSessionFactory();
    }

    // Method 1: This Method Used To Create A New Student Record In The Database Table
    public static void createStudents() {
        int count = 0;
        Student student = null;
        try {
            // Getting Session Object From SessionFactory
            session = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            session.beginTransaction();

            // Creating Transaction Entities
            for (int j = 101; j <= 105; j++) {
                count = count + 1;
                student = new Student("Editor " + j, j, "Bachelor Of Technology");

                Phone phone = new Phone("+36701234" + j);
                phone.setStudent(student);
                student.setStudentsPhone(phone);

                Book book1 = new Book("Book of " + student.getStudentName());
                Book book2 = new Book("Book of " + student.getStudentName());
                book1.setStudent(student);
                book2.setStudent(student);
                student.getBooks().add(book1);
                student.getBooks().add(book2);

                session.save(student);
            }

            // Committing The Transactions To The Database
            session.getTransaction().commit();
            log.info("\nSuccessfully Created '" + count + "' Records In The Database!\n");
        } catch (Exception e) {
            if (null != session.getTransaction()) {
                log.warn("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // Method 2: This Method Is Used To Display The Records From The Database Table
    public static List<Student> displayStudents() {
        List<Student> students = new ArrayList();
        try {
            // Getting Session Object From SessionFactory
            session = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            session.beginTransaction();

            students = session.createQuery("FROM Student").list();
        } catch (Exception e) {
            if (null != session.getTransaction()) {
                log.warn("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return students;
    }

    // Method 3: This Method Is Used To Update A Record In The Database Table
    public static void updateStudent(int student_id) {
        try {
            // Getting Session Object From SessionFactory
            session = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            session.beginTransaction();

            // Creating Transaction Entity
            Student student = session.get(Student.class, student_id);
            student.setStudentName("Java Code Geek");
            student.setCourse("Masters Of Technology");

            // Committing The Transactions To The Database
            session.getTransaction().commit();
            log.info("\nStudent With Id?= " + student_id + " Is Successfully Updated In The Database!\n");
        } catch (Exception e) {
            if (null != session.getTransaction()) {
                log.warn("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // Method 4(a): This Method Is Used To Delete A Particular Record From The Database Table
    public static void deleteStudent(Integer student_id) {
        try {
            // Getting Session Object From SessionFactory
            session = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            session.beginTransaction();

            Student student = findRecordById(student_id);
            session.delete(student);

            // Committing The Transactions To The Database
            session.getTransaction().commit();
            log.info("\nStudent With Id?= " + student_id + " Is Successfully Deleted From The Database!\n");
        } catch (Exception e) {
            if (null != session.getTransaction()) {
                log.warn("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // Method 4(b): This Method To Find Particular Record In The Database Table
    public static Student findRecordById(Integer find_student_id) {
        Student findStudentObj = null;
        try {
            // Getting Session Object From SessionFactory
            session = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            session.beginTransaction();

            findStudentObj = (Student) session.load(Student.class, find_student_id);
        } catch (Exception e) {
            if (null != session.getTransaction()) {
                log.warn("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
        }
        return findStudentObj;
    }

    // Method 5: This Method Is Used To Delete All Records From The Database Table
    public static void deleteAllStudents() {
        try {
            // Getting Session Object From SessionFactory
            session = buildSessionFactory().openSession();
            // Getting Transaction Object From Session Object
            session.beginTransaction();

            Query deleteFromPhone = session.createQuery("DELETE FROM Phone ");
            deleteFromPhone.executeUpdate();
            Query deleteFromBook = session.createQuery("DELETE FROM Book ");
            deleteFromBook.executeUpdate();
            Query deleteFromStudent = session.createQuery("DELETE FROM Student");
            deleteFromStudent.executeUpdate();

            // Committing The Transactions To The Database
            session.getTransaction().commit();
            log.info("\nSuccessfully Deleted All Records From The Database Table!\n");
        } catch (Exception e) {
            if (null != session.getTransaction()) {
                log.warn("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
