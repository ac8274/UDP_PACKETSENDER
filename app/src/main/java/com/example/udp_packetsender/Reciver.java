package com.example.udp_packetsender;

import android.util.Log;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Reciver extends Thread{
    private int port;

    public Reciver(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(port);
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                Log.d("UDPReceiver", "Received message: " + received);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
