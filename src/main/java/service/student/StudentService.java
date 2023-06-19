package service.student;

import model.Student;

import java.util.List;

public interface StudentService {
     List<Student> getAllStudents();

     int addStudents(int id, String student_name, String address);

     boolean updateStudentById(int id);
     boolean deleteStudentById(int id);
}
