package com.bofa.BioApp.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Component
public class Bio {

    private static int idTracker;



    private int id;


    private String name;


    private int age;


    private List<String> funFacts;

    public Bio() {
    }

    public Bio(String name, int age, List<String> funFacts) {
        this.id = ++idTracker;
        this.name = name;
        this.age = age;
        this.funFacts = funFacts;
    }

    public Bio(String name, int age) {
        this.id = ++idTracker;
        this.name = name;
        this.age = age;
        this.funFacts = new ArrayList<>();
    }

    public Bio(int id, String name, int age, List<String> funFacts) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.funFacts = funFacts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<String> getFunFacts() {
        return funFacts;
    }

    public void setFunFacts(List<String> funFacts) {
        this.funFacts = funFacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bio bio = (Bio) o;
        return id == bio.id && age == bio.age && Objects.equals(name, bio.name) && Objects.equals(funFacts, bio.funFacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, funFacts);
    }

    @Override
    public String toString() {
        return "Bio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", funFacts=" + funFacts +
                '}';
    }
}
