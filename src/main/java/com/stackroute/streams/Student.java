package com.stackroute.streams;

import java.util.Objects;

/*
 *This class contains three fields- name, gender and percentage
 */
public class Student {
    private String name;
    private String gender;
    private double percentage;

    /*
     *Parameterized constructor for initializing fields
     */
    public Student(String name, String gender, double percentage) {
        this.name = name;
        this.gender = gender;
        this.percentage = percentage;
    }

     /*
    Overridden toString() method for string representation of Student object
     */

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", percentage=" + percentage +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public double getPercentage() {
        return percentage;
    }

    //Overrides equals for checking the equality of student objects
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return Double.compare(student.percentage, percentage) == 0 &&
                name.equals(student.name) &&
                gender.equals(student.gender);
    }

    // Overrides hashcode which is mandatory when we override equals method
    @Override
    public int hashCode() {
        return Objects.hash(name, gender, percentage);
    }
}
