package com.stackroute.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StudentStreamOperations {

    private List<Student> studentList;

    public StudentStreamOperations() {
        studentList = new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return this.studentList;
    }

    /*
     * Given the student list, returns the name of all the students as comma separated string
     */
    public String getStudentNamesAsCommaSeparatedString() {
        if (studentList == null || studentList.isEmpty()) {
            return "";
        }
        return studentList.stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
    }

    /*
     * Given the student list, returns the female student names list whose percentage is greater than the given upper limit
     */
    public List<String> getFemaleStudentNamesListWithHigherPercentage(double upperPercentLimit) {
        if (studentList == null || upperPercentLimit <= 75.0) {
            return new ArrayList<>();
        }
        return studentList.stream()
                .filter(student -> student.getPercentage() >= upperPercentLimit && student.getGender().equals("F"))
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    /*
     * Given the student list, returns the student name list sorted by percent in descending order
     */
    public List<String> getStudentNamesListSortedByPercentageInDescendingOrder() {
        if (studentList == null) {
            return new ArrayList<>();
        }
        return studentList.stream()
                .sorted(Comparator.comparing(Student::getPercentage).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    /*
     * Given the student list returns the student who got the highest percent
     */
    public Optional<Student> getStudentWithMaxPercent() {
        if (studentList == null) {
            return Optional.empty();
        }
        return studentList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getPercentage)));
    }

    /*
     * Given the student list, returns the average percent of male students
     */

    public Double getAveragePercentageOfMaleStudents() {
        if (studentList == null) {
            return 0.0;
        }
        return studentList.stream()
                .filter(student -> student.getGender().equals("M"))
                .collect(Collectors.averagingDouble(Student::getPercentage));
    }
    /*
     *Given the student list, returns the student map with name as key and percent as value
     */

    public Map<String, Double> getStudentMapWithNameAsKeyAndPercentAsValue() {
        if (studentList == null) {
            return new HashMap<>();
        }
        return studentList.stream()
                .collect(Collectors.toMap(Student::getName, Student::getPercentage));
    }

    /*
     * Given the student list, returns the student map with gender as key and name list as value
     */

    public Map<String, List<String>> getStudentMapWithGenderAsKeyAndStudentNamesListAsValues() {
        if (studentList == null) {
            return new HashMap<>();
        }
        return studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.mapping(Student::getName, Collectors.toList())));
    }
    /*
     * Given the student list, returns the number of male students
     */

    public long getMaleStudentsCount(){
        if (studentList == null) {
            return 0;
        }
        return studentList.stream()
                .filter(student->student.getGender().equals("M"))
                .count();
    }
}
