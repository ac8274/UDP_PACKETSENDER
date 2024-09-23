package com.example.udp_packetsender;

import android.util.Log;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HotSpot extends Thread{
    private ServerSocket serverSocket;
    private String HOTSPOT_IP; // Default IP for hotspot gateway
    private int PORT; // Port to listen on
    private static final String TAG = "ServerThread";


    public HotSpot(String ip,int port)
    {
        this.HOTSPOT_IP = ip;
        this.PORT = port;
    }

    @Override
    public void run()
    {
        try
        {
            startServer();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            stopServer();
        }
    }

    public void startServer() {
        try {
            // Bind to the Hotspot IP and a specific port
            InetAddress inetAddress = InetAddress.getByName(HOTSPOT_IP);
            serverSocket = new ServerSocket(PORT, 50, inetAddress);
            System.out.println("Server started on " + HOTSPOT_IP + ":" + PORT);

            // Listen for incoming connections
            //while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Handle the client connection in a separate thread or method
                handleClient(clientSocket);
                clientSocket.close();
            //}
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "Exception in ServerThread: " + e.getMessage());
        }
    }

    private void handleClient(Socket clientSocket) {
        // Perform your communication with the client here
        Log.d(TAG, "Handling client connection...");
        // Close the client socket after finishing communication
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void handleClient(Socket clientSocket) {
//        Log.println(Log.INFO,"nothing new","Succefully connected");
////        InputStream inputstream = null;
////        OutputStream outputStream = null;
////        try {
////            inputstream = clientSocket.getInputStream();
////            outputStream = clientSocket.getOutputStream();
////            DataInputStream commStream = new DataInputStream(inputstream);
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        }
//    }

    public void stopServer() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
