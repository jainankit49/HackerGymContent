package com.hackergym.samples.stack;

import com.hackergym.samples.model.Element;
import com.hackergym.samples.tree.StringNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem7Test {

    Problem7 solver = new Problem7();

    @Test
    public void testPrintGenerationsCustom() throws Exception {

        StringNode node = createGenerationTree();
        List<String> result = solver.printGenerationsCustom(node);
        List<String> expected = Arrays.asList("Jay", "Mike", "Rob", "Pete", "Bob", "Joe", "George", "Gordon", "Paul");
        System.out.println(result);

        assertThat(result, is(expected));
    }

    @Test
    public void testPrintGenerationsCustomFullTree() throws Exception {
        StringNode node = createGenerationTreeTwoChild();
        List<String> result = solver.printGenerationsCustom(node);
        List<String> expected = Arrays.asList(
                "Jay",
                "Mike", "Rob",
                "Pete", "Bob", "Joe", "Sam",
                "Sam", "Frodo", "Gandalf", "Pastor", "Shangool", "Mangool", "HappeAngor", "Alice");

        System.out.println(result);
        assertThat(result, is(expected));
    }

    @Test
    public void testPrintGenerationsCustomSingleChild() throws Exception {

        StringNode node = createGenerationTreeSingleChild();
        List<String> result = solver.printGenerationsCustom(node);
        List<String> expected = Arrays.asList(
                "Jay",
                "Mike",
                "Mark",
                "Nigel",
                "Gary",
                "Mortog");
        System.out.println(result);

        assertThat(result, is(expected));
    }

    @Test
    public void testPrintGenerations() throws Exception {

        StringNode node = createGenerationTree();
        List<String> result = solver.printGenerations(node);
        List<String> expected = Arrays.asList("Jay", "Mike", "Rob", "Pete", "Bob", "Joe", "George", "Gordon", "Paul");

        System.out.println(result);
        System.out.println(expected);
        assertThat(result, is(expected));
    }

    @Test
    public void testPrintGenerationsFullTree() throws Exception {

        StringNode node = createGenerationTreeTwoChild();
        List<String> result = solver.printGenerations(node);
        List<String> expected = Arrays.asList(
                "Jay",
                "Mike", "Rob",
                "Pete", "Bob", "Joe", "Sam",
                "Sam", "Frodo", "Gandalf", "Pastor", "Shangool", "Mangool", "HappeAngor", "Alice");

        System.out.println(result);
        System.out.println(expected);
        assertThat(result, is(expected));
    }

    @Test
    public void testPrintGenerationsSingleChild() throws Exception {
        StringNode node = createGenerationTreeSingleChild();
        List<String> result = solver.printGenerations(node);
        List<String> expected = Arrays.asList(
                "Jay",
                "Mike",
                "Mark",
                "Nigel",
                "Gary",
                "Mortog");
        System.out.println(result);

        assertThat(result, is(expected));

    }

    @Test
    public void testPrintGenerationsSeparator() throws Exception {

        StringNode node = createGenerationTree();
        List<String> result = solver.printGenerationsSeparator(node);
        List<String> expected = Arrays.asList("Jay", "\n", "Mike", "Rob","\n", "Pete", "Bob", "Joe", "\n", "George", "Gordon", "Paul");
        System.out.println(result);

        assertThat(result, is(expected));
    }


    @Test
    public void testPrintGenerationsSeparatorFullTree() throws Exception {

        StringNode node = createGenerationTreeTwoChild();
        List<String> result = solver.printGenerationsSeparator(node);
        List<String> expected = Arrays.asList(
                "Jay", "\n",
                "Mike", "Rob","\n",
                "Pete", "Bob", "Joe", "Sam", "\n",
                "Sam", "Frodo", "Gandalf", "Pastor", "Shangool", "Mangool", "HappeAngor", "Alice");

        System.out.println(result);

        assertThat(result, is(expected));
    }

    @Test
    public void testPrintGenerationsSeparatorSingleChild() throws Exception {

        StringNode node = createGenerationTreeSingleChild();
        List<String> result = solver.printGenerationsSeparator(node);
        List<String> expected = Arrays.asList(
                "Jay", "\n",
                "Mike", "\n",
                "Mark", "\n",
                "Nigel", "\n",
                "Gary", "\n",
                "Mortog");
        System.out.println(result);

        assertThat(result, is(expected));
    }

    @Test
    public void testPrintGenerationsCounters() throws Exception {

        StringNode node = createGenerationTree();
        List<String> result = solver.printGenerationsCounters(node);
        List<String> expected = Arrays.asList("Jay", "\n", "Mike", "Rob","\n", "Pete", "Bob", "Joe", "\n", "George", "Gordon", "Paul");
        System.out.println(result);
        System.out.println(expected);

        assertThat(result, is(expected));
    }

    @Test
    public void testPrintGenerationsCountersFullTree() throws Exception {

        StringNode node = createGenerationTreeTwoChild();
        List<String> result = solver.printGenerationsCounters(node);
        List<String> expected = Arrays.asList(
                "Jay", "\n",
                "Mike", "Rob","\n",
                "Pete", "Bob", "Joe", "Sam", "\n",
                "Sam", "Frodo", "Gandalf", "Pastor", "Shangool", "Mangool", "HappeAngor", "Alice");
        System.out.println(result);

        assertThat(result, is(expected));
    }

    @Test
    public void testPrintGenerationsCountersSingleChild() throws Exception {

        StringNode node = createGenerationTreeSingleChild();

        List<String> result = solver.printGenerationsCounters(node);
        List<String> expected = Arrays.asList(
                "Jay", "\n",
                "Mike", "\n",
                "Mark", "\n",
                "Nigel", "\n",
                "Gary", "\n",
                "Mortog");
        System.out.println(result);

        assertThat(result, is(expected));
    }

    private StringNode createGenerationTree() {
        StringNode node = new StringNode(new Element("Jay"));
        node.left = new StringNode(new Element("Mike"));
        node.right = new StringNode(new Element("Rob"));

        node.left.left = new StringNode(new Element("Pete"));
        node.left.right = new StringNode(new Element("Bob"));
        node.left.right.left = new StringNode(new Element("George"));

        node.right.right = new StringNode(new Element("Joe"));
        node.right.right.left = new StringNode(new Element("Gordon"));
        node.right.right.right = new StringNode(new Element("Paul"));
        //["Jay",
        // "Mike", "Rob",
        // "Pete", "Bob", "Joe"
        // "George", "Gordon", "Paul"]

        return node;
    }

    private StringNode createGenerationTreeSingleChild() {
        StringNode node = new StringNode(new Element("Jay"));
        node.left = new StringNode(new Element("Mike"));
        node.left.left = new StringNode(new Element("Mark"));
        node.left.left.left = new StringNode(new Element("Nigel"));
        node.left.left.left.left = new StringNode(new Element("Gary"));
        //they started marrying Orcs from here
        node.left.left.left.left.left = new StringNode(new Element("Mortog"));

        //["Jay",
        // "Mike,
        // "Mark",
        // "Nigel",
        // "Gary",
        // "Mortog"]
        return node;
    }

    private StringNode createGenerationTreeTwoChild() {

        //["Jay",
        // "Mike", "Rob",
        // "Pete", "Bob", "Joe", "Sam",
        // "Sam" , "Frodo", "Gandalf", "Pastor", "Shangool", "Mangoo", "HappeAngor", "Alice"
        StringNode node = new StringNode(new Element("Jay"));
        node.left = new StringNode(new Element("Mike"));
        node.right = new StringNode(new Element("Rob"));

        node.left.left = new StringNode(new Element("Pete"));
        node.left.right = new StringNode(new Element("Bob"));
        node.right.left = new StringNode(new Element("Joe"));
        node.right.right = new StringNode(new Element("Sam"));


        node.left.left.left = new StringNode(new Element("Sam"));
        node.left.left.right = new StringNode(new Element("Frodo"));
        node.left.right.left = new StringNode(new Element("Gandalf"));
        node.left.right.right = new StringNode(new Element("Pastor"));
        node.right.left.left = new StringNode(new Element("Shangool"));
        node.right.left.right = new StringNode(new Element("Mangool"));
        node.right.right.left = new StringNode(new Element("HappeAngor"));
        node.right.right.right = new StringNode(new Element("Alice"));

        return node;
    }
}