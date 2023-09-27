package com.pokemonapi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class App {
    public static void main(String[] args) {
        try {
            // Replace 'pikachu' with the name of the Pokémon you want to retrieve
            String pokemonName = "ivysaur";

            // Construct the API URL
            String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;

            // Create a URL object
            URL url = new URL(apiUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Set the User-Agent header to identify your application
            connection.setRequestProperty("User-Agent", "cheese");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                // Read the response data
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the JSON response
                String jsonResponse = response.toString();

                System.out.println(jsonResponse);

                // You can parse the JSON data further to extract specific information about the Pokémon.
                // For example, you can use a JSON parsing library like Jackson or Gson.
            } else {
                System.out.println("Failed to retrieve Pokémon information. Status code: " + responseCode);
            }

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
