package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorExample {

    public static void main(String[] args) {
        // in this class we will look in the example of comparator class based sorting

        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Employee(1, "sammed", "TECH"));
        employeeArrayList.add(new Employee(5, "kunal", "TECH"));
        employeeArrayList.add(new Employee(4, "sumit", "HR"));
        employeeArrayList.add(new Employee(2, "kiran", "MARKETING"));
        employeeArrayList.add(new Employee(3, "suraj", "FINANCE"));
        employeeArrayList.add(new Employee(null, "suraj", "FINANCE"));

        // we go for comparator when we have to sort the based on the multiple comparison logic
        // there are two methods by which we can do that
        // 1. By creating a class
        // Suppose I need to do comparison based on the employee name then I will create a class named nameComparator
        // Inside nameComparator will write the logic inside the overridden method compare();

        // System.out.println(employeeArrayList);

        // for sorting based on the employeeName we can call sort method on the collections class and pass collection object and comparator object as argument
        // Collections.sort(employeeArrayList, new NameComparator());

        System.out.println(employeeArrayList);

        // hence we can create comparator class based on the field on which I need to do comparison
        // but there is another way by which we achieve the same result
        // Lets look into it

        // 2
        // we can use comparing method of the comparator class
        // using this method we don't have to explicitly create a comparator class based the on the given key
        // this is very useful method when we are going to do a comparison on a particular key for only one time
        // comparing method takes "keyExtractor Function" argument
        // keyExtractor function is nothing but the method which will return a key or a value on which we need to perform sorting on

        // == Collections.sort(employeeArrayList, Comparator.comparing(Employee :: getId));
        // In above example we didn't have to create a IdComparator class explicitly

        // Besides only comparing method we have many methods which we can use they are listed bellow

        // thenComparing()
        // in this method when we have to perform some complex sorting operations such as first after sorting based on the id we have to do sorting based on the name
        // then we can use thenComparing() method
        // example
        // Collections.sort(employeeArrayList, Comparator.comparing(Employee :: getId).thenComparing(Employee :: getName));
        // using above method we can sort the collection based on the id first, and then we can sort it based on the name

        // handling nulls
        // nullsFirst() and nullsLast()
        // if our collection consist null values we can handle them using nullFirst() and nullLast() methods

        Collections.sort(employeeArrayList, Comparator.comparing(Employee::getId, Comparator.nullsFirst(Integer::compareTo)));
        // In this code, Comparator.comparing() is used along with Comparator.nullsLast() to ensure that null IDs are placed at the end of the sorted list.
        // We explicitly specify the comparator for comparing integers (Integer::compareTo) in case of null IDs
        // This should handle the null IDs properly during sorting and avoid the NullPointerException
        // similarly we can keep then at the last

        System.out.println(employeeArrayList);



    }

}
