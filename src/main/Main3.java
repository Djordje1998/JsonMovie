package main;

import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import movie.Movie;

public class Main3 {

	public static void main(String[] args) {
		Movie m1 = new Movie();
		m1.setImdbId("tt0112471");
		m1.setTitle("Before sunrise");
		m1.setReleaseYear(1995);

		Movie m2 = new Movie();
		m2.setImdbId("tt0381681");
		m2.setTitle("Before sunset");
		m2.setReleaseYear(2004);

		Movie m3 = new Movie();
		m3.setImdbId("tt2209418");
		m3.setTitle("Before midnight");
		m3.setReleaseYear(2013);

		//Movie[] movies = { m1, m2, m3 };
		List<Movie> movies = new LinkedList<>();
		movies.add(m1);
		movies.add(m3);
		movies.add(m2);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try (FileWriter file = new FileWriter("many_movies.json")) {
			gson.toJson(movies, file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
