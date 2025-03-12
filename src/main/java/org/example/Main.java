package org.example;

import org.example.DAO.StudentDAOI;
import org.example.DAO.StudentDAOImpl;
import org.example.Model.Address;
import org.example.Model.Student;
import org.example.Model.Module;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Address address = new Address(1L,"Marrakech","Morroco","40000");
        List<Module> l = new ArrayList<>();
        Module m1 = new Module(1L,"POO");
        Module m2 = new Module(2L,"Java");
        Module m3 = new Module(3L,"Python");
        l.add(m1);
        l.add(m2);
        l.add(m3);
        Student s = new Student(1L,"Esskoury","Meriem","mari@gmail.com","gsffd",null,5,address,l);
        StudentDAOI studentDAO = new StudentDAOImpl();
        studentDAO.AddStudent(s);
    }
}