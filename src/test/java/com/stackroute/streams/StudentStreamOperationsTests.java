package com.stackroute.streams;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.hamcrest.MatcherAssert.assertThat;

public class StudentStreamOperationsTests {
    private StudentStreamOperations studentStreamOperations;
    private StudentStreamOperations studentStreamOperationsEmptyList;
    private List<Student> studentList1;

    private StudentStreamOperations studentStreamOperationsMale;

    private StudentStreamOperations studentStreamOperationsFemale;

    private List<Student> maleStudents;

    private List<Student> femaleStudents;
    private Student student1;

    private static final String MSG_1 = "should check that student names are available as comma separated string";
    private static final String MSG_2 = "should check that the list is empty";
    private static final String MSG_3 = "should check female list with percentage bigger than 85.0";

    private static final String MSG_17 = "shoud check female list with percentage bigger than 91.0";

    private static final String MSG_4 = "should check that the list is empty";

    private static final String MSG_5 = "should check for a list of student names sorted by percent in descending order";

    private static final String MSG_6 = "should check for a list of null student names sorted by percent in descending order";

    private static final String MSG_7 = "should check for a student name with highest percent";

    private static final String MSG_8 = "should check for an empty list for student name with highest percent";

    private static final String MSG_9 = "should check for the average percent of male student";

    private static final String MSG_10 = "should check for the average percent of male student in case of a null students list";

    private static final String MSG_11 = "should check for a map with name as key and percent as value";

    private static final String MSG_12 = "should check for a map with name as key and percent as value in case of a null students list";

    private static final String MSG_13 = "should check for a map with gender as key and list of student names as value";

    private static final String MSG_14 = "should check for a map with gender as key and list of student names as value when the students list is null";

    private static final String MSG_15 = "should check for the total number of male students";

    private static final String MSG_16 = "should check for the total number of male students when the list of students is null";

    private static final String MSG_18 = "should check for the average percent of male student in case of a female students list";

    private static final String MSG_19 = "should check that the list is full of boys";

    private static final String MSG_20 = "check for the total number of male students when the list is full of females";

    private static final String MSG_21 = "shoud check female list with percentage bigger than 99.0";

    private static final String MSG_22 =  "check for a map with gender as key and list of student names as value when the list of students is full of males";


    @BeforeEach
    public void setUp()  {

        student1 = new Student("Dragos", "M", 85.0);

        studentStreamOperations = new StudentStreamOperations();
        studentStreamOperationsEmptyList = new StudentStreamOperations();
        studentStreamOperationsFemale = new StudentStreamOperations();
        studentStreamOperationsMale = new StudentStreamOperations();

        femaleStudents = studentStreamOperationsFemale.getStudentList();
        femaleStudents.add(new Student("Maria", "F", 90.0));
        femaleStudents.add(new Student("Andra", "F", 92.0));
        maleStudents = studentStreamOperationsMale.getStudentList();
        maleStudents.add(new Student("Dragos", "M", 85.0));
        maleStudents.add(new Student("David", "M", 70.0));
        studentList1 = studentStreamOperations.getStudentList();
        studentList1.add(student1);
        studentList1.add(new Student("Maria", "F", 90.0));
        studentList1.add(new Student("Andra", "F", 92.0));
        studentList1.add(new Student("David", "M", 70.0));
    }

    @AfterEach
    public void tearDown() {
        studentStreamOperations = null;
        studentStreamOperationsEmptyList = null;
        studentStreamOperationsMale = null;
        studentStreamOperationsFemale = null;
    }

    //should check that student names are available as comma separated string

    @Test
    public void checkStudentNamesAreCommaSeparated() {
        assertThat(MSG_1, studentStreamOperations.getStudentNamesAsCommaSeparatedString(), is("Dragos, Maria, Andra, David"));
    }

    //should check that the list is empty

    @Test
    public void checkStudentNamesAreNull() {
        assertThat(MSG_2, studentStreamOperationsEmptyList.getStudentNamesAsCommaSeparatedString(),
                is(""));
    }

    // should check for a list of female student names whose percent is higher than the given percent
    @Test
    public void checkFemaleStudentNamesPercentageHigherThanGivenPercent() {
        assertThat(MSG_3, studentStreamOperations.getFemaleStudentNamesListWithHigherPercentage(85.0),
                is(List.of("Maria", "Andra")));

        assertThat(MSG_17, studentStreamOperations.getFemaleStudentNamesListWithHigherPercentage(91.0),
                is(List.of("Andra")));

        assertThat(MSG_21, studentStreamOperations.getFemaleStudentNamesListWithHigherPercentage(99.0),
                is(new ArrayList<>()));
    }

    @Test
    public void checkFemaleStudentNamesPercentageHigherThanGivenPercentWhenTheStudentsListIsFullOfMales() {
        assertThat(MSG_19, studentStreamOperationsMale.getFemaleStudentNamesListWithHigherPercentage(60.0),
                is(new ArrayList<>()));
    }

    @Test
    public void checkMaleStudentNamesPercentageLowerThanGivenPercent() {
        assertThat(MSG_4, studentStreamOperations.getFemaleStudentNamesListWithHigherPercentage(74.0),
                is(new ArrayList<>()));
    }

    //should check for a list of student names sorted by percent in descending order

    @Test
    public void checkStudentNamesListSortedByPercentageInDescendingOrder(){
        assertThat(MSG_5, studentStreamOperations.getStudentNamesListSortedByPercentageInDescendingOrder(),
                equalTo(List.of("Andra", "Maria", "Dragos", "David")));
    }

    @Test
    public void checkNullStudentNamesListSortedByPercentageInDescendingOrder(){
        assertThat(MSG_6, studentStreamOperationsEmptyList.getStudentNamesListSortedByPercentageInDescendingOrder(),
                is(new ArrayList<>()));
    }

    // should check for a student name with highest percent

    @Test
    public void checkStudentNameWithHighestPercent() {
        Optional<Student> student = Optional.of(new Student("Andra", "F", 92d));
        assertThat(MSG_7, studentStreamOperations.getStudentWithMaxPercent(),
                is(student));
    }

    @Test
    public void checkEmptyListStudentNameWithHighestPercent() {
        assertThat(MSG_8, studentStreamOperationsEmptyList.getStudentWithMaxPercent(),
                is(Optional.empty()));
    }

    // should check for the average percent of male student

    @Test
    public void checkForTheAveragePercentOfMaleStudent() {
        assertThat(MSG_9, studentStreamOperations.getAveragePercentageOfMaleStudents(),
                is(77.5d));
    }

    @Test
    public void checkForTheAveragePercentOfMaleStudentInCaseThatTheListIsFullOfFemales() {
        assertThat(MSG_18, studentStreamOperationsFemale.getAveragePercentageOfMaleStudents(),
                is(0.0d));
    }

    @Test
    public void checkForTheAveragePercentOfMaleStudentCaseNullList() {
        assertThat(MSG_10, studentStreamOperationsEmptyList.getAveragePercentageOfMaleStudents(),
                is(0.0d));
    }

    // should check for a map with name as key and percent as value

    @Test
    public void checkForAMapWithNameAsKeyAndPercentAsValue() {
        assertThat(MSG_11, studentStreamOperations.getStudentMapWithNameAsKeyAndPercentAsValue()
                    ,is(Map.of("Andra", 92.0, "Dragos", 85.0, "David",70.0,"Maria",90.0)));
    }

    @Test
    public void checkForAMapWithNameAsKeyAndPercentAsValueForAnEmptyList() {
        assertThat(MSG_12, studentStreamOperationsEmptyList.getStudentMapWithNameAsKeyAndPercentAsValue()
                ,is(new HashMap<>()));
    }

    // should check for a map with gender as key and list of student names as value

    @Test
    public void checkForAMapWithGenderAsKeyAndListOfStudentNamesAsValue() {
        assertThat(MSG_13, studentStreamOperations.getStudentMapWithGenderAsKeyAndStudentNamesListAsValues(),
                is(Map.of("F", List.of("Maria", "Andra"),"M", List.of("Dragos", "David"))));
    }

    @Test
    public void checkForAMapWithGenderAsKeyAndListOfStudentNamesAsValueWhenTheListOfStudentsIsEmpty() {
        assertThat(MSG_14, studentStreamOperationsEmptyList.getStudentMapWithGenderAsKeyAndStudentNamesListAsValues()
                        ,is(new HashMap<>()));
    }

    @Test
    public void checkForAMapWithGenderAsKeyAndListOfStudentNamesAsValueWhenTheListOfStudentsIsFullOfMales() {
        assertThat(MSG_22, studentStreamOperationsMale.getStudentMapWithGenderAsKeyAndStudentNamesListAsValues()
                        , is(Map.of("M", List.of("Dragos", "David"))));
    }

    //should check for the total number of male students

    @Test
    public void checkForTheTotalNumberOfMaleStudents() {
        assertThat(MSG_15,  studentStreamOperations.getMaleStudentsCount()
                        , is(2L));
    }

    @Test
    public void checkForTheTotalNumberOfMaleStudentsWhenTheListIsFullOfFemales() {
        assertThat(MSG_20, studentStreamOperationsFemale.getMaleStudentsCount()
                    , is(0L));
    }
    @Test
    public void checkForTheTotalNumberOfMaleStudentsWhenTheStudentsListIsNull() {
        assertThat(MSG_16,  studentStreamOperationsEmptyList.getMaleStudentsCount()
                , is(0L));
    }

}
