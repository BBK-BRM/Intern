package org.example.employeeapi.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "employees")
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String post;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }

    public Employee(){
    }

    public Employee(String name,int age,String post){
        this.name = name;
        this.age = age;
        this.post = post;
    }
}