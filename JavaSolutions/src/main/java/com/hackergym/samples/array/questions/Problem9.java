package com.hackergym.samples.array.questions;

import com.hackergym.samples.model.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Fathalian on 7/28/14.
 * HackerGym.com
 */

/**
 * A Paged Array of size x is an array in which each element is a Page.
 * Respectively, a Page is an array which contains x elements.
 * In a Paged Array, only the last Page may have less than x elements.
 *
 * Imagine you have a Paged Array but don’t know the number of pages.
 * Implement the insert method with the following prototype:
 *
 *
 *  Adds element “e” inside a page with index “pageNo”, at the index “elementIndex” of that page.
 * public void insertElement (int pageNo, int elementIndex, Element e);
 *
 * For more detailed Solution see:
 * http://hackergym.com/#/problemView/d484fb87-cd9c-48aa-a013-84c21dfc56f2?p=9
 *
 */

public class Problem9 {


    /*============================================
    *                Your Custom Solution
    ============================================*/
    /**
     * Replace all public methods with your custom code.
     */

    private int maxPageSize;

    //we will use java's dynamic array list in this question so that we
    //can stop worrying about resizing.
    final private List<List<Element>> elements = new ArrayList<>();

    public Problem9(int maxPageSize) {
        if (maxPageSize == 0) throw new IllegalArgumentException("maxPageSize cannot be 0");
        this.maxPageSize = maxPageSize;
    }

    /**
     * adds Element e to elementIndex of a page at pageIndex.
     *
     * @param pageIndex    the index of the page to insert the element into.
     * @param elementIndex the index inside the page to insert the element into.
     * @param e            the element to be inserted
     * @throws java.lang.IndexOutOfBoundsException if either pageIndex or elementIndex is invalid
     */
    public void insert(int pageIndex, int elementIndex, Element e)
            throws IndexOutOfBoundsException, IllegalArgumentException {

        if (e == null) throw new IllegalArgumentException("element cannot be null");

        if
            //if element is out of bound of a page
                ((elementIndex > maxPageSize) ||
                //if element is two indexes bigger than current pages
                (pageIndex >= pageCount() + 1) ||
                //if element is one index bigger than current page but caller
                //is trying to insert at anything other than index 0. This
                //is the case for appending an element to the end of the array
                (pageIndex == pageCount() && elementIndex != 0) ||
                //if we are trying to add to the new page and the last page is still
                //not full
                (pageIndex != 0
                        && pageIndex == pageCount()
                        && elements.get(elements.size() - 1).size() < maxPageSize - 1)
                ) {
            throw new IndexOutOfBoundsException();
        }


        //if we are adding to a new page
        if (pageIndex == pageCount()) {
            elements.add(new ArrayList<>());
        }

        //find the page to insert into
        List<Element> pageElements = elements.get(pageIndex);

        //We have room for the element to be inserted
        if (pageElements.size() < maxPageSize) {
            //first create a new space for the new element
            //the add method on the ArrayList takes care of shifts to the right
            pageElements.add(elementIndex, e);
        } else {
            //get the element to move to the next page
            Element lastElement = pageElements.get(pageElements.size() - 1);
            shiftElementsRight(elementIndex, pageElements);
            pageElements.set(elementIndex, e);
            //recursively add the last element to the next pages
            insert(pageIndex + 1, 0, lastElement);
        }

        return;
    }

    /**
     * Shifts all the elements after index right, overwriting the right most element
     *
     * @param elements
     */
    private List<Element> shiftElementsRight(int index, List<Element> elements) {

        for (int i = elements.size() - 1; i > index; i--) {
            elements.set(i, elements.get(i - 1));
        }

        return elements;
    }

    /**
     * Deletes the first element in the PagedArray that have the same value as e.
     *
     * @param e elements to be deleted
     * @return true if any item was deleted.
     */
    public boolean delete(Element e) {

        boolean result = false;

        for (int pageIndex = 0; pageIndex < pageCount(); pageIndex++) {
            List<Element> pageElements = elements.get(pageIndex);

            for (int elementIndex = 0; elementIndex < pageElements.size(); elementIndex++) {
                if (pageElements.get(elementIndex).getValue().equals(e.getValue())) {

                    //we have reduced the number of pages so just break
                    if (pageIndex == pageCount() - 1 && pageElements.size() == 1) {
                        //we are supposed to only find the first element
                        deleteElementAtIndex(pageIndex, elementIndex);
                        return true;

                    }
                    //otherwise we have to move the index one back so that in the next
                    //for loop iteration that it will get incremented it will be on the
                    //next value (which has replaced the current value)
                    else {
                        //we are only supposed to delete the first element
                        deleteElementAtIndex(pageIndex, elementIndex);
                        return true;
                    }
                }
            }
        }
        return result;
    }

    /*
    Returns the element that was deleted. We will use the return value
    to fill out the hole created in the previous page in case a hole was created
    by a delete.
     */
    private Element deleteElementAtIndex(int pageIndex, int index) {

        //if we are removing the last item from the last page
        //make sure that we remove the page with it too
        if (pageIndex == pageCount() - 1
                && index == 0
                && elements.get(pageCount() - 1).size() == 1) {
            Element deletedElement = elements.get(pageCount() - 1).get(0);
            elements.remove(pageCount() - 1);
            return deletedElement;
        }

        //otherwise its a normal delete, just shift all the elements
        //after the index to the left, this will potentially clear out
        //the last element
        List<Element> pageElements = elements.get(pageIndex);
        Element elementToDelete = pageElements.get(index);
        shiftElementsLeft(index, pageElements);

        //If we are not on the last page, we might have created a hole
        //inside the page and we need to fill it up by borrowing from
        //the next page
        if (pageIndex < pageCount() - 1) {
            Element borrowed = deleteElementAtIndex(pageIndex + 1, 0);
            pageElements.set(pageElements.size() - 1, borrowed);
        }
        //We are using shifting and overwriting to delete an element
        //however in the case of the last page since the shifted array
        //won't be filled by anything new, we have to explicitly delete it
        else {
            pageElements.remove(pageElements.size() - 1);
        }
        return elementToDelete;
    }

    private List<Element> shiftElementsLeft(int index, List<Element> elements) {

        for (int i = index; i < elements.size() - 1; i++) {
            elements.set(i, elements.get(i + 1));
        }

        return elements;
    }

    /**
     * @return the element if it exists, null otherwise
     */
    public Element getElement(int pageIndex, int index)
            throws IndexOutOfBoundsException {

        //IndexOutOfBounds will be thrown automatically by the arrayList
        return elements.get(pageIndex).get(index);
    }

    ;

    /**
     * @return All elements who have the same value as e
     */
    public List<Element> getElement(Element e) {
        List<Element> answer = new ArrayList<>();
        for (List<Element> elementList : elements) {
            //Using Java8 lambda expressions. If you are unfamiliar you should
            //check it out. Its really cool
            answer.addAll(elementList.
                    stream().
                    filter(ee -> ee.getValue().equals(e)).
                    collect(Collectors.toList()));
        }
        return answer;
    }

    public int pageCount() {
        return elements.size();
    }

    public int count() {
        //for debug purposes we will count every item individually
        int count = 0;
        for (List<Element> elementList : elements) {
            count += elementList.size();
        }
        return count;
    }

    public String toString() {

        StringBuilder builder = new StringBuilder();
        int pageCounter = 0;
        for (List<Element> elementList : elements) {
            builder.append("page - " + pageCounter + "[ ");
            for (Element e : elementList) {
                builder.append(e.getValue() + " , ");
            }
            builder.append(" ] \n");

            pageCounter++;
        }

        return builder.toString();
    }
}
