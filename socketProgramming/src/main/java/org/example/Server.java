package org.example;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private DataInputStream sinputStream = null;

    public Server(int port){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server Started");

            System.out.println("Waiting for the client.........");

            socket= serverSocket.accept();
            System.out.println("Waiting for a client");
            sinputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over"))
            {
                try
                {
                    line = sinputStream.readUTF();
                    System.out.println(line);

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            sinputStream.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
}

