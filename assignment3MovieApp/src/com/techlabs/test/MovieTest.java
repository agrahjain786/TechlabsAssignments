package com.techlabs.test;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.techlabs.exceptions.CapacityFullException;
import com.techlabs.exceptions.NoSuchMovieFoundException;
import com.techlabs.model.MovieModel;
import com.techlabs.model.Serialization;

public class MovieTest {

	public static void main(String[] args) throws FileNotFoundException, EOFException{
		// TODO Auto-generated method stub
		MovieModel[] movies = new MovieModel[5];
		
		String fileName = "movies.txt";
		
		Serialization.clearSerializedFile(fileName);
		
		movies = Serialization.deserializeMovies(fileName);
		
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Select an option: ");
            System.out.println("1. Display movies");
            System.out.println("2. Add movie");
            System.out.println("3. Display a particular Movie");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            
            if(choice == 4) break;
            
            switch(choice) {
            case 1:
            	displayMovies(movies);
            	System.out.println();
            	break;
            case 2:
            	try {
            		System.out.print("Enter movie ID: ");
                    String movieId = scanner.nextLine();
                    System.out.print("Enter movie name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter movie genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter movie year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    MovieModel movie = new MovieModel(movieId, name, genre, year);
                    addMovie(movie, movies, fileName);
                    System.out.println("Movie added successfully. \n");
            	}
            	catch(CapacityFullException e) {
            		System.out.println(e.getMessage()+"\n");
            	}
            	break;
            case 3:
            	try {
            		System.out.print("Enter movie ID of the Movie: ");
                    String movieId = scanner.nextLine();
                    displayParticularMovie(movieId, movies);
                    System.out.println();
            	}
            	catch(NoSuchMovieFoundException e) {
            		System.out.println(e.getMessage() +"\n");
                }
            	break;
            default:
            	System.out.println("select a valid option. \n");
            	break;
            }
        }
        scanner.close();
	}
	

	private static void displayMovies(MovieModel[] movies) {
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
	
	private static void addMovie(MovieModel movie, MovieModel[] movies, String fileName) {
		boolean isFull = true;
		for (int i=0; i<movies.length; i++) {
            if (movies[i] == null) {
                movies[i] = movie;
                Serialization.serializemMovies(movies, fileName);
                isFull = false;
                break;
            }
        }
		if(isFull) 
			throw new CapacityFullException();
	}
	
	private static void displayParticularMovie(String requiredMovieId, MovieModel[] movies) {
		boolean movieFound = false;
		for (int i=0;i<movies.length; i++) {
            if (movies[i] != null && movies[i].getMovieId().equals(requiredMovieId)) {
            	System.out.println(movies[i]);
                movieFound = true;
                break;
            }
        }
		if(!movieFound)
			throw new NoSuchMovieFoundException();
	}
	
}
