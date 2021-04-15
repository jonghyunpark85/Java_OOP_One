# Java_OOP_One

## Movie Management System
Write a movie management system using object-oriented design principles. The program will read from the supplied data file into a single array list. The data file (movies.txt) contains information about the movies. Each movie record has the following attributes:
-	Duration (in minutes)
-	Title
-	Year of release
Each record in the movies.txt file is formatted as follows:
-	Duration,Title,Year
-	e.g.: 91,Gravity,2013
Specifically, you have to create an interactive menu driven application that gives the user the following options:
1.	Add a new movie and save. 
o	The user will be prompted to enter the duration in minutes, title of the new movie, and the year the movie was released. Before the movie is added, the inputs provided by the user should be validated:
	The duration and year of the movie should not be zero and the title of the movie should not be empty. 
o	When you add a new movie, the program should update the data file by saving the new movie at the end of the movie list.
2.	Generate list of movies released in a year. 
o	The user will input a year and the program will display a list of all the movies released in that year along with the duration (in minutes) of all the movies.
o	The list of movies does not have to be sorted.
3.	Generate list of random movies.
o	The user will input the number of movies and the program will display a list containing the amount of random movies along with the duration (in minutes) of all the movies. 
o	There is no minimum or maximum duration for the movies in the list.
o	You can use Collections.shuffle in the java.utils package to randomize the movie list.
4.	Exit the program.
-	Save the list of movies back into the data file “movies.txt” using the above format (Duration,Title,Year).
Notes:
To follow the object-oriented principles, your project should contain ONLY the following classes and methods in their respective package.

Package	Class	Methods 
sait.mms.application	AppDriver	Main 
sait.mms.managers	MovieManagementSystem	displayMenu, addMovie,generateMovieInYear, generateRandomMovie, loadMovie
sait.mms.problemdomain	Movie	Accessor methods, toString
You cannot use parallel and/or nested arrays in this assignment (you can use ArrayList). 
