package main.java;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;


public class Server {
    private static ServerSocket serverSocket;
    private static Socket clientSocket;


    public void bootLoader() throws IOException {

        serverSocket = new ServerSocket(8000);
        clientSocket = serverSocket.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String name = br.readLine();
        name = name.substring(5, name.indexOf('H'));


        OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
        writer.write("HTTP/1.0 200 OK\n" +
                "Content-type: text/html\n" +
                "\n" +
                "<h1>Hello, " + name + "</h1>\n");

        writer.flush();
        writer.close();
        serverSocket.close();
        clientSocket.close();


    }
}
