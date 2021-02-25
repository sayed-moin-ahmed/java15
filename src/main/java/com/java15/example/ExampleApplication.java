package com.java15.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Stream;

/**
 *
 */
@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {

		//extracted();
	}

	private static void extracted() {
		Employee employee1 = new Employee(1,"sam");
		Employee employee2 = new Employee(2,"rock");
		List<Employee> list = new ArrayList<Employee>();
		list.add(employee1);
		list.add(employee1);
		System.out.println("list"+list);
		Set<Employee> set = new HashSet<Employee>();
		set.add(employee1);
		set.add(employee2);
		System.out.println("set"+set);
		Map<Employee,Integer> map = new HashMap<>();
		map.put(employee1,1);
		map.put(employee2,2);
		System.out.println("map"+map);
		Stream stream = list.parallelStream().map(Employee::getId).peek(e->System.out.println("eager"+e));
		System.out.println("Lazy");
		stream.forEach(System.out::println);
	}

}
class Employee {
	private int id;
	private String name;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return id == employee.id && Objects.equals(name, employee.name);
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
