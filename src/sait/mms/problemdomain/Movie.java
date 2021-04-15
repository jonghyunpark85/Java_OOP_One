package sait.mms.problemdomain;
import java.io.*;

/**
 * This program demonstrates movie management system using object-oriented design principles.
 * The program will read from supplied data file. 
 * The data file contains information about the movies.
 * 
 * @author Jonghyun Park
 * @version January 24, 2020
 */

public class Movie {

	private int duration;
	private String title;
	private int year;
	
	/** Default Constructor
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */
	public Movie() throws IOException {

	}
	
	/** Default Constructor using parameters
	 * 
	 * @param duration will be chagne int data type
	 * @param title will be keep data type
	 * @param year will be change int data type
	 */
	public Movie(String duration, String title, String year) {

		this.duration = Integer.parseInt(duration);
		this.title = title;
		this.year = Integer.parseInt(year);

	}

	/**
	 * Gets the moive's running time
	 * 
	 * @return this movie's duration.
	 */
	public int getDuration() {

		return this.duration;
	}
	
	/**
	 * Gets the moive's title
	 * 
	 * @return this movie's title.
	 */
	
	public String getTitle() {

		return this.title;
	}
	
	/**
	 * Gets the moive's released year
	 * 
	 * @return this movie's year.
	 */

	public int getYear() {

		return this.year;
	}
	
	/**
	 * toString method can show data by string format.
	 * 
	 * @param movie class 
	 * @return toString formated 
	 */

	public static String toString(Movie movie) {

		return String.format("%-12s%-6s%s", movie.getDuration(), movie.getYear(), movie.getTitle());
	}
}
