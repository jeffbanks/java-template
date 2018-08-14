package com.jjbanks.demo.model;

import com.jjbanks.demo.service.PeopleService;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PeopleServiceTest {

    private List<Person> people;

    @Before
    public void setup() {

        people = new ArrayList<>();
        people.add(new Person("Jim", "Hendrix"));
        people.add(new Person("Wade", "Watts"));
        people.add(new Person("Mike", "Watts"));
        people.add(new Person("Jim", "Canon"));
        people.add(new Person("Dale", "Watts"));
    }

    @Test
    public void processByLastName() {

        final String lastName = "Watts";
        PeopleService service = new PeopleService();

        List<Person> filteredPeople = service.processByLastName(people, lastName);
        assertNotNull(filteredPeople);
        assertEquals(3, filteredPeople.size());

        long count = filteredPeople.stream()
                .filter(n -> n.getLastName().equalsIgnoreCase(lastName))
                .count();
        assertEquals(3, count);
    }

    @Test(expected = NullPointerException.class)
    public void processByLastNameWithNullPeople() {

        final String lastName = "Watts";
        PeopleService service = new PeopleService();
        service.processByLastName(null, lastName);
    }

    @Test(expected = NullPointerException.class)
    public void processByLastNameWithNullName() {

        PeopleService service = new PeopleService();
        service.processByLastName(people, null);
    }

    @Test
    public void reportByFullName() {

        final String lastName = "Watts";
        PeopleService service = new PeopleService();
        List<Person> filteredPeople = service.processByLastName(people, lastName);
        service.reportByFullName(filteredPeople);
    }

    @Test(expected = NullPointerException.class)
    public void reportByFullNameNull() {
        PeopleService service = new PeopleService();
        service.reportByFullName(null);
    }
}
