package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Main7 {

	// http://api.currencylayer.com/live?access_key=2e4baadf5c5ae6ba436f53ae5558107f&source=USD&currencies-EUR
	private static final String BASE_URL = "http://api.currencylayer.com";
	private static final String API_KEY = "2e4baadf5c5ae6ba436f53ae5558107f";
	private static final String SOURCE = "USD";
	private static final String CURRENCIES = "EUR";

	public static void main(String[] args) {

		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			URL url = new URL(
					BASE_URL + "/live?access_key=" + API_KEY + "&source=" + SOURCE + "&currencies-" + CURRENCIES);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(con.getInputStream()));

			JsonObject res = gson.fromJson(reader, JsonObject.class);

			System.out.println(res);
			if (res.get("success").getAsBoolean()) {
				double kurs = res.get("quotes").getAsJsonObject().get("USDEUR").getAsDouble();
				System.out.println("Kurs je " + kurs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
