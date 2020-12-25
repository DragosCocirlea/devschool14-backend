package com.ing.tech.course1.data;

import java.util.Objects;

public class Person {
    private String lastname;
    private String firstname;

    private int age;

    private String job;

    public Person(String lastname, String firstname, int age, String job) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.job = job;
    }

    public Person() {
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(lastname, person.lastname) &&
                Objects.equals(firstname, person.firstname) &&
                Objects.equals(job, person.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname, age, job);
    }
}
