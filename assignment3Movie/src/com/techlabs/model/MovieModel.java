package com.techlabs.model;

import java.io.Serializable;

public class MovieModel implements Serializable {
	
	private String movieId;
	private String name;
	private String genre;
	private int year;
	
	public MovieModel(String movieId, String name, String genre, int year) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.genre = genre;
		this.year = year;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	

}
