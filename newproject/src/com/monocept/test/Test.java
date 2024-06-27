package com.monocept.test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import com.monocept.model.*;

public class Test {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
////		System.out.println("Main method");
////        Derived d = new Derived();   
////
////		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
////		OptionalDouble average = numbers.stream()
////		                                        .filter(n -> n % 3 == 0)
////		                                        .mapToInt(n -> n)
////		                                        .average();
////		System.out.println(average.isPresent() ? average.getAsDouble() : "No average");
//		
//		Integer a = 128;
//        Integer b = 128;
//        int c = 128;
//        int d = 128;
//       
//        System.out.println(a == b);
//        System.out.println(a == c);
//        System.out.println(c == d);
//	}
	
	public static void main(String[] args) {
        try {
            System.out.print("Inside try block");
            methodA();
        } catch (Exception e) {
            System.out.print("Caught Exception: " + e.getMessage());
        } finally {
            System.out.print("Inside finally block");
        }
    }
   
    public static void methodA() {
        System.out.print("Inside methodA");
        methodB();
    }
   
    public static void methodB() {
        System.out.print("Inside methodB");
        throw new ArithmeticException("Custom ArithmeticException");
    }

}
