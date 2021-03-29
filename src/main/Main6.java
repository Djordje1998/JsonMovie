package main;

import java.io.FileReader;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Main6 {

	public static void main(String[] args) {

		try (FileReader file = new FileReader("movie_manual.json")) {

			Gson gson = new Gson();
			JsonObject m = gson.fromJson(file, JsonObject.class);

			System.out.println(m.get("imdbId").getAsString());
			System.out.println(m.get("title").getAsString());
			System.out.println(m.get("releaseYear").getAsInt());
			
			double rating = m.get("rating").getAsDouble() - 1;
			System.out.println(rating);
			
			JsonArray actors = m.getAsJsonArray("actors");
			System.out.println(actors.get(1).getAsString());
			
			String [] niz = actors.get(0).getAsString().split(" ");
			System.out.println(niz[1]);

			Set<Entry<String, JsonElement>> es = m.entrySet();
			
			for (Entry<String, JsonElement> e : es) {
				System.out.println(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
