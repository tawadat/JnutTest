package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;
    @BeforeEach
    public void CreateCar(){
        car = new Car("Skoda", "ABC-1234",2019, "Roman");
    }

    @Test
    void getManufacturer() {
        assertEquals("Skoda", car.getManufacturer());
    }

    @Test
    void getNumber() {
        assertEquals("ABC-1234", car.getNumber());
    }

    @Test
    void setNumber() {
        car.setNumber("ABCD - 1234");
        assertEquals("ABCD - 1234", car.getNumber());
    }

    @ParameterizedTest
   @CsvSource({"'ABCD-123', 'ABCD-123'", "'DEF-456','DEF-456'"})
    void testSetNumberMultipleValues(String number, String x){
        car.setNumber(number);
        assertEquals(x, car.getNumber());
    }
    @ParameterizedTest
    @CsvSource({ "1,5", "8,12", "32,36"})
    void testInt(int input, int output) {
        assertEquals(car.testInt(input),output);
    }

    @Test
    void getYear() {
        assertEquals(2019, car.getYear());
    }

    @Test
    void getOwner() {
        assertEquals("Roman", car.getOwner());
    }

    @Test
    void setOwner() {
        car.setOwner("Vasia");
        assertEquals("Vasia", car.getOwner());
    }

    @Test
    void getListOfOweners(){
        assertArrayEquals(new String[]{"Roman"}, car.getOwners().toArray());
    }

    @Test
    void getListOfTwoOweners(){
        car.setOwner("Vasia");
        assertArrayEquals(new String[]{"Roman", "Vasia"}, car.getOwners().toArray());
    }

    @Test
    void testPrivateMethod(){
        try{
        Method metod = Car.class.getDeclaredMethod("testMethod", null);
        metod.setAccessible(true);
        assertEquals(metod.invoke(car).toString(),"abc");
           } catch (Exception e ){
            e.printStackTrace();
        }
    }

    @Test
    void testPrivateArgumentMethod(){
        try{
            Method metod = Car.class.getDeclaredMethod("testMethod", String.class);
            metod.setAccessible(true);
            assertEquals(metod.invoke(car, "abc").toString(),"abc");
        } catch (Exception e ){
            e.printStackTrace();
        }
    }
    @ParameterizedTest
    @DisplayName("Test demonstration")
    @CsvFileSource(resources = "/com/company/test-data.csv", delimiter = '|',numLinesToSkip = 1)
    public  void testNumbers(String input, String expected){
        car.setNumber(input);
        assertEquals(expected, car.getNumber());
    }
}