package com.database.databasedemo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
//@Table(name = "person")
@NamedQuery(name = "find_all_persons", query = "select p from Person p")
public class Person {

    @Id
    @GeneratedValue //this starts at 1, the manual entries are 1001 etc.
    private long id;

    //@Column(name = "name") if the names didn't match
    private String name;
    private String location;
    private Date birthday;

    //Constructor for JDBC and manually assigning the ID
    public Person(long id, String name, String location, Date birthday) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthday = birthday;
    }

    //Constructor for Hibernate to manage the ID
    public Person(String name, String location, Date birthday) {
        this.name = name;
        this.location = location;
        this.birthday = birthday;
    }

    public Person(){}; //needs default constructor to pass java compile

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
