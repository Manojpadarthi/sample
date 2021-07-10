package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Sample 
{
	/*public List<Integer> get(){
	List<Integer> l1 = Arrays.asList(1,2,3,4);
	List<Integer> l2 = Arrays.asList(1,2,3,4);
	
	List<List<Integer>> l3 = new ArrayList<>();
	l3.add(l2);
	l3.add(l1);
	
	List<Integer> l4=l3.parallelStream().flatMap(i->i.parallelStream()).map(i->i*2).collect(Collectors.toList());
	
	List<Integer> l5 = l1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	
	 return l5;
	  
	Map<Integer, Long> e =l3.parallelStream().flatMap(i->i.parallelStream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
	
	
	
	
	
	}*/
	
	
	
	
	
	
	
	
	

}


class Employee{
	int number;
	String name;
	String department;
	String gender;
	double Salary;
	
	

	
	
	
	public Employee(int number, String name, String department, String gender, double salary) {
		super();
		this.number = number;
		this.name = name;
		this.department = department;
		this.gender = gender;
		Salary = salary;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (Double.doubleToLongBits(Salary) != Double.doubleToLongBits(other.Salary))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [number=");
		builder.append(number);
		builder.append(", name=");
		builder.append(name);
		builder.append(", department=");
		builder.append(department);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", Salary=");
		builder.append(Salary);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
