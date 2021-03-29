package main;

import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import movie.Movie;

public class Main1 {

	public static void main(String[] args) {

		Movie m = new Movie();

		m.setImdbId("tt0016367");
		m.setTitle("From duck till dawn");
		m.setReleaseYear(1996);
		m.setRating(7.2);
		
		String[] actors = {"George Clooney", "Quentin Tarantino"};
		m.setActors(actors);
		
		System.out.println(m);

		try (FileWriter file = new FileWriter("movie.json")) {
			Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
			gson.toJson(m, file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
