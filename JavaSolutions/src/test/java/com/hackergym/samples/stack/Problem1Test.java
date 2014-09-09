package com.hackergym.samples.stack;

import com.hackergym.samples.model.Element;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem1Test {

    Problem1 problem1 = new Problem1();

    @Test
    public void testKStackFixedSize() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFixedSizeStack(numberOfStacks, stackSize);

        //Act
        //all stacks should be initially empty
        for (int i = 0; i < numberOfStacks; i++) {
            assertThat(kStack.isEmpty(i), is(true));
        }

        //fill out one stack
        int index = 1;
        for (int i = 0; i < stackSize; i++) {
            kStack.push(index, new Element(String.valueOf(i)));
        }

        //push a couple of elements into another stack
        index = 2;
        int secondStackElementCount = 2;
        for (int i = 0; i < secondStackElementCount; i++) {
            kStack.push(index, new Element(String.valueOf(i)));
        }

        //Assert
        assertThat(kStack.isEmpty(0), is(true));
        assertThat(kStack.isEmpty(1), is(false));
        assertThat(kStack.isEmpty(2), is(false));
        assertThat(kStack.isEmpty(3), is(true));

        for (int i = stackSize - 1; i >= 0; i--) {
            Element expectedValue = new Element(String.valueOf(i));
            assertThat(kStack.pop(1), is(expectedValue));
        }

        for (int i = secondStackElementCount - 1; i >= 0; i--) {
            Element expectedValue = new Element(String.valueOf(i));
            assertThat(kStack.pop(2), is(expectedValue));
        }

        assertThat(kStack.isEmpty(0), is(true));
        assertThat(kStack.isEmpty(1), is(true));
        assertThat(kStack.isEmpty(2), is(true));
        assertThat(kStack.isEmpty(3), is(true));

        kStack.push(3, new Element("1"));
        kStack.push(3, new Element("2"));
        assertThat(kStack.pop(3), is(new Element("2")));
        kStack.push(3, new Element("3"));
        assertThat(kStack.pop(3), is(new Element("3")));
        assertThat(kStack.pop(3), is(new Element("1")));
        assertThat(kStack.isEmpty(3), is(true));
    }

    @Test(expected = StackOverflowError.class)
    public void testKStackFixedSizeStackIsFull() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFixedSizeStack(numberOfStacks, stackSize);

        //fill out one stack excessively
        int index = 1;
        for (int i = 0; i <= stackSize; i++) {
            kStack.push(index, new Element(String.valueOf(i)));
        }
    }

    @Test(expected = EmptyStackException.class)
    public void testKStackFixedSizeStackEmptyingAnEmptyStack() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFixedSizeStack(numberOfStacks, stackSize);

        assertThat(kStack.isEmpty(1), is(true));
        kStack.push(1, new Element("x"));
        assertThat(kStack.isEmpty(1), is(false));
        kStack.pop(1);
        assertThat(kStack.isEmpty(1), is(true));
        kStack.pop(1);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testKStackFixedSizeStackOutOfBoundIndex() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFixedSizeStack(numberOfStacks, stackSize);
        kStack.push(10, new Element("1"));
    }

    @Test
    public void testKStackFlexibleSize() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFlexibleSizeStack(numberOfStacks, stackSize);

        //Act
        //all stacks should be initially empty
        for (int i = 0; i < numberOfStacks; i++) {
            assertThat(kStack.isEmpty(i), is(true));
        }

        //fill out one stack
        int index = 1;
        for (int i = 0; i < stackSize; i++) {
            kStack.push(index, new Element(String.valueOf(i)));
        }

        //push a couple of elements into another stack
        index = 2;
        int secondStackElementCount = 2;
        for (int i = 0; i < secondStackElementCount; i++) {
            kStack.push(index, new Element(String.valueOf(i)));
        }

        //Assert
        assertThat(kStack.isEmpty(0), is(true));
        assertThat(kStack.isEmpty(1), is(false));
        assertThat(kStack.isEmpty(2), is(false));
        assertThat(kStack.isEmpty(3), is(true));

        for (int i = stackSize - 1; i >= 0; i--) {
            Element expectedValue = new Element(String.valueOf(i));
            assertThat(kStack.pop(1), is(expectedValue));
        }

        for (int i = secondStackElementCount - 1; i >= 0; i--) {
            Element expectedValue = new Element(String.valueOf(i));
            assertThat(kStack.pop(2), is(expectedValue));
        }

        assertThat(kStack.isEmpty(0), is(true));
        assertThat(kStack.isEmpty(1), is(true));
        assertThat(kStack.isEmpty(2), is(true));
        assertThat(kStack.isEmpty(3), is(true));

        kStack.push(3, new Element("1"));
        kStack.push(3, new Element("2"));
        assertThat(kStack.pop(3), is(new Element("2")));
        kStack.push(3, new Element("3"));
        assertThat(kStack.pop(3), is(new Element("3")));
        assertThat(kStack.pop(3), is(new Element("1")));
        assertThat(kStack.isEmpty(3), is(true));
    }

    @Test
    public void testKStackFlexibleSizeStackIsFull() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFlexibleSizeStack(numberOfStacks, stackSize);

        //Act
        kStack.push(2, new Element("1"));
        kStack.push(2, new Element("2"));
        kStack.push(2, new Element("3"));
        kStack.push(2, new Element("4"));
        kStack.push(2, new Element("5"));
        kStack.push(2, new Element("6"));
        kStack.push(2, new Element("7"));

        //Assert
        assertThat(kStack.isEmpty(2), is(false));
        assertThat(kStack.pop(2), is(new Element("7")));
        assertThat(kStack.pop(2), is(new Element("6")));
        assertThat(kStack.pop(2), is(new Element("5")));
        assertThat(kStack.isEmpty(2), is(true));
    }

    @Test(expected = EmptyStackException.class)
    public void testKStackFlexibleSizeStackEmptyingAnEmptyStack() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFlexibleSizeStack(numberOfStacks, stackSize);

        assertThat(kStack.isEmpty(1), is(true));
        kStack.push(1, new Element("x"));
        assertThat(kStack.isEmpty(1), is(false));
        kStack.pop(1);
        assertThat(kStack.isEmpty(1), is(true));
        kStack.pop(1);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testKStackFlexibleSizeStackOutOfBoundIndex() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFlexibleSizeStack(numberOfStacks, stackSize);
        kStack.push(10, new Element("1"));
    }

    @Test
    public void testKStackCustomFixedSize() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFixedSizeCustomStack(numberOfStacks, stackSize);

        //Act
        //all stacks should be initially empty
        for (int i = 0; i < numberOfStacks; i++) {
            assertThat(kStack.isEmpty(i), is(true));
        }

        //fill out one stack
        int index = 1;
        for (int i = 0; i < stackSize; i++) {
            kStack.push(index, new Element(String.valueOf(i)));
        }

        //push a couple of elements into another stack
        index = 2;
        int secondStackElementCount = 2;
        for (int i = 0; i < secondStackElementCount; i++) {
            kStack.push(index, new Element(String.valueOf(i)));
        }

        //Assert
        assertThat(kStack.isEmpty(0), is(true));
        assertThat(kStack.isEmpty(1), is(false));
        assertThat(kStack.isEmpty(2), is(false));
        assertThat(kStack.isEmpty(3), is(true));

        for (int i = stackSize - 1; i >= 0; i--) {
            Element expectedValue = new Element(String.valueOf(i));
            assertThat(kStack.pop(1), is(expectedValue));
        }

        for (int i = secondStackElementCount - 1; i >= 0; i--) {
            Element expectedValue = new Element(String.valueOf(i));
            assertThat(kStack.pop(2), is(expectedValue));
        }

        assertThat(kStack.isEmpty(0), is(true));
        assertThat(kStack.isEmpty(1), is(true));
        assertThat(kStack.isEmpty(2), is(true));
        assertThat(kStack.isEmpty(3), is(true));

        kStack.push(3, new Element("1"));
        kStack.push(3, new Element("2"));
        assertThat(kStack.pop(3), is(new Element("2")));
        kStack.push(3, new Element("3"));
        assertThat(kStack.pop(3), is(new Element("3")));
        assertThat(kStack.pop(3), is(new Element("1")));
        assertThat(kStack.isEmpty(3), is(true));
    }

    @Test(expected = StackOverflowError.class)
    public void testKStackCustomFixedSizeStackIsFull() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFixedSizeCustomStack(numberOfStacks, stackSize);

        //fill out one stack excessively
        int index = 1;
        for (int i = 0; i <= stackSize; i++) {
            kStack.push(index, new Element(String.valueOf(i)));
        }
    }

    @Test(expected = EmptyStackException.class)
    public void testKStackCustomFixedSizeStackEmptyingAStack() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFixedSizeCustomStack(numberOfStacks, stackSize);

        assertThat(kStack.isEmpty(1), is(true));
        kStack.push(1, new Element("x"));
        assertThat(kStack.isEmpty(1), is(false));
        kStack.pop(1);
        assertThat(kStack.isEmpty(1), is(true));
        kStack.pop(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testKStackCustomFixedSizeStackOutOfBoundIndex() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFixedSizeCustomStack(numberOfStacks, stackSize);
        kStack.push(10, new Element("1"));
    }


    @Test
    public void testKStackCustomFlexibleSize() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFlexibleSizeStack(numberOfStacks, stackSize);

        //Act
        //all stacks should be initially empty
        for (int i = 0; i < numberOfStacks; i++) {
            assertThat(kStack.isEmpty(i), is(true));
        }

        //fill out one stack
        int index = 1;
        for (int i = 0; i < stackSize; i++) {
            kStack.push(index, new Element(String.valueOf(i)));
        }

        //push a couple of elements into another stack
        index = 2;
        int secondStackElementCount = 2;
        for (int i = 0; i < secondStackElementCount; i++) {
            kStack.push(index, new Element(String.valueOf(i)));
        }

        //Assert
        assertThat(kStack.isEmpty(0), is(true));
        assertThat(kStack.isEmpty(1), is(false));
        assertThat(kStack.isEmpty(2), is(false));
        assertThat(kStack.isEmpty(3), is(true));

        for (int i = stackSize - 1; i >= 0; i--) {
            Element expectedValue = new Element(String.valueOf(i));
            assertThat(kStack.pop(1), is(expectedValue));
        }

        for (int i = secondStackElementCount - 1; i >= 0; i--) {
            Element expectedValue = new Element(String.valueOf(i));
            assertThat(kStack.pop(2), is(expectedValue));
        }

        assertThat(kStack.isEmpty(0), is(true));
        assertThat(kStack.isEmpty(1), is(true));
        assertThat(kStack.isEmpty(2), is(true));
        assertThat(kStack.isEmpty(3), is(true));

        kStack.push(3, new Element("1"));
        kStack.push(3, new Element("2"));
        assertThat(kStack.pop(3), is(new Element("2")));
        kStack.push(3, new Element("3"));
        assertThat(kStack.pop(3), is(new Element("3")));
        assertThat(kStack.pop(3), is(new Element("1")));
        assertThat(kStack.isEmpty(3), is(true));
    }

    @Test
    public void testKStackCustomFlexibleSizeStackIsFull() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFlexibleSizeStack(numberOfStacks, stackSize);

        //Act
        kStack.push(2, new Element("1"));
        kStack.push(2, new Element("2"));
        kStack.push(2, new Element("3"));
        kStack.push(2, new Element("4"));
        kStack.push(2, new Element("5"));
        kStack.push(2, new Element("6"));
        kStack.push(2, new Element("7"));

        //Assert
        assertThat(kStack.isEmpty(2), is(false));
        assertThat(kStack.pop(2), is(new Element("7")));
        assertThat(kStack.pop(2), is(new Element("6")));
        assertThat(kStack.pop(2), is(new Element("5")));
        assertThat(kStack.isEmpty(2), is(true));
    }

    @Test(expected = EmptyStackException.class)
    public void testKStackCustomFlexibleSizeStackEmptyingAStack() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFlexibleSizeStack(numberOfStacks, stackSize);

        assertThat(kStack.isEmpty(1), is(true));
        kStack.push(1, new Element("x"));
        assertThat(kStack.isEmpty(1), is(false));
        kStack.pop(1);
        assertThat(kStack.isEmpty(1), is(true));
        kStack.pop(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testKStackCustomFlexibleSizeStackOutOfBoundIndex() throws Exception {

        //Arrange
        int stackSize = 3;
        int numberOfStacks = 4;
        Problem1.KStack kStack = problem1.getFixedSizeCustomStack(numberOfStacks, stackSize);
        kStack.push(10, new Element("1"));
    }

}