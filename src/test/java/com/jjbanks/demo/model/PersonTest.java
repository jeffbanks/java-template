package com.jjbanks.demo.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

public class PersonTest {

    @Test
    public void init() {

        Person person = new Person("Wade", "Watts");

        assertEquals("Wade", person.getFirstName());
        assertEquals("Watts", person.getLastName());
    }

    @Test
    public void identity() {

        Person person1 = new Person("Wade", "Watts");
        Person person2 = new Person("Wade", "Watts");
        Person person3 = new Person("Wade", "Johnson");
        Person person4 = new Person("Jade", "Watts");
        Person person5 = new Person(null, "Watts");
        Person person6 = new Person("Jade", null);

        Object notAPerson = new Object();
        assertNotSame(person1, person2);
        assertNotSame(person1, person3);
        assertNotSame(null, notAPerson);
        assertEquals(person1.hashCode(), person2.hashCode());
        assertEquals(person1.hashCode(), person1.hashCode());
        assertNotEquals(null, person3.hashCode());
        assertEquals(person1, person1);
        assertEquals(person1.toString(), person2.toString());






    }
}
