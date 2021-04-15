package sait.mms.application;
import sait.mms.managers.MovieManagementSystem;
import java.io.*;

/**
 * This program demonstrates movie management system using object-oriented design principles.
 * The program will read from supplied data file. 
 * The data file contains information about the movies.
 * 
 * @author Jonghyun Park
 * @version January 24, 2020
 */

public class AppDriver {

	public static void main(String[] args) throws IOException {

		MovieManagementSystem.loadMovie(); // Call to Load Movie method in MovieManagementSystem class
	}

}
