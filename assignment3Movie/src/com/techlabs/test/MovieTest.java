package com.techlabs.test;

import java.util.Scanner;
import com.techlabs.model.MovieModel;
import com.techlabs.model.Serialization;

public class MovieTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MovieModel[] movies = new MovieModel[5];
		
		String fileName = "movies.txt";
		
		movies = Serialization.deserializeMovies(fileName);
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nSimple Movies App");
            System.out.println("1. Display movies");
            System.out.println("2. Add movie");
            System.out.println("3. Display a particular Movie");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch(choice) {
            case 1:
            	displayMovies(movies);
            	break;
            default :
            	System.out.println("Okay fine");
            	break;
            }
       }

	}
	
	public static void displayMovies(MovieModel[] movies) {
		boolean isEmpty = true;
        for (int i=0;i<5;i++) {
            if (movies[i] != null) {
                System.out.println(movies[i]);
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("No movies to display.");
        }
	}

}
