package com.jjbanks.demo.service;

import com.jjbanks.demo.model.Person;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Sample service for people processing.
 */
public class PeopleService {

    private final static Logger logger = Logger.getLogger(PeopleService.class.getName());

    /**
     * @param people list to be processed
     * @param lastName target last name filter
     * @return list of people matching filtered by last name
     */
    public List<Person> processByLastName(List<Person> people, String lastName) {

        Validate.notNull(people);
        Validate.notNull(lastName);

        final List<Person> filteredPeople = new ArrayList<>();
        people.stream()
                .filter(p -> p.getLastName().equalsIgnoreCase(lastName))
                .forEach(filteredPeople::add);

        return filteredPeople;
    }

    /**
     * @param people target of the report
     */
    public void reportByFullName(List<Person> people) {

        Validate.notNull(people);
        people.forEach(person -> {
                    logger.info("Hello " +
                            person.getFirstName() +
                            " " +
                            person.getLastName() +
                            " glad to meet you!");
                }
        );
    }
}
