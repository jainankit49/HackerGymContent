package com.hackergym.samples.linkedlist.questions;

import com.hackergym.samples.linkedlist.model.LinkedListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Fathalian on 6/6/14.
 * HackerGym.com
 */
public class LinkedNumbers {

    public LinkedListNode<Integer> sum(LinkedListNode<Integer> num1,
                                       LinkedListNode<Integer> num2) {

        if (num1 == null) return num2;
        if (num2 == null) return num1;

        Deque<LinkedListNode<Integer>> stack1 = stackify(num1);
        Deque<LinkedListNode<Integer>> stack2 = stackify(num2);

        int carry = 0;

        LinkedListNode<Integer> newHead = null;

        //alignment of the numbers is done by using the items in the stack, the stack
        //with the smaller number will finish first
        while (!stack1.isEmpty() && !stack2.isEmpty()) {

            int sum = stack1.pop().value + stack2.pop().value + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;
            LinkedListNode<Integer> result = new LinkedListNode<>(sum);
            result.next = newHead;
            newHead = result;
        }


        //select the remaining stack
        Deque<LinkedListNode<Integer>> remainingStack = stack1.isEmpty() ? stack2 : stack1;

        while(!remainingStack.isEmpty()) {
            int sum = remainingStack.pop().value + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;
            LinkedListNode<Integer> result = new LinkedListNode<>(sum);
            result.next = newHead;
            newHead = result;
        }

        if (carry == 1) {
            LinkedListNode<Integer> result = new LinkedListNode<>(1);
            result.next = newHead;
            newHead = result;
        }
        return newHead;
    }

    public LinkedListNode<Integer> sumReverse(LinkedListNode<Integer> num1,
                                              LinkedListNode<Integer> num2) {

        if (num1 == null) return num2;
        if (num2 == null) return num1;

        //first align numbers
        List<LinkedListNode<Integer>> tuple = alignNums(num1, num2);
        assert tuple.size() == 2;
        num1 = tuple.get(0);
        num2 = tuple.get(1);

        //reverse the numbers
        Reverse<Integer> reverser = new Reverse<>();
        num1 = reverser.reverseWithPointers(num1);
        num2 = reverser.reverseWithPointers(num2);


        //now we sum them up while moving the carry
        int carry = 0;
        LinkedListNode<Integer> temp1 = num1;
        LinkedListNode<Integer> temp2 = num2;
        LinkedListNode<Integer> result = null;
        LinkedListNode<Integer> temp3 = null;

        while (temp1 != null && temp2 != null) {
            int sum = temp1.value + temp2.value + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;

            LinkedListNode<Integer> sumNode = new LinkedListNode<>(sum);
            if (result == null) {
                result = sumNode;
                temp3 = result;
            }
            temp3.next = sumNode;
            temp3 = temp3.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if (carry == 1) {

            LinkedListNode<Integer> finalCarry = new LinkedListNode<>(carry);
            temp3.next = finalCarry;
        }

        return reverser.reverseWithPointers(result);
    }

    public LinkedListNode<Integer> subtract(LinkedListNode<Integer> num1,
                                            LinkedListNode<Integer> num2) {

        if (num1 == null) return num2;
        if (num2 == null) return num1;


        //first align numbers
        List<LinkedListNode<Integer>> tuple = alignNums(num1, num2);
        assert tuple.size() == 2;
        num1 = tuple.get(0);
        num2 = tuple.get(1);

        //first arrange the numbers so that the bigger number always comes first
        tuple = rearrangeNumbers(num1, num2);
        num1 = tuple.get(0);
        num2 = tuple.get(1);

        //reverse the numbers
        Reverse<Integer> reverser = new Reverse<>();
        num1 = reverser.reverseWithPointers(num1);
        num2 = reverser.reverseWithPointers(num2);

        //now perform subtraction
        LinkedListNode<Integer> temp1 = num1;
        LinkedListNode<Integer> temp2 = num2;
        LinkedListNode<Integer> result = null;
        LinkedListNode<Integer> temp3 = null;
        int carry = 0;
        while (temp1 != null && temp2 != null) {
            int digit1 = temp1.value + carry;
            int digit2 = temp2.value;
            int resultDigit = 0;
            if (digit1 >= digit2) {
                resultDigit = digit1 - digit2;
                carry = 0;
            } else {
                resultDigit = 10 + digit1 - digit2;
                carry = -1;
            }

            LinkedListNode<Integer> subtractNode = new LinkedListNode<>(resultDigit);
            if (result == null) {
                result = subtractNode;
                temp3 = result;
            } else {
                temp3.next = subtractNode;
                temp3 = temp3.next;
            }
            temp3.next = null;
            temp1 = temp1.next;
            temp2 = temp2.next;

        }

        return removeExtraZeros(reverser.reverseWithPointers(result));
    }


    /**
     * Aligns two numbers represented by two linked lists with heads of num1 and num2
     * May not be the best design for this method. Good enough for here.
     *
     * @return a list with num1 aligned at 0 and num2 aligned at 1
     */
    public List<LinkedListNode<Integer>> alignNums(LinkedListNode<Integer> num1,
                                                   LinkedListNode<Integer> num2) {

        List<LinkedListNode<Integer>> result = new ArrayList<>();
        int num1Length = getSize(num1);
        int num2Length = getSize(num2);

        int numberOfShifts = Math.abs(num1Length - num2Length);
        if (num1Length > num2Length) {
            while (numberOfShifts > 0) {
                LinkedListNode<Integer> zero = new LinkedListNode<>(0);
                zero.next = num2;
                num2 = zero;
                numberOfShifts--;
            }

        } else if (num2Length > num1Length) {
            while (numberOfShifts > 0) {
                LinkedListNode<Integer> zero = new LinkedListNode<>(0);
                zero.next = num1;
                num1 = zero;
                numberOfShifts--;
            }
        }

        result.add(num1);
        result.add(num2);

        return result;

    }

    private int getSize(LinkedListNode<Integer> head) {
        int size = 0;
        LinkedListNode<Integer> temp = head;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    //zeros in the back of number do not have meaning, remove those
    private LinkedListNode<Integer> removeExtraZeros(LinkedListNode<Integer> head) {
        while (head != null && head.value == 0) {
            head = head.next;
        }
        return head;
    }

    private List<LinkedListNode<Integer>> rearrangeNumbers(LinkedListNode<Integer> num1,
                                     LinkedListNode<Integer> num2) {

        List<LinkedListNode<Integer>> result = new ArrayList<>();
        LinkedListNode<Integer> temp1 = num1;
        LinkedListNode<Integer> temp2 = num2;
        while (temp1 != null && temp2 != null) {
            if (temp1.value > temp2.value) {
                result.add(num1);
                result.add(num2);
                return result;
            }else if (temp2.value > temp1.value){
                result.add(num2);
                result.add(num1);
                return result;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        //both numbers are equal, the order does not matter
        result.add(num2);
        result.add(num1);
        return result;
    }

    private Deque<LinkedListNode<Integer>> stackify(LinkedListNode<Integer> head) {

        Deque<LinkedListNode<Integer>> stack = new ArrayDeque<>();

        LinkedListNode<Integer> temp = head;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        return stack;
    }
}
