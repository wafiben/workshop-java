package com.example.demo.protocols;

import com.example.demo.interafces.Discussion;
import com.example.demo.protocols.sendimages.S3;

public class Http implements Discussion {
    private S3 stockage;

    public Http() {
        this.stockage = new S3();
    }

    public void sendImage(String image) {
        stockage.sendImage(image);
    }
}


//chatMer ===>
//les protcoloes ===>S3;