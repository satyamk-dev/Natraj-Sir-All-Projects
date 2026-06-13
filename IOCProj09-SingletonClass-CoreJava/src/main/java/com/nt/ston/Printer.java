//Printer.java
package com.nt.ston;

public class Printer {
	  //private static  reference variable to hold that single object ref
  private static Printer INSTANCE;
   
  //Zero param cosntructor
  private  Printer() {
	  System.out.println("Printer:: 0-param constructor");
  }
  
  //public static factory method  having singleton logic
  public static  Printer    getInstance() {
	  //singleton logic
	  if(INSTANCE==null)
		  INSTANCE=new Printer();
	  return  INSTANCE;
  }
  
}
