package com.example.demo.protocols.sendimages;

import java.util.HashMap;
import java.util.Map;

public class S3 {

    private Map<String, String> storage = new HashMap<>();

    public void upload(String fileName, String content) {
        storage.put(fileName, content);
        System.out.println("File uploaded :" + fileName);
    }

    public void sendImage(String url) {
        storage.put(url +" ", url + ".jpg");
        System.out.println("===>" + storage);
    }


    public void viziliseStorage() {
        System.out.println("===>" + storage);
    }
}


//les tructure de donnés ;

// les liste(arrays) / Map : objets;

//les Set;