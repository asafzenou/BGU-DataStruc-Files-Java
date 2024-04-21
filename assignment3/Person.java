package assignment3;

import java.io.*;
import java.util.Objects;

public class Person implements Serializable {
    private String name;
    private int age;
    private double luckyNumber;

    public Person() {
        this.name = "";
    }

    public Person(String name, int age, double luckyNumber) {
        this.name = name;
        this.age = age;
        this.luckyNumber = luckyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(double luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", luckyNumber=" + luckyNumber +
                '}';
    }

    @Override // A person is considered the same person iff their equals() return true
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Double.compare(person.luckyNumber, luckyNumber) == 0 && Objects.equals(name, person.name);
    }
}
