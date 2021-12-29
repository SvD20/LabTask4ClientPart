package edu.bsuir.udpclient.client;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ClientUDP {

    private static DatagramSocket clientDatagramSocket;

    private byte[] sendingDataBuffer;
    private byte[] receivingDataBuffer;

    public void connectionCreate() throws IOException {

        clientDatagramSocket = new DatagramSocket();

        sendingDataBuffer= new byte[1024];
        receivingDataBuffer = new byte[1024];

        System.out.println("Клиент готов к работе");

    }

    public String dataSendAndTake(String data,String host, int port) throws IOException {

        sendingDataBuffer = data.getBytes();

        DatagramPacket sendingPacket = new DatagramPacket(sendingDataBuffer,sendingDataBuffer.length, InetAddress.getByName(host),port);
        clientDatagramSocket.send(sendingPacket);

        DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
        clientDatagramSocket.receive(receivingPacket);

        String serverWord = new String(receivingPacket.getData());

        clientDatagramSocket.close();

        System.out.println("Клиент завершил работу");

        return serverWord;
    }

}
