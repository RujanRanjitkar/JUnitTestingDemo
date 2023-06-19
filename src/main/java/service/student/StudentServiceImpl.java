package service.student;

import dao.student.StudentDAO;
import model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }


    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public int addStudents(int id, String student_name, String address) {
        if(id==0 || student_name.equals("") || address.equals("")){
            throw new IllegalArgumentException("Invalid input");
        }
        return studentDAO.addStudents(id,student_name,address);
    }

    @Override
    public boolean updateStudentById(int id) {
        Student student=studentDAO.getStudentById(id);
        if(student!=null){
            studentDAO.updateStudent(id);
            return true;
        } else if (id<=0) throw new IllegalArgumentException("Invalid id");
        else
            return false;
    }

    @Override
    public boolean deleteStudentById(int id) {
        Student student=studentDAO.getStudentById(id);
        if(student!=null){
            studentDAO.deleteStudent(id);
            return true;
        }
        else if (id<=0) throw new IllegalArgumentException("Invalid id");
        return false;
    }
}
