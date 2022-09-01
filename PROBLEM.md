## Problem Statement: Writing unit test cases for the given solution ##

**This exercise should be completed by writing unit test cases for the solution provided**

- Below is the summary of the solution provided
    - class `Student` is a POJO class
    - class `StudentStreamOperations` has stream operations related to list of students
         
- Create class `StudentTests` in package `com.stackroute.streams` 

        - should check for the creation of Student object with all properties being set properly.
        - Minimum test cases expected : 4  

- Create class `StudentStreamOperationsTests` in package `com.stackroute.streams` 

       - should check that student names are available as comma separated string
       - should check for a list of female student names whose percent is higher than the given percent
       - should check for a list of student names sorted by percent in descending order 
       - should check for a student name with highest percent
       - should check for the average percent of male student
       - should check for a map with name as key and percent as value
       - should check for a map with gender as key and list of student names as value
       - should check for the total number of male students
       - Minimum test cases expected : 22
     
- Each test case can have multiple assert checking.

- Test cases should be written for positive, negative and boundary scenarios, wherever applicable

- Test coverage should be 100%

## Instructions
- Avoid printing unnecessary values other than expected output as given in sample
- Take care of whitespace/trailing whitespace
- Do not change the provided class/method names unless instructed
- Follow best practices while coding
