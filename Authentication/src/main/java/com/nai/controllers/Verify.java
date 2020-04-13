package com.nai.controllers;


import com.nai.domain.Store;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verify")
public class Verify {



    @PostMapping("/accept")
    public void successVerification(@RequestBody Store store){
        return;
    }

    @PostMapping("/reject")
    public void invalidVerification(@RequestBody Store store){
        return;
    }



}
