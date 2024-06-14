package com.techlabs.model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void serializemMovies(MovieModel[] movies, String fileName) {
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(movies);
			out.close();
            file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static MovieModel[] deserializeMovies(String fileName) throws FileNotFoundException, EOFException{
		try {
			FileInputStream file = new FileInputStream(fileName);
			try (ObjectInputStream in = new ObjectInputStream(file)) {
				return (MovieModel[])in.readObject();
			}
		}
		catch (FileNotFoundException | EOFException e) {
            return new MovieModel[5];
        }
		catch(IOException e) {
            e.printStackTrace();
            return new MovieModel[5];
        }
		catch (ClassNotFoundException e) {
			e.printStackTrace();
            return new MovieModel[5];
		}
	}

	public static void clearSerializedFile(String fileName) {
		File file = new File(fileName);
        if (file.exists())
            file.delete(); 
	}

}
