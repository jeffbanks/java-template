package com.jjbanks.demo.model;

import lombok.Value;

@Value
public class Person {
    private String firstName;
    private String lastName;

    /**
     * @param firstName first name identity
     * @param lastName  last name identity
     */
    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
