package com.hackergym.samples.model;

/**
 * Created by Fathalian on 7/28/14.
 * HackerGym.com
 */
public class Element {

    public static Element[] fromStringArray(String[] strings) {
        Element[] elements = new Element[strings.length];
        for(int i = 0 ; i < elements.length; i++) {
            elements[i] = new Element(strings[i]);
        }
        return elements;
    }

    private final String value;

    public Element(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        if (value != null ? !value.equals(element.value) : element.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Element{" +
                "value='" + value + '\'' +
                '}';
    }
}
