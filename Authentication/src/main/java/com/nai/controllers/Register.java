package com.nai.controllers;



import com.nai.StoreStatus;
import com.nai.domain.Address;
import com.nai.domain.BasicDetails;
import com.nai.domain.Store;
import com.nai.google.util.StorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/register")
public class Register {


    public static List<Store> stores = new ArrayList<>();

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private StorageUtil storageUtil;

    @PostMapping
    public ResponseEntity registerStore(@RequestBody Store store){
        store.setAddress(new Address());
        store.setStatus(StoreStatus.UNREGISTERED);
        store.setCreatedDate(new Date());
        stores.add(store);
        mongoTemplate.insert(store);
        ResponseEntity response;
        response = new ResponseEntity(HttpStatus.ACCEPTED);
        return response;
    }

    @GetMapping
    public List<Store> getStores() {


        List<Store> stores = mongoTemplate.findAll(Store.class);
        try {
            storageUtil.uploadObject();
        }catch (IOException ex){

        }
        return stores;
    }

    @DeleteMapping
    public void deleteStore(){
        mongoTemplate.dropCollection(Store.class);
    }
}
