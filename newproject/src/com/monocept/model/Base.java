package com.monocept.model;

public class Base {
	
	static {
        System.out.println("Base static block");
    }
   
    public Base() {
        System.out.println("Base constructor");
    }

}
