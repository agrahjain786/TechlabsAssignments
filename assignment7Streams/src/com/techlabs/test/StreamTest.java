package com.techlabs.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileReader fileInputStream = new FileReader("/Users/abhijain/TechlabsAssignments/assignment7Streams/src/com/techlabs/test/names.txt");
			BufferedReader br=new BufferedReader(fileInputStream);
			
			List<String> names = new ArrayList<>();
			
			String line;
			while ((line = br.readLine()) != null) {
				names.add(line);
	        }
			
			
			Scanner scanner = new Scanner(System.in);
			
			
//			Filter the names to include only those that start with a specific letter (e.g., 'A').
			System.out.println("Enter the first character to get names starting from that: ");
			char letter = scanner.next().charAt(0);
			
			
			System.out.println("Names that starts with "+ letter+": ");
			names.stream()
			.filter((s) -> s.charAt(0) == letter)
			.forEach((s) -> System.out.println(s));
			
			
			
//			Convert all names to UpperCase.
			
			System.out.println("\nAfter converting all names to uppercase: ");
			names.stream()
			.map((s) -> s.toUpperCase())
			.forEach((s) -> System.out.println(s));
			
			
			
//			Sort the names alphabetically. 
			System.out.println("\nAfter sorting the names: ");
			names.stream()
			.sorted(String.CASE_INSENSITIVE_ORDER)
			.forEach((s) -> System.out.println(s));

			
			
//			Remove duplicate names from the list. 
			System.out.println("\nAfter removing duplicates: ");
			names.stream()
			.collect(Collectors.toSet())
			.forEach((s) -> System.out.println(s));
			

			
//			Collect the names into a new list. 
			List<String> collectingInList = names.stream()
					.collect(Collectors.toList());
			
			System.out.println("\nCollecting in a new list: ");
			collectingInList.stream()
			.forEach((s) -> System.out.println(s));

			
			
//			Count the number of names that satisfy a certain condition -   names that does not contain ‘i’
			System.out.println("\nEnter the character that should not included in the name: ");
			String invalidLetter = scanner.next();
			
			int namesWithoutChar = (int) names.stream()
					.filter((s) -> !(s.contains(invalidLetter)))
					.count();
			
			System.out.println("Count of Names without the letter are: "+namesWithoutChar);

			
			
			
//			Concatenate all the names into a single string separated by commas.
			System.out.println("\nConcatenating all the names into a single string separated by commas: ");
			String allNames = names.stream().collect(Collectors.joining(", "));
			System.out.println(allNames);

			
			
			
//			Filter names that start with 'J', convert them to uppercase, sort them, and then collect them into a list.
			System.out.println("\nFilter names that start with 'J', convert them to uppercase, sort them, and then collecting them into a list: ");
			
			names.stream()
			.filter((s) -> s.charAt(0) == 'J')
			.map((s) -> s.toUpperCase())
			.sorted()
			.forEach((s) -> System.out.println(s));
			
			
			
			fileInputStream.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
