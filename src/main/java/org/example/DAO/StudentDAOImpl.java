package org.example.DAO;

import jakarta.persistence.*;
import org.example.Model.Student;


import java.util.List;

public class StudentDAOImpl implements StudentDAOI {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");

    @Override
    public List<Student> getStudents(String s) {
        EntityManager em = null;
        String sql = "SELECT * FROM  Student ";
        if(s!=null && !s.equals("")) sql="SELECT * FROM  Student  order by "+s;
        try {
            em = emf.createEntityManager();
            return em.createNativeQuery(sql, Student.class).getResultList();
        }
        finally {
            if(em!=null) em.close();
        }

    }

    @Override
    public List<Student> searchStudents(String search) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            String sql="SELECT s FROM  Student s where s.nom like :fname or s.nom like :lname";
            Query stmt = em.createQuery(sql, Student.class);
            stmt.setParameter("fname",search+"%");
            stmt.setParameter("lname","%"+search);
            return stmt.getResultList();
        }
        finally {
            if(em!=null) em.close();
        }
    }

    @Override
    public Student getStudent(Long id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            return em.find(Student.class,id);
        }
        finally {
            if(em!=null) em.close();
        }
    }

    @Override
    public void AddStudent(Student student) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            //em.persist(student.getAddress());
            em.persist(student);
            tx.commit();
        }
        finally {
            if(em!=null) em.close();
        }
    }

    @Override
    public void DeleteStudent(Long id) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(em.find(Student.class,id));
            tx.commit();
        }
        finally {
            if(em!=null) em.close();
        }
    }

    @Override
    public void UpdateStudent(Student student) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Student s = em.find(Student.class,student.getId());
            s.setYear(student.getYear());
            s.setNom(student.getNom());
            s.setPrenom(student.getPrenom());
            s.setCne(student.getCne());
            s.setBirthDate(student.getBirthDate());
            s.setEmail(student.getEmail());
            tx.commit();
        }
        finally {
            if(em!=null) em.close();
        }
    }
}
