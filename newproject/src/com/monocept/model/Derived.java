package com.monocept.model;

public class Derived extends Base{
	
	static {
        System.out.println("Derived static block");
    }
   
    public Derived() {
        System.out.println("Derived constructor");
    }

}
