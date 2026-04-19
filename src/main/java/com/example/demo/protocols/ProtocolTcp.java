package com.example.demo.protocols;

public class ProtocolTcp {
    public void sendImage(String image) {
        System.out.println("Sending image via TCP (reliable): " + image);
    }
}
