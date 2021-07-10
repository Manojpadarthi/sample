package com.sample;

interface Junior{
	void show();
}
public class Parent implements Junior
{
	int i=10;
  Parent(){
	  System.out.println("parent class");
  }
   public void show(){
	  System.out.println("inside parent");
  }
}
class Child extends Parent  
{
	
	int i=20;
	Child(){
		System.out.println("child class");
	}
	@Override
	 public void show(){
		 //super.show();
		  System.out.println("inside child");
	  }
	
	public void m1(){
		System.out.println("Inside child");
	}
}