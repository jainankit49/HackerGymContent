package com.hackergym.samples.linkedlist.model;

/**
 * Created by Fathalian on 6/16/14.
 * HackerGym.com
 */
public class Pair <A,B> {

    public A fst;
    public B snd;
    public Pair(A first, B second) {
        this.fst = first;
        this.snd = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (!fst.equals(pair.fst)) return false;
        if (!snd.equals(pair.snd)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fst.hashCode();
        result = 31 * result + snd.hashCode();
        return result;
    }

    public String toString() {
        return "( " + fst + ", " + snd +" )";
    }
}
