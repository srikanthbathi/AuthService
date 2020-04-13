package com.nai.google.util;


import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

@Component
public class StorageUtil {


    @Autowired
    private Storage storage;

    public void uploadObject() throws IOException{
        BlobId blobId = BlobId.of("storeuploader","ti1");
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        storage.create(blobInfo, Files.readAllBytes(Paths.get("/Users/srikanth.bathi/Desktop/Resume.pdf")));
        System.out.println("Uploaded");

    }
}
