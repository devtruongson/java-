/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author truon
 */
public class User {

    private int id;
    private String email;
    private String password;
    private String name;
    private int age;
    private String address;
    private String job;

    public User() {
    }

    public User(int id, String email, String password, String name, int age, String address, String job) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.address = address;
        this.job = job;
    }

    public User(String email, String password, String name, int age, String address, String job) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.address = address;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getJob() {
        return job;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setJob(String job) {
        this.job = job;
    }
    
}
