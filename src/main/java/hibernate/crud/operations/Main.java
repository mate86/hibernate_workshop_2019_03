package hibernate.crud.operations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {

    private static Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        log.info(".......Hibernate Crud Operations Example.......\n");

        log.info("\n=======CREATE RECORDS=======\n");
        DatabaseOperations.createStudents();

//        log.info("\n=======READ RECORDS=======\n");
//        List<Student> viewStudents = DatabaseOperations.displayStudents();
//        if (viewStudents != null && !viewStudents.isEmpty()) {
//            for (Student student : viewStudents) {
//                log.info("Student's name: " + student.getStudentName());
//            }
//        }
//
//        log.info("\n=======UPDATE RECORDS=======\n");
//        int updateId = 1;
//        DatabaseOperations.updateStudent(updateId);
//        log.info("\n=======READ RECORDS AFTER UPDATION=======\n");
//        List<Student> updateStudent = DatabaseOperations.displayStudents();
//        if (updateStudent != null && !updateStudent.isEmpty()) {
//            for (Student student : updateStudent) {
//                log.info(student.getStudentName());
//            }
//        }
//
//        log.info("\n=======DELETE RECORD=======\n");
//        int deleteId = 5;
//        DatabaseOperations.deleteStudent(deleteId);
//        log.info("\n=======READ RECORDS AFTER DELETION=======\n");
//        List<Student> deleteStudentRecord = DatabaseOperations.displayStudents();
//        for(Student student : deleteStudentRecord) {
//            log.info(student.toString());
//        }
//
//        log.info("\n=======DELETE ALL RECORDS=======\n");
//        DatabaseOperations.deleteAllStudents();
//        log.info("\n=======READ RECORDS AFTER ALL RECORDS DELETION=======");
//        List<Student> deleteAll = DatabaseOperations.displayStudents();
//        if(deleteAll.isEmpty()) {
//            log.info("\nNo Records Are Present In The Database Table!\n");
//        }
    }
}
