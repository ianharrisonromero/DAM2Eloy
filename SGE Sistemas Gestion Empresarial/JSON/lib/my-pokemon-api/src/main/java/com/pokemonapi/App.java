package com.pokemonapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App {
    public static void main(String[] args) {
        try {
            // Replace 'pikachu' with the name of the Pokémon you want to retrieve
            String pokemonNameInput = "ivysaur";

            // Construct the API URL
            String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemonNameInput;

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

                // Use Gson to parse the JSON
                Gson gson = new Gson();
                JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

                // Extract specific information about the Pokémon
                String pokemonName = jsonObject.get("name").getAsString();
                int baseExperience = jsonObject.get("base_experience").getAsInt();

                System.out.println("Pokemon Name: " + pokemonName);
                System.out.println("Base Experience: " + baseExperience);

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
