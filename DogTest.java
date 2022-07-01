package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {
    static Dog dog;

    @BeforeAll
    static void prepaneData() {
        dog = new Dog("Albert", 2);
    }
    @org.junit.jupiter.api.Test
    void testDogDetNameMethod() {

        assertEquals("Albert",dog.getName());
    }
    @org.junit.jupiter.api.Test
    void testSetNameMethod() {

        dog.setName("Roman");
        assertEquals("Albert", dog.getName());
    }

    @Test
    void testSetNameMethodIfEmpty() {
        Dog dog = new Dog("", 2);
        dog.setName("Roman");
        assertEquals("Roman", dog.getName());
    }

    @org.junit.jupiter.api.Test
    void getAge() {
    }

    @org.junit.jupiter.api.Test
    void setAge() {
    }
}