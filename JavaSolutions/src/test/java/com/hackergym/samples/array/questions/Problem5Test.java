package com.hackergym.samples.array.questions;

import com.hackergym.samples.model.Element;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem5Test {

    @Test
    public void testInsertNormal() {

        //Arrange
        Problem5 array = new Problem5();

        //Act
        for (int i = 0; i <= 3; i++) {
            array.insert(new Element(String.valueOf(i)));
        }

        //Assert
        for (int i = 0; i <= 3; i++) {
            Element element = array.get(i);
            element.getValue().equals(String.valueOf(i));
        }
    }

    @Test
    public void testInsertWithExpansion() {
        //Arrange
        Problem5 array = new Problem5();

        //Act
        for (int i = 0; i <= 23; i++) {
            array.insert(new Element(String.valueOf(i)));
        }

        //Assert
        for (int i = 0; i <= 23; i++) {
            Element element = array.get(i);
            element.getValue().equals(String.valueOf(i));
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertNull() {

        Problem5 array = new Problem5();
        array.insert(null);
    }

    @Test
    public void testDeleteNormal() {

        //Arrange
        Problem5 array = new Problem5();

        int actualLength = 24;
        for (int i = 0; i < actualLength; i++) {
            array.insert(new Element(String.valueOf(i)));
        }

        //Act
        for (int i = 0 ; i < 3; i++) {
            array.delete(array.length() - 1);
        }

        //Assert
        assertThat(array.length(), is(actualLength - 3));
        for (int i = 0; i < actualLength - 3; i++) {
            Element e = array.get(i);
            assertThat(e.getValue(), is(String.valueOf(i)));
        }
    }

    @Test
    public void testDeleteWithShrinkage() {

        //Arrange
        Problem5 array = new Problem5();

        int actualLength = 24;
        for (int i = 0; i < actualLength; i++) {
            array.insert(new Element(String.valueOf(i)));
        }

        //Act
        for (int i = 1; i < actualLength ; i++) {
            array.delete(1);
        }

        //Assert
        assertThat(array.length(), is(1));
        Element e = array.get(0);
        assertThat(e.getValue(), is(String.valueOf("0")));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteInvalidIndex() {
        //Arrange
        Problem5 array = new Problem5();
        array.delete(100);
    }

    @Test
    public void testInsertAndDeleteTogether() {

        //Arrange
        Problem5 array = new Problem5();
        int actualLength = 15;
        for (int i = 0; i < actualLength; i++) {
            array.insert(new Element(String.valueOf(i)));
        }

        //Act & Assert
        for (int i = 0; i < 5; i++) {
            String newValue = "15";
            //insert
            array.insert(new Element(newValue));
            assertThat(array.length(), is(actualLength + 1));
            assertThat(array.get(array.length() - 1).getValue(), is(newValue));
            //delete
            array.delete(15);
            assertThat(array.length(), is(actualLength));
            assertThat(array.get(array.length() - 1).getValue(), not(newValue));
        }
    }
}