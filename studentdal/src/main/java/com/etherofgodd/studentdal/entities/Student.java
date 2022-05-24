package com.etherofgodd.studentdal.entities;

import javax.persistence.*;

@Entity
@Table(name = "studenttab")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "scourse")
    private String course;
    @Column(name = "sname")
    private String name;
    @Column(name = "sfee")
    private Double fees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", course='" + course + '\'' +
                ", name='" + name + '\'' +
                ", fees=" + fees +
                '}';
    }
}
