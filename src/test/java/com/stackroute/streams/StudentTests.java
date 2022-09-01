package com.stackroute.streams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

public class StudentTests {

    private static final String MSG_01 = "check the constructor for proper initialization of properties";
    private static final String MSG_02 = "check the setter for proper assignment of property values";
    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student("Dragos", "male", 95);
    }

    @AfterEach
    public void tearDown() {
        student = null;
    }

    @Test
    public void givenStudentNameAttributeWhenObjectCreatedThenTheAttributeIsSet() {
        assertThat(MSG_01, student, hasProperty("name", is("Dragos")));
    }

    @Test
    public void givenStudentGenderAttributeWhenObjectCreatedThenTheAttributeIsSet() {
        assertThat(MSG_01, student, hasProperty("gender", is("male")));
    }

    @Test
    public void givenStudentPercentageAttributeWhenObjectCreatedThenTheAttributeIsSet() {
        assertThat(MSG_01, student, hasProperty("percentage", is(95d)));
    }

    @Test
    public void givenStudentObjectWhenPropertyValuesModifiedToEmptyDefaultThenPropertiesAreSet() {
        student = new Student("", "", 0);
        assertThat(MSG_02, student.getGender(), is(""));
        assertThat(MSG_02, student.getName(), is(""));
        assertThat(MSG_02, student.getPercentage(), is(0d));
    }

}
