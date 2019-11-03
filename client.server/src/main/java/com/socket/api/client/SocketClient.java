package com.socket.api.client;

import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) throws Exception {

		String ip = "localhost";
		int port = 8099;

		Socket socket = new Socket(ip, port);

		//String message = "Zamin";
		String personJSONData = 
	            "  {" +
	            "   \"member\": \"Jack\", " +
	            "   \"claim\" : 13131351, " +
	            "   \"isMarried\" : false, " +
	            "   \"address\": { " +
	            "     \"street\": \"#1234, Main Street\", " +
	            "     \"zipCode\": \"123456\" " +
	            "   }, " +
	            "   \"phoneNumbers\": [\"011-111-1111\", \"11-111-1111\"] " +
	            " }";

		System.out.println("Client outputStream Started...");

		PrintWriter out = new PrintWriter(socket.getOutputStream());
		//out.println(message);
		out.println(personJSONData);
		out.flush();
	}
}
