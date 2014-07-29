package com.hackergym.samples.array.questions;

import com.hackergym.samples.model.Element;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReverseTest {

    @Test
    public void reverseWithMemoryNormal() {
        //Arrange
        Element[] subjectArray = createArray(10);
        Element[] actualArray = createArray(10);

        //Act
        Reverse reverser = new Reverse();
        subjectArray = reverser.reverseWithMemory(subjectArray);

        //Assert
        for (int i = 0; i < subjectArray.length; i++) {
           assertThat(subjectArray[i].getValue(), is(actualArray[actualArray.length - i -1].getValue()));
        }
    }

    @Test
    public void reverseWithMemoryOneElement() {
        //Arrange
        Element[] subjectArray = createArray(1);
        Element[] actualArray = createArray(1);

        Reverse reverse = new Reverse();
        subjectArray = reverse.reverseWithMemory(subjectArray);

        assertThat(subjectArray.length, is(actualArray.length));
        assertThat(subjectArray[0].getValue(), is(actualArray[0].getValue()));
    }

    @Test
    public void reverseWithoutMemoryNormal() {
        //Arrange
        Element[] subjectArray = createArray(10);
        Element[] actualArray = createArray(10);

        //Act
        Reverse reverser = new Reverse();
        subjectArray = reverser.reverseWithoutMemory(subjectArray);

        //Assert
        for (int i = 0; i < subjectArray.length; i++) {
            assertThat(subjectArray[i].getValue(), is(actualArray[actualArray.length - i -1].getValue()));
        }

    }

    @Test
    public void reverseWithoutMemoryOneElement() {
        //Arrange
        Element[] subjectArray = createArray(1);
        Element[] actualArray = createArray(1);

        Reverse reverse = new Reverse();
        subjectArray = reverse.reverseWithoutMemory(subjectArray);

        assertThat(subjectArray.length, is(actualArray.length));
        assertThat(subjectArray[0].getValue(), is(actualArray[0].getValue()));

    }

    private Element[] createArray(int size) {
        Element[] result = new Element[size];
        for (int i = 0; i < size; i++) {
            result[i] = new Element(String.valueOf(i));
        }
        return result;
    }
}