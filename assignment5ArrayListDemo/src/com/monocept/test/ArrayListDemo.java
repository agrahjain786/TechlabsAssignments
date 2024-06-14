package com.monocept.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.monocept.model.Person;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Person> arrayList = new ArrayList<Person>();
		System.out.println("How many persons you want add:(atleast 5) ");
		int numberOfPersons = scanner.nextInt();
		scanner.nextLine();
		
		for(int i=1;i<=numberOfPersons;i++) {
			System.out.println("Enter "+ i + " Person Details: ");
			Person person = insertDetails(scanner);
			
			arrayList.add(person);
		}
		
		System.out.println("\nInitial list of persons:");
        printarrayList(arrayList);
        
        System.out.println("\nEnter the person to add in beggining of list: ");
        arrayList.add(0, insertDetails(scanner));
        printarrayList(arrayList);

        System.out.println("\nEnter the person to add in end of list: ");
        arrayList.add(insertDetails(scanner));
        printarrayList(arrayList);
        
        System.out.println("\nEnter the person to add in third position of list: ");
        arrayList.add(2, insertDetails(scanner));
        printarrayList(arrayList);
        
        System.out.println("\nDetails of the Person at the fifth position:");
        System.out.println(arrayList.get(4));
        
        System.out.println("\nDetails of the first Person:");
        System.out.println(arrayList.get(0));
        
        System.out.println("\nDetails of the last Person:");
        System.out.println(arrayList.get(arrayList.size() - 1));
        
        System.out.println("\nEnter new details for the second Person:");
        arrayList.set(1, insertDetails(scanner));
        printarrayList(arrayList);
        
        arrayList.remove(0);
        System.out.println("\nAfter removing the first Person:");
        printarrayList(arrayList);
        
        arrayList.remove(2);
        System.out.println("\nAfter removing the third Person:");
        printarrayList(arrayList);
        
        System.out.println("\nEnter the person details you want to serach: ");
        Person searchPerson = insertDetails(scanner);
        boolean exists = arrayList.contains(searchPerson);
        System.out.println("\nDoes person exist in the list? " + exists);
        
        int existIndex = arrayList.indexOf(searchPerson);
        System.out.println("Index of Person in the list: " + existIndex);
        
        System.out.println("\nTraversing with for-loop:");
        for (int i=0;i<arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        
        System.out.println("\nTraversing with for-each loop:");
        for (Person person : arrayList) {
            System.out.println(person);
        }
		
        arrayList.clear();
        System.out.println("\nAfter clearing the ArrayList:");
        System.out.println("Person list: " + arrayList);
        
        
	}
	
	private static Person insertDetails(Scanner scanner) {
		System.out.println("Enter Name: ");
		String name = scanner.nextLine();
		System.out.println("Enter age: ");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter address: ");
		String address = scanner.nextLine();
		
		return new Person(name,age,address);
		
	}

	private static void printarrayList(ArrayList<Person> arrayList) {
		for (Person person : arrayList) {
            System.out.println(person);
        }
		
	}

}
