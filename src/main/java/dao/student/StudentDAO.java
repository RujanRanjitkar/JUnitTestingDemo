package dao.student;


import model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();

    Student getStudentById(int id);

    int addStudents(int id, String student_name, String address);

    boolean updateStudent(int id);

    boolean deleteStudent(int id);
}
