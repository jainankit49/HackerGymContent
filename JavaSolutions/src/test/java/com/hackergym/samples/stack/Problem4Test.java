package com.hackergym.samples.stack;

import com.hackergym.samples.model.Element;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Problem4Test {

    Problem4 problem4 = new Problem4();
    @Test
    public void testGetQueueStackTwoStack() throws Exception {

        Problem4.QueueStack queue = problem4.getQueueStackTwoStack();

        assertThat(queue.isEmpty(), is(true));
        queue.enqueue(new Element("1"));
        queue.enqueue(new Element("2"));
        queue.enqueue(new Element("3"));
        queue.enqueue(new Element("4"));

        assertThat(queue.isEmpty(), is(false));

        assertThat(queue.dequeue().getValue(), is("1"));
        assertThat(queue.dequeue().getValue(), is("2"));
        queue.enqueue(new Element("5"));
        assertThat(queue.dequeue().getValue(), is("3"));
        assertThat(queue.dequeue().getValue(), is("4"));
        assertThat(queue.dequeue().getValue(), is("5"));


        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testGetQueueStackTwoStackOptimized() throws Exception {

        Problem4.QueueStack queue = problem4.getQueueStackTwoStackOptimized();

        assertThat(queue.isEmpty(), is(true));
        queue.enqueue(new Element("1"));
        queue.enqueue(new Element("2"));
        queue.enqueue(new Element("3"));
        queue.enqueue(new Element("4"));

        assertThat(queue.isEmpty(), is(false));

        assertThat(queue.dequeue().getValue(), is("1"));
        assertThat(queue.dequeue().getValue(), is("2"));
        queue.enqueue(new Element("5"));
        assertThat(queue.dequeue().getValue(), is("3"));
        assertThat(queue.dequeue().getValue(), is("4"));
        assertThat(queue.dequeue().getValue(), is("5"));


        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testGetQueueStackCustom() throws Exception {

        Problem4.QueueStack queue = problem4.getQueueStackCustom();

        assertThat(queue.isEmpty(), is(true));
        queue.enqueue(new Element("1"));
        queue.enqueue(new Element("2"));
        queue.enqueue(new Element("3"));
        queue.enqueue(new Element("4"));

        assertThat(queue.isEmpty(), is(false));

        assertThat(queue.dequeue().getValue(), is("1"));
        assertThat(queue.dequeue().getValue(), is("2"));
        queue.enqueue(new Element("5"));
        assertThat(queue.dequeue().getValue(), is("3"));
        assertThat(queue.dequeue().getValue(), is("4"));
        assertThat(queue.dequeue().getValue(), is("5"));


        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void testGetQueueStackCustomOptimizedMultipleDequeues() throws Exception {

        Problem4.QueueStack queue = problem4.getQueueStackCustomOptimized();

        assertThat(queue.isEmpty(), is(true));
        queue.enqueue(new Element("1"));
        queue.enqueue(new Element("2"));
        queue.enqueue(new Element("3"));
        queue.enqueue(new Element("4"));

        assertThat(queue.isEmpty(), is(false));

        assertThat(queue.dequeue().getValue(), is("1"));
        assertThat(queue.dequeue().getValue(), is("2"));
        queue.enqueue(new Element("5"));
        assertThat(queue.dequeue().getValue(), is("3"));
        assertThat(queue.dequeue().getValue(), is("4"));
        assertThat(queue.dequeue().getValue(), is("5"));


        assertThat(queue.isEmpty(), is(true));
    }
}