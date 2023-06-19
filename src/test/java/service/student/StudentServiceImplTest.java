package service.student;

import dao.student.StudentDAO;
import model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@DisplayName("Testing for student details")
class StudentServiceImplTest {
    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentDAO studentDAOMock;

    public StudentServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Testing student added with invalid data")
    void addStudentTestWithInvalidData() {
        assertThrows(IllegalArgumentException.class, () -> studentService.addStudents(0, "sdgdsg", "scasf"));
    }

    @Test
    @DisplayName("Testing student added with valid data")
    void addStudentTestWithValidData() {
        when(studentDAOMock.addStudents(anyInt(), anyString(), anyString())).thenReturn(1);
        assertEquals(1, studentService.addStudents(1, "ram", "ktm"));
    }

    @Test
    @DisplayName("Testing student updated with exising id")
    void updateStudentTestWhenIdExists() {
        Student s = new Student(1, "ram", "ktm");
        when(studentDAOMock.getStudentById(anyInt())).thenReturn(s);
        when(studentDAOMock.updateStudent(anyInt())).thenReturn(true);
        assertTrue(studentService.updateStudentById(1));
    }

    @Test
    @DisplayName("Testing student updated with invalid id")
    void updateStudentTestWhenInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> studentService.updateStudentById(0));
    }

    @Test
    @DisplayName("Testing student updated with non-existing id")
    void updateStudentTestWhenIdDoesNotExist() {
        when(studentDAOMock.getStudentById(anyInt())).thenReturn(null);
        assertFalse(studentService.updateStudentById(1));
    }

    @Test
    @DisplayName("Testing student deleted with existing id")
    void deleteStudentTestWhenIdExists() {
        Student s = new Student(1, "ram", "ktm");
        when(studentDAOMock.getStudentById(anyInt())).thenReturn(s);
        when(studentDAOMock.deleteStudent(anyInt())).thenReturn(true);
        assertTrue(studentService.deleteStudentById(1));
    }

    @Test
    @DisplayName("Testing student deleted with invalid id")
    void deleteStudentTestWhenInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> studentService.deleteStudentById(0));
    }

    @Test
    @DisplayName("Testing student deleted with non-existing id")
    void deleteStudentTestWhenIdDoesNotExist() {
        when(studentDAOMock.getStudentById(anyInt())).thenReturn(null);
        assertFalse(studentService.deleteStudentById(1));
    }

    @Test
    @DisplayName("Testing student selected")
    void getAllStudentsTest(){
        List<Student> list=new ArrayList<>();
        Student s1=new Student(1,"ram","ktm");
        Student s2=new Student(2,"hari","bkt");
        list.add(s1);
        list.add(s2);
        when(studentDAOMock.getAllStudents()).thenReturn(list);
        assertEquals(list,studentService.getAllStudents());
    }

}