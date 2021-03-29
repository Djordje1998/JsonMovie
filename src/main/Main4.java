package main;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import movie.Movie;

public class Main4 {

	public static void main(String[] args) {

		try (FileReader file = new FileReader("many_movies.json")) {
			Gson gson = new Gson();
			
			//Movie[] movies = gson.fromJson(file, Movie[].class);
			//List<Movie> movies = Arrays.asList(gson.fromJson(file, Movie[].class));
			
			Type typeToken = new TypeToken<LinkedList<Movie>>(){}.getType();
			List<Movie> movies = gson.fromJson(file, typeToken);
			
			for (Movie m : movies) {
				System.out.println(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
