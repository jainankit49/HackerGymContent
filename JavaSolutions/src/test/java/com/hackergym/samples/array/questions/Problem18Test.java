package com.hackergym.samples.array.questions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem18Test {

    Problem18 perm = new Problem18();

    @Test
    public void testPermutate() throws Exception {

        //Arrange
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] permutation = {3, 0, 1, 2, 5, 4};
        char[] expected = {'b', 'c', 'd', 'a', 'f', 'e'};

        //Act
        char[] actual = perm.permutate(input, permutation);

        //assert
        assertThat(actual, is(expected));
    }

    @Test
    public void testPermutateOneCycle() throws Exception {
        //Arrange
        char[] input = {'a', 'b', 'c', 'd'};
        int[] permutation = {3, 0, 1, 2 };
        char[] expected = {'b', 'c', 'd', 'a'};

        //Act
        char[] actual = perm.permutate(input, permutation);

        //assert
        assertThat(actual, is(expected));
    }

    @Test
    public void testPermutateAllCycles() throws Exception {

        //Arrange
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] permutation = {7, 2, 1, 5, 6, 3, 4, 0};
        char[] expected = {'h', 'c', 'b', 'f', 'g', 'd', 'e', 'a'};

        //Act
        char[] actual = perm.permutate(input, permutation);

        //assert
        assertThat(actual, is(expected));
    }

    @Test
    public void testPermutateNoPermutation() throws Exception {

        //Arrange
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] permutation = {0, 1, 2, 3, 4, 5, 6, 7};
        char[] expected = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        //Act
        char[] actual = perm.permutate(input, permutation);

        //assert
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPermutateBadPermutationIndexes() throws Exception {

        //Arrange
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] permutation = {0, 1, 200, 3, 4, 5, 6, 7};
        char[] expected = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        //Act
        char[] actual = perm.permutate(input, permutation);

        //assert
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPermutateBadPermutation() throws Exception {

        //Arrange
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] permutation = {0, 1, 2};
        char[] expected = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        //Act
        char[] actual = perm.permutate(input, permutation);

        //assert
        assertThat(actual, is(expected));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testPermutateInvalidPermutation() throws Exception {

        //Arrange
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] permutation = {1,1, 2, 4, 3, 1, 4, 5};
        char[] expected = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        //Act
        char[] actual = perm.permutate(input, permutation);

        //assert
        assertThat(actual, is(expected));

    }

    @Test
    public void testPermutateCustom() throws Exception {

        //Arrange
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] permutation = {3, 0, 1, 2, 5, 4};
        char[] expected = {'b', 'c', 'd', 'a', 'f', 'e'};

        //Act
        char[] actual = perm.permutateCustom(input, permutation);

        //assert
        assertThat(actual, is(expected));
    }

    @Test
    public void testPermutateCustomOneCycle() throws Exception {
        //Arrange
        char[] input = {'a', 'b', 'c', 'd'};
        int[] permutation = {3, 0, 1, 2 };
        char[] expected = {'b', 'c', 'd', 'a'};

        //Act
        char[] actual = perm.permutateCustom(input, permutation);

        //assert
        assertThat(actual, is(expected));
    }

    @Test
    public void testPermutateCustomAllCycles() throws Exception {

        //Arrange
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] permutation = {7, 2, 1, 5, 6, 3, 4, 0};
        char[] expected = {'h', 'c', 'b', 'f', 'g', 'd', 'e', 'a'};

        //Act
        char[] actual = perm.permutateCustom(input, permutation);

        //assert
        assertThat(actual, is(expected));
    }

    @Test
    public void testPermutateCustomNoPermutation() throws Exception {

        //Arrange
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] permutation = {0, 1, 2, 3, 4, 5, 6, 7};
        char[] expected = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        //Act
        char[] actual = perm.permutateCustom(input, permutation);

        //assert
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPermutateCustomBadPermutationIndexes() throws Exception {

        //Arrange
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] permutation = {0, 1, 200, 3, 4, 5, 6, 7};
        char[] expected = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        //Act
        char[] actual = perm.permutateCustom(input, permutation);

        //assert
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPermutateCustomBadPermutation() throws Exception {

        //Arrange
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] permutation = {0, 1, 2};
        char[] expected = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        //Act
        char[] actual = perm.permutateCustom(input, permutation);

        //assert
        assertThat(actual, is(expected));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testPermutateCustomInvalidPermutation() throws Exception {

        //Arrange
        char[] input = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int[] permutation = {1,1, 2, 4, 3, 1, 4, 5};
        char[] expected = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        //Act
        char[] actual = perm.permutate(input, permutation);

        //assert
        assertThat(actual, is(expected));

    }
}