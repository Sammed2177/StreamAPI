package Comparator;

import java.util.ArrayList;
import java.util.Collections;

// Comparable Example
public class ComparableExample {

    public static void main(String[] args) {

        ArrayList employees = new ArrayList<>();
        employees.add(new Employee(1, "sammed", "TECH"));
        employees.add(new Employee(5, "sumit", "HR"));
        employees.add(new Employee(3, "kunal", "TECH"));
        employees.add(new Employee(2, "suraj", "FINANCE"));
        employees.add(new Employee(5, "kiran", "MARKETING"));

        // If we want to sort the based on the natural sorting order we can go for comparable
        // for that we need to implement comparable interface in the employee class and override compareTo method
        System.out.println(employees);
        // sorting using collections class
        Collections.sort(employees);
        System.out.println(employees);

        // above code is used when you want to sort the collection according to single comparison logic
        // i.e. You only want to compare according to the id, name, department
    }
}
