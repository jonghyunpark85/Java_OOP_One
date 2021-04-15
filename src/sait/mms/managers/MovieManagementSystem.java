package sait.mms.managers;
import sait.mms.problemdomain.Movie;
import java.util.*;
import java.io.*;

/**
 * This program demonstrates movie management system using object-oriented
 * design principles. The program will read from supplied data file. The data
 * file contains information about the movies.
 * 
 * @author Jonghyun Park
 * @version January 24, 2020
 */

public class MovieManagementSystem {

	static Scanner in = new Scanner(System.in); // Scanner input 
	static ArrayList<Movie> movies = new ArrayList<Movie>(); // Create ArrayList movie

	/**
	 * This method works for showing display screen and input options.
	 * Also, this method works for saving file movie list.
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */
	public static void displayManu() throws IOException {

		int numChoice = 0; 

		while (numChoice != 4) {
			
			// Show display screen
			
			System.out.println("Movie Management system");
			System.out.printf("%s %5s%n", "1", "Add New Movie and Save");
			System.out.printf("%s %5s%n", "2", "Generate List of Movie Released in a Year");
			System.out.printf("%s %5s%n", "3", "Generate List of Random Movies");
			System.out.printf("%s %4s%n", "4", "Exit");

			System.out.print("Enter an option: ");
			numChoice = in.nextInt(); 
			System.out.println();
			
			// Process through user input choice number
			
			if (numChoice == 1) 
			{
				addMovie(); // Call to addMovie method  in this class
			} 
			else if (numChoice == 2) {

				int find = 0; 

				System.out.print("Enter the year: ");
				find = in.nextInt(); 

				System.out.println();

				generateMovieInYear(find); // Call to generateMovieInYear method in this class
			} 
			else if (numChoice == 3) {

				int random = 0; 
				boolean available = true; 

				while (available) {

					System.out.print("Enter number of movies: ");
					random = in.nextInt(); // Input Random list's number through scanner 

					if (random < 0) {
						available = false;
						System.out.println("Wrong number! Try Again!"); // Avoid input wrong number

					} else {
						break;
					}
				}
				generateRandomMovie(random); // Call to generateRandomMovie method  in this class
			} 
			else if (numChoice == 4) {
				
				// Overwrite movie.txt by final data
				PrintWriter pw = new PrintWriter(
						new FileOutputStream(new File("C:/workspaceprg251/Assignment 1/res/movies.txt"), false)); 
				
				for (int i = 0; i < movies.size(); i++) {

					int duration = movies.get(i).getDuration();
					String title = movies.get(i).getTitle();
					int year = movies.get(i).getYear();
					
					// Overwrite all data in movie.txt
					pw.println(duration + "," + title + "," + year); 
				}

				pw.close(); 

			} 
			else {
				System.out.println("Invalid option!\n"); // Avoid input wrong number
			}
		}
	}

	/**
	 * The user will be prompted to enter the duration in minutes, title of the new
	 * movie, and the year the movie was released. When user add a new movie, the
	 * program should update the data file by saving new movie at the end of the
	 * movie list.
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */
	public static void addMovie() throws IOException {
		
		// Append new data in movie.txt 
		PrintWriter pw = new PrintWriter(
				new FileOutputStream(new File("C:/workspaceprg251/Assignment 1/res/movies.txt"), true));

		int movieTime = 0;
		String movieName = "";
		int movieYear = 0;
		
		System.out.print("Enter duration: ");
		movieTime = in.nextInt();
		in.nextLine();

		System.out.print("Enter movie title: ");
		movieName = in.nextLine();

		System.out.print("Enter year: ");
		movieYear = in.nextInt();
		in.nextLine();

		if (movieTime != 0 && movieName != "" && movieYear != 0) { 
			
			Movie movieAppend = new Movie(); // Create Movie class
			movies.add(movieAppend); // Append data ArrayList
		} 
		else {
			
			System.out.println("The input data is not validated.");
		}

		System.out.println("Saving movies...");
		
		//Append new data in movie.txt
		pw.println();
		pw.println(movieTime + "," + movieName + "," + movieYear); 
		
		pw.close();

		System.out.println("Added movie to the data file.\n");

	}

	/**
	 * The user will input a year and the program will display a list of all the
	 * movies released in that year along with the duration (in minutes) of all the
	 * movies.
	 * 
	 * @param find will match with with findYear
	 */
	public static void generateMovieInYear(int find) {

		int sum = 0;

		System.out.println("Movie List");

		System.out.printf("%-12s%-6s%s%n", "Duration", "Year", "Title");

		for (int i = 0; i < movies.size(); i++) {

			Movie movieList = movies.get(i);
			int findYear = movieList.getYear();
			if (findYear == find) {

				System.out.println(Movie.toString(movieList));
				sum += movieList.getDuration();

			}
		}

		System.out.println("Total duration: " + sum + " minutes\n");
	}

	/**
	 * The user will input the number of movies and the program will display a list
	 * containing the amount of random movies along with the duration (in minutes)
	 * of all the movies.
	 * 
	 * @param random will be shuffle number
	 */
	public static void generateRandomMovie(int random) {

		Collections.shuffle(movies); // Collections.shuffle in the java.utils package to randomize the movie list.

		int sum = 0;

		System.out.println("Movie List");

		System.out.printf("%-12s%-6s%s%n", "Duration", "Year", "Title");

		for (int i = 0; i < random; i++) {

			Movie generate = movies.get(i);
			System.out.println(Movie.toString(generate));
			sum += generate.getDuration();

		}

		System.out.println("Total duration: " + sum + " minutes\n");

	}

	/**
	 * The program will read from the supplied data file into a single array list.
	 * The data file (movies.txt) contains information about the movies. Each movie
	 * record has the following attributes: Duration (in minutes), Title, Year of release
	 *  
	 * @throws IOException Thrown when the file could not be accessed.
	 */
	public static void loadMovie() throws IOException {

		File file = new File("C:/workspaceprg251/Assignment 1/res/movies.txt");
		Scanner inFile = new Scanner(file);

		while (inFile.hasNextLine()) {

			String line = inFile.nextLine();
			String[] commaLine = line.split(","); // Separate three data from one line

			String duration = commaLine[0];
			String title = commaLine[1];
			String year = commaLine[2];

			Movie loadMovie = new Movie(duration, title, year);

			movies.add(loadMovie); // All the data into arrayList.
		}

		inFile.close();

		displayManu(); // call to displayManu method in this class
	}

}
