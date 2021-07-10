package com.sample;

interface Car{
	
	String getEngine(String name);
	
}
public class MethodReference 
{
  
	public static String getEngineName(String name){
		
		return name;
		
	}
	

	
	
	public static String get(Car car,String name){
		
		return car.getEngine(name);
	}
   public  String getTo(Car car,String name){
		
		return car.getEngine(name);
	}
	
	public static void main(String[] args)
	{   //lambda 
		System.out.println(MethodReference.get(name->MethodReference.getEngineName(name),"manoj"));
		
		//method refernce
		System.out.println(MethodReference.get(MethodReference::getEngineName,"manoj"));
	    
		System.out.println(new MethodReference().getTo(MethodReference::getEngineName,"ramu"));
	    
		//System.out.println(new MethodReference().getTo(MethodReference::getEngineName,"ramu"));
	}
}
