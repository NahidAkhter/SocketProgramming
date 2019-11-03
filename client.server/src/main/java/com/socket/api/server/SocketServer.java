package com.socket.api.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class SocketServer {
	public static void main(String[] args) throws Exception {

		System.out.println("Server is Started...");
		ServerSocket serverSocket = new ServerSocket(8099);

		System.out.println("trying to connect... to port");
		Socket socket = serverSocket.accept();
		System.out.println("Client Connected...");

		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println("Buffer Reading...");

		String personJSONData = bufferReader.readLine();
		jsonPrint(personJSONData);	
	}
	
	
	//JSON PRINT Output METHOD
	public static void jsonPrint(String personJSONData) {
		JsonReader reader = Json.createReader(new StringReader(personJSONData));

		JsonObject personObject = reader.readObject();

		reader.close();


		System.out.println("Member   : " + personObject.getString("member"));
		System.out.println("Claim    : " + personObject.getInt("claim"));
		System.out.println("Married: " + personObject.getBoolean("isMarried"));


		JsonObject addressObject = personObject.getJsonObject("address");

		System.out.println("Address: ");
		System.out.println(addressObject.getString("street"));
		System.out.println(addressObject.getString("zipCode"));


		System.out.println("Phone  : ");
		JsonArray phoneNumbersArray = personObject.getJsonArray("phoneNumbers");
		for (JsonValue jsonValue : phoneNumbersArray) {
			System.out.println(jsonValue.toString());
		}		
	}
	
}
