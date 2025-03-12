package org.example.DAO;



import org.example.Model.Student;

import java.util.List;

public interface StudentDAOI {
    List<Student> getStudents(String s);
    List<Student> searchStudents(String s);
    Student getStudent(Long id);
    void AddStudent(Student student);
    void DeleteStudent(Long id);
    void UpdateStudent(Student student);

}
