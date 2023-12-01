package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket = null;
    private DataInputStream inputStream = null;
    private DataOutputStream outputStream = null;


    public Client(String address,int port){
        try {
            socket = new Socket(address,port);
            System.out.println("Connected");

            inputStream = new DataInputStream(System.in);
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String line ="";

        while (!line.equals("Over")){
            try {
                line= inputStream.readLine();
                outputStream.writeUTF(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client client = new Client("127.0.0.1",5000);
    }
}
