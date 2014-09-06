package com.hackergym.samples.linkedlist.model;

import com.hackergym.samples.linkedlist.questions.Problem1;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by Fathalian on 6/5/14.
 * HackerGym.com
 */
public class LinkedListFactory {

    public static LinkedListNode<String> generateStringLinkedList(int size) {

        if (size <= 0) return null;

        LinkedListNode<String> head = new LinkedListNode<>("0");
        LinkedListNode<String> temp = head;
        for (int i = 1; i < size; i++) {
            temp.next = new LinkedListNode<>(String.valueOf(i));
            temp = temp.next;
        }
        return head;
    }

    public static LinkedListNode<Integer> generateSortedListOfNumbers(int size) {
        if (size <= 0) return null;

        Random randGen = new Random();
        IntStream intStream = randGen.ints(5, 100).limit(size);
        int[] randomInts = intStream.sorted().toArray();

        LinkedListNode<Integer> head = new LinkedListNode<>(randomInts[0]);
        LinkedListNode<Integer> temp = head;

        for (int i = 1; i < randomInts.length; i++) {
            temp.next = new LinkedListNode<>(randomInts[i]);
            temp = temp.next;
        }
        return head;
    }

    public static LinkedListNode<Integer> generateLinkedListFromNumber(int number) {

        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> temp = null;
        while (number != 0) {
            int digit = number % 10;
            if (head == null) {
                head = new LinkedListNode<>(digit);
                temp = head;
            } else {
                temp.next = new LinkedListNode<>(digit);
                temp = temp.next;
            }
            number = number / 10;
        }
        LinkedListNode<Integer> result = new Problem1<Integer>().reverseWithPointers(head);
        return result;
    }

    public static LinkedListNode<String> generateCircularLinkedList(int size, int indexToLoopBack) {

        if (size <= 0) return null;

        LinkedListNode<String> head = new LinkedListNode<>("0");
        LinkedListNode<String> temp = head;
        LinkedListNode<String> loopBackNode = head;
        for (int i = 1; i < size; i++) {
            temp.next = new LinkedListNode<>(String.valueOf(i));
            temp = temp.next;
            if (indexToLoopBack == i) {
                loopBackNode = temp;
            }
        }

        temp.next = loopBackNode;

        return head;
    }

    public static LinkedListNode<String> generateLinkedListFromString(String str) {

        if (str.length() == 0) return null;
        char[] charArray = str.toCharArray();
        LinkedListNode<String> head = new LinkedListNode<>(String.valueOf(charArray[0]));
        LinkedListNode<String> temp = head;
        for (int i = 1; i < charArray.length; i++) {
            temp.next = new LinkedListNode<>(String.valueOf(charArray[i]));
            temp = temp.next;
        }
        return head;
    }

    public static Pair<LinkedListNode<String>, LinkedListNode<String>>
    generateIntersectingLinkedLists(int size1,
                                    int size2,
                                    int intersectIndexForList1) {

        //first make the shared part
        int sharedPartSize = size1 - intersectIndexForList1;
        int intersectIndexForList2 = size2 - sharedPartSize;

        if (sharedPartSize < 0) return null;
        if (intersectIndexForList2 < 0) return null;

        LinkedListNode<String> sharedHead = new LinkedListNode<>("S0");
        LinkedListNode<String> sharedTraverser = sharedHead;
        for (int i = 1; i < sharedPartSize; i++) {
            LinkedListNode<String> temp = new LinkedListNode<>("S" + String.valueOf(i));
            sharedTraverser.next = temp;
            sharedTraverser = sharedTraverser.next;
        }
        sharedTraverser.next = null;

        //now create the individual part of first list
        LinkedListNode<String> firstHead = null;
        LinkedListNode<String> firstTraverser = null;
        for (int i = 0; i < intersectIndexForList1; i++) {
            if (i == 0) {
                firstHead = new LinkedListNode<>("A0");
                firstTraverser = firstHead;
            } else {
                LinkedListNode<String> temp = new LinkedListNode<>("A" + String.valueOf(i));
                firstTraverser.next = temp;
                firstTraverser = firstTraverser.next;
            }
        }

        if (firstHead == null) {
            firstHead = sharedHead;
        } else {
            firstTraverser.next = sharedHead;
        }

        //now create the individual part of second list
        LinkedListNode<String> secondHead = null;
        LinkedListNode<String> secondTraverser = null;
        for (int i = 0; i < intersectIndexForList2; i++) {
            if (i == 0) {
                secondHead = new LinkedListNode<>("B0");
                secondTraverser = secondHead;
            } else {
                LinkedListNode<String> temp = new LinkedListNode<>("B" + String.valueOf(i));
                secondTraverser.next = temp;
                secondTraverser = secondTraverser.next;
            }
        }
        if (secondHead == null) {
            secondHead = sharedHead;
        } else {
            secondTraverser.next = sharedHead;
        }

        Pair<LinkedListNode<String>, LinkedListNode<String>> result = new Pair<>(firstHead, secondHead);
        return result;
    }

    public static Pair<BigListNode<String>, String[]> generateBigList() {

        /**
         *
         * [0]--[1]--[2]--[3]--[4]-------------[5]
         *  |              |     |               |
         * [6]--[7]--[8]  [9]  [10]--[11]      [12]
         *  |         |          |               |
         * [13]      [14]      [15]            [16]
         *  |                    |               |
         * [17]--[18]--[19]    [20]            [21]--[22]--[23]
         *                       |
         *                     [24]
         */

        String[] expectedResult = {"0", "6", "13", "17", "18", "19", "7", "8", "14",
                "1",
                "2",
                "3", "9",
                "4", "10", "15", "20", "24", "11",
                "5", "12", "16", "21", "22", "23"};

        Map<String, BigListNode<String>> all = new HashMap<>();
        for (int i = 0; i <= 24; i++) {
            String index = String.valueOf(i);
            BigListNode<String> newNode = new BigListNode<>(index);
            all.put(index, newNode);
        }


        String[] headNodes = {"0", "1", "2", "3", "4", "5"};
        BigListNode<String> head = makeLinkedListFrom(headNodes, all);

        String[] l11 = {"6", "7", "8"};
        BigListNode<String> l11H = makeLinkedListFrom(l11, all);
        all.get("0").child = l11H;

        all.get("3").child = all.get("9");

        String[] l12 = {"10", "11"};
        BigListNode<String> l12H = makeLinkedListFrom(l12, all);
        all.get("4").child = l12H;

        all.get("5").child = all.get("12");

        all.get("6").child = all.get("13");

        all.get("8").child = all.get("14");

        all.get("10").child = all.get("15");

        all.get("12").child = all.get("16");

        String[] l31 = {"17", "18", "19"};
        BigListNode<String> l31H = makeLinkedListFrom(l31, all);
        all.get("13").child = l31H;

        all.get("15").child = all.get("20");

        String[] l32 = {"21", "22", "23"};
        BigListNode<String> l32H = makeLinkedListFrom(l32, all);
        all.get("16").child = l32H;

        all.get("20").child = all.get("24");


        Pair<BigListNode<String>, String[]> result = new Pair<>(head, expectedResult);
        return result;
    }

    private static BigListNode<String> makeLinkedListFrom(String[] arr,
                                                          Map<String, BigListNode<String>> all) {

        assert arr.length != 0;
        BigListNode<String> head = all.get(arr[0]);
        BigListNode<String> temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = all.get(arr[i]);
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }

    public static Pair<BigListNode<String>, String[]> generateFlatBigList(int size) {

        String[] result = new String[size];
        BigListNode<String> head = null;
        BigListNode<String> traverser = null;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                head = new BigListNode<>(String.valueOf(i));
                traverser = head;
            } else {
                traverser.next = new BigListNode<>(String.valueOf(i));
                traverser = traverser.next;
            }
            result[i] = String.valueOf(i);
        }

        return new Pair<>(head, result);
    }

    public static SiblingListNode<String> generateRandomSiblingList(int size) {

        Map<String, SiblingListNode<String>> allNodes = new HashMap<>(size);
        SiblingListNode<String> head = null;
        SiblingListNode<String> traverser = null;

        //first create a gnereal linked list
        for (int i = 0; i < size; i++) {
            String nodeValue = String.valueOf(i);
            if (i == 0) {
                head = new SiblingListNode<>(nodeValue);
                traverser = head;
            } else {
                traverser.next = new SiblingListNode<>(nodeValue);
                traverser = traverser.next;
            }
            allNodes.put(nodeValue, traverser);
        }

        //now randomly select siblings
        //size is size+1 so that we can get the possiblity of getting null
        int[] randomInts = new Random().ints(0, size + 1).limit(size).toArray();
        int i = 0;
        for (SiblingListNode<String> node : allNodes.values()) {
            SiblingListNode<String> sibling = null;
            if (i < randomInts.length) {
                int index = randomInts[i];
                i++;
                String indexStr = String.valueOf(index);
                if (allNodes.containsKey(indexStr)) {
                    sibling = allNodes.get(indexStr);
                }

            }
            node.sibling = sibling;
        }

        return head;
    }
}
