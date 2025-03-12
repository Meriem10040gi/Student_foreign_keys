package org.example.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String prenom;
    String email;
    String cne;
    Date birthDate;
    int year;
    @OneToOne(cascade = {CascadeType.PERSIST})
    Address address;
   // @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name = "Student_modules")
    List<Module> modules ;

    public Student() {
        super();
        address = new Address();
    }

    public Student(Long id, String nom, String prenom, String email, String cne, Date birthDate, int year, Address address, List<Module> module) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.cne = cne;
        this.birthDate = birthDate;
        this.year = year;
        this.address = address;
        this.modules = module;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Module> getModule() {
        return modules;
    }

    public void setModule(List<Module> module) {
        this.modules = module;
    }
}
