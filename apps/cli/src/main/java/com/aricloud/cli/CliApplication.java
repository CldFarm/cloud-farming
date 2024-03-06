package com.aricloud.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class CliApplication {

	private static final String BASE_URL = "http://localhost:8080";

	public static void main(String[] args) {
//		SpringApplication.run(CliApplication.class, args);

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			// Prompt user for input
			System.out.print("Enter the first number: ");
			int num1 = Integer.parseInt(reader.readLine());

			System.out.print("Enter the second number: ");
			int num2 = Integer.parseInt(reader.readLine());

			// Construct the URL for the GET request
			String urlStr = "http://localhost:8080/add?num1=" + num1 + "&num2=" + num2;
			URL url = new URL(urlStr);

			// Send the GET request
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			// Read the response
			BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String response = responseReader.readLine();
			responseReader.close();

			// Print the result
			System.out.println("Result: " + response);

			// Clean up
			connection.disconnect();
		} catch (IOException e) {
			System.err.println("Error occurred: " + e.getMessage());
		}
	}
	}

