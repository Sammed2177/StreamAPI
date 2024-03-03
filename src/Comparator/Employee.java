package Comparator;

import java.util.Comparator;
import java.util.EnumMap;

public class Employee implements Comparable<Employee> {

    private Integer id;

    private String name;

    private String department;

    public Employee(Integer id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    // comparison based on the employeeId
//    @Override
//    public int compareTo(Employee other) {
//        return Integer.compare(this.id, other.getId());
//    }

    @Override
    public int compareTo(Employee e){
        return this.getName().compareTo(e.getName());
    }
}
