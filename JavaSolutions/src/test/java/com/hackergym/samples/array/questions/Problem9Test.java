package com.hackergym.samples.array.questions;

import com.hackergym.samples.model.Element;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Problem9Test {


    @Test(expected = IllegalArgumentException.class)
    public void testCreatePagedArrayZeroSize() throws Exception {
        new Problem9(0);
    }

    @Test
    public void testInsertElementNormal() throws Exception {

        Problem9 pagedArray = pagedArray(5, 18);

        String elementValue = "value";
        int pageIndex = 2;
        int index = 2;
        Element element = new Element(elementValue);
        pagedArray.insert(pageIndex, index, element);

        Element expectedElement = pagedArray.getElement(pageIndex, index);

        assertThat(expectedElement.getValue(), is(elementValue));
    }

    @Test
    public void testInsertElementToLastPage() throws Exception {

        Problem9 pagedArray = pagedArray(5, 16);

        String elementValue = "value";
        int pageIndex = 3;
        int index = 0;
        Element element = new Element(elementValue);
        pagedArray.insert(pageIndex, index, element);

        Element expectedElement = pagedArray.getElement(pageIndex, index);

        assertThat(expectedElement.getValue(), is(elementValue));

        assertThat(pagedArray.pageCount(), is(4));
    }

    @Test
    public void testInsertAsLastElement() {

        Problem9 pagedArray = pagedArray(5, 15);

        String elementValue = "value";
        int pageIndex = 3;
        int index = 0;
        Element element = new Element(elementValue);
        pagedArray.insert(pageIndex, index, element);

        Element expectedElement = pagedArray.getElement(pageIndex, index);

        assertThat(expectedElement.getValue(), is(elementValue));

        assertThat(pagedArray.pageCount(), is(4));
    }

    @Test
    public void testInsertElementLastPageFull() throws Exception {

        Problem9 pagedArray = pagedArray(5, 15);

        String elementValue = "value";
        int pageIndex = 2;
        int index = 2;
        Element element = new Element(elementValue);
        pagedArray.insert(pageIndex, index, element);

        Element expectedElement = pagedArray.getElement(pageIndex, index);

        assertThat(expectedElement.getValue(), is(elementValue));

        assertThat(pagedArray.pageCount(), is(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertElementAtNewPageWhilePrevPagesAreEmprty() {

        Problem9 pagedArray = pagedArray(5, 13);
        pagedArray.insert(3, 0, new Element(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertElementNullElement() throws Exception {
        Problem9 pagedArray = pagedArray(5, 15);
        pagedArray.insert(0, 0, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertIndexOutOfBound() throws Exception {
        Problem9 pagedArray = pagedArray(5, 15);
        pagedArray.insert(100, 200, new Element(""));
    }

    @Test
    public void testDeleteElementNormal() {

        //Arrange
        Problem9 pagedArray = pagedArray(5, 23);
        int actualSize = pagedArray.count();
        Element actualElement = pagedArray.getElement(3, 3);

        //Act
        pagedArray.delete(actualElement);

        //Assert
        Element expectedElement = pagedArray.getElement(3, 3);
        int expectedSize = pagedArray.count();
        assertThat(expectedElement.getValue(), not(actualElement.getValue()));
        assertThat(expectedSize, is(actualSize - 1));
    }

    @Test
    public void testDeleteElementLastPageEmpty() {

        //Arrange
        Problem9 pagedArray = pagedArray(5, 15);
        String actualValue = "value";
        pagedArray.insert(3, 0, new Element(actualValue));
        int actualSize = pagedArray.count();

        //Act
        pagedArray.delete(new Element(actualValue));

        //Assert
        int expectedSize = pagedArray.count();
        List<Element> foundElement = pagedArray.getElement(new Element(actualValue));
        assertThat(foundElement.size(), is(0));
        assertThat(expectedSize, is(actualSize - 1));

    }

    @Test
    public void testDeleteElementNonExisting() {
        //Arrange
        Problem9 pagedArray = pagedArray(5, 15);

        //Act
        boolean result = pagedArray.delete(new Element("non Existing"));

        //Assert
        assertThat(result, is(false));
        List<Element> foundElement = pagedArray.getElement(new Element("non Existing"));
        assertThat(foundElement.size(), is(0));

    }

    public Problem9 pagedArray(int maxPageSize, int elementCount) {

        Problem9 pa = new Problem9(maxPageSize);

        for (int i = 0; i < elementCount; i++) {
            pa.insert(0, 0, new Element("e" + i));
        }

        return pa;
    }

}