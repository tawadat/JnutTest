package com.company;

public class Dog {
    private String name;
    private int age;

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(this.name.isEmpty()){
        this.name = name;
    }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
