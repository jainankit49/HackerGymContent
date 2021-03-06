package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem14Test {

    Problem14 indexFinder = new Problem14();

    @Test
    public void testFindMagicIndexOdd() throws Exception {

        //Arrange
        int[] array = {-2, 0, 2, 4, 7, 8, 9};

        //Act
        int result = indexFinder.findMagicIndex(array);

        //Assert
        assertThat(result, is(2));
    }

    @Test
    public void testFindMagicIndexEven() throws Exception {
        //Arrange
        int[] array = {-2, 1, 3, 4, 7, 8};

        //Act
        int result = indexFinder.findMagicIndex(array);

        //Assert
        assertThat(result, is(1));
    }

    @Test
    public void testFindMagicIndexNonExisting() throws Exception {
        //Arrange
        int[] array = {-2, 2, 3, 4, 7, 8};

        //Act
        int result = indexFinder.findMagicIndex(array);

        //Assert
        assertThat(result, is(-1));
    }

    @Test
    public void testFindMagicIndexWithDuplicatesOnRight() throws Exception {

        //Arrange
        int[] array = {-2, -4, 1, 2, 8, 8, 8, 8, 8};

        //Act
        int result = indexFinder.findMagicIndexWithDuplicates(array);

        //Assert
        assertThat(result, is(8));
    }

    @Test
    public void testFindMagicIndexWithDuplicatesOnLeft() throws Exception {

        //Arrange
        int[] array = {-2, 1, 1, 2, 2, 3, 4, 8, 9};

        //Act
        int result = indexFinder.findMagicIndexWithDuplicates(array);

        //Assert
        assertThat(result, is(1));
    }

    @Test
    public void testFindMagicIndexWithDuplicatesEven() throws Exception {
        //Arrange
        int[] array = {-2, 1, 1, 2, 2, 4, 7, 8};

        //Act
        int result = indexFinder.findMagicIndexWithDuplicates(array);

        //Assert
        assertThat(result, is(1));
    }


    @Test
    public void testFindMagicIndexWithDuplicatesNonExisting() throws Exception {
        //Arrange
        int[] array = {-2, -1, 1, 2, 2, 3, 7};

        //Act
        int result = indexFinder.findMagicIndexWithDuplicates(array);

        //Assert
        assertThat(result, is(-1));

    }

    @Test
    public void testFindMagicIndexWithDuplicatesNoDuplicates() throws Exception {

        //Arrange
        int[] array = {-2, 0, 2, 4, 7, 8, 9};

        //Act
        int result = indexFinder.findMagicIndexWithDuplicates(array);

        //Assert
        assertThat(result, is(2));
    }

    @Test
    public void testFindMagicIndexCustomOdd() throws Exception {

        //Arrange
        int[] array = {-2, 0, 2, 4, 7, 8, 9};

        //Act
        int result = indexFinder.findMagicIndexCustom(array);

        //Assert
        assertThat(result, is(2));
    }

    @Test
    public void testFindMagicIndexCustomEven() throws Exception {
        //Arrange
        int[] array = {-2, 1, 3, 4, 7, 8};

        //Act
        int result = indexFinder.findMagicIndexCustom(array);

        //Assert
        assertThat(result, is(1));
    }

    @Test
    public void testFindMagicIndexCustomNonExisting() throws Exception {
        //Arrange
        int[] array = {-2, 2, 3, 4, 7, 8};

        //Act
        int result = indexFinder.findMagicIndexCustom(array);

        //Assert
        assertThat(result, is(-1));
    }

    @Test
    public void testFindMagicIndexCustomWithDuplicatesOnRight() throws Exception {

        //Arrange
        int[] array = {-2, -4, 1, 2, 8, 8, 8, 8, 8};

        //Act
        int result = indexFinder.findMagicIndexWithDuplicatesCustom(array);

        //Assert
        assertThat(result, is(8));
    }

    @Test
    public void testFindMagicIndexWithDuplicatesCustomOnLeft() throws Exception {

        //Arrange
        int[] array = {-2, 1, 1, 2, 2, 3, 4, 8, 9};

        //Act
        int result = indexFinder.findMagicIndexWithDuplicatesCustom(array);

        //Assert
        assertThat(result, is(1));
    }

    @Test
    public void testFindMagicIndexWithDuplicatesCustomEven() throws Exception {
        //Arrange
        int[] array = {-2, 1, 1, 2, 2, 4, 7, 8};

        //Act
        int result = indexFinder.findMagicIndexWithDuplicatesCustom(array);

        //Assert
        assertThat(result, is(1));
    }


    @Test
    public void testFindMagicIndexWithDuplicatesCustomNonExisting() throws Exception {
        //Arrange
        int[] array = {-2, -1, 1, 2, 2, 3, 7};

        //Act
        int result = indexFinder.findMagicIndexWithDuplicatesCustom(array);

        //Assert
        assertThat(result, is(-1));

    }

    @Test
    public void testFindMagicIndexWithDuplicatesCustomNoDuplicates() throws Exception {

        //Arrange
        int[] array = {-2, 0, 2, 4, 7, 8, 9};

        //Act
        int result = indexFinder.findMagicIndexWithDuplicatesCustom(array);

        //Assert
        assertThat(result, is(2));
    }
}