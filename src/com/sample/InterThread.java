package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

class Q{
	int num;
	boolean valueSet = false;
	
	public synchronized void get()
	{
		while(!valueSet){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("get: " +num);
		valueSet=false;
		notify();
		
	}
	public synchronized void put(int value){
		while(valueSet){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.num=value;
		System.out.println("put: " +num);
		valueSet=true;
		notify();
	}
}

class Producer implements Runnable{
	Q q;
  
	
	Producer(Q q){
		this.q=q;
		
		
	}
	
	@Override
	public void run() 
	{
		int i=0;
		for(int j=0;j<5;j++){
			q.put(i++);
			
		
		}
		
		
	}
	
}

class Consumer implements Runnable{
	Q q;
  
	
	Consumer(Q q){
		this.q=q;
		
		
	}
	
	@Override
	public void run() 
	{
		
		for(int j=0;j<5;j++)
		{
			q.get();
			
			
		}
		
		
	}
	
}

public class InterThread {
	
	public static void main(String[] args) throws InterruptedException{
		/*Q q = new Q();
		
		
		
    Thread t1 = new Thread(new Producer(q),"Prodcuer");
    Thread t2 = new Thread(new Consumer(q),"Consumer");
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println("The end");
		
		Parent p = new Child();
		p.show();
	    System.out.println(p.i);
	    String s= "manoj";*/
		/*Set<Employee> s2 = new HashSet<>();
		Employee e1 = new Employee(1,"Manoj");
		Map<Employee,String> s1= new HashMap<>();
		Employee e2 = new Employee(1,"Manoj");
	    s2.add(e1);
	    s2.add(e2);
	    System.out.println(s2);
	    
	    s1.put(e1, "manoj");
	    s1.put(e2, "raghu");
	    System.out.println(s1.get(e2));*/
		Sample s = new Sample();
		//System.out.println(s.get());
		Employee e1 = new Employee(1,"Manoj","HR","male",1000.00);
		Employee e2 = new Employee(2,"Raghu","engineer","male",500.00);
		Employee e3 = new Employee(0,"Aman","HR","female",1500.00);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		/*Map<String, Long>count=employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		
		for(Map.Entry<String, Long> e:count.entrySet())
		{
			System.out.println(e.getKey()+" "+e.getValue());
		}*/
		
	List<String> names=	employees.stream().filter(e->e.getName().length()>2).map(e->e.getName()).distinct().collect(Collectors.toList());
		
		/*List<Employee> lis=employees.stream().sorted((e5, e6)-> 
		{
			if(e5.getNumber()>e6.getNumber())
				return 1;
			else
				return -1;
			
				
		}).collect(Collectors.toList());
		
		
		
 
		
		System.out.println(lis.get(1));*/
		
	Optional<Employee> emp1= employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
	
	System.out.println(emp1.get());
	
	Map<String,Long> countDepartment=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
	    
	for(Map.Entry<String,Long> e :  countDepartment.entrySet()) 
	{
		System.out.println(e.getKey() +":"+ e.getValue());
	}
	
	
	}
}
