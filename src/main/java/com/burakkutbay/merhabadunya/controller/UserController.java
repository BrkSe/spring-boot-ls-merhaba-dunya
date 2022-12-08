package com.burakkutbay.merhabadunya.controller;

import com.burakkutbay.merhabadunya.entity.User;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeDeserializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class UserController {

    // localhost:8080/ornek1/burak/kutbay
    @GetMapping("/ornek1/{isim}/{soyad}")
    public String ornek1(@PathVariable("isim") String isim, @PathVariable String soyad) {

        User user = new User(1, isim, soyad);
        return user.getName() + " " + user.getSurname();
    }

    // localhost:8080/ornek2?isim=burak&soyad=kutbay
    // localhost:8080/ornek2?isim=burak
    // localhost:8080/ornek2?
    @GetMapping("/ornek2")
    public String ornek2(
            @RequestParam(value = "isim",  required = false, defaultValue = "isim girilmedi") String isim,
            @RequestParam(value = "soyad", required = false, defaultValue = "soyad girilmedi") String soyad){

            User user = new User(1, isim, soyad);
            return user.getName() + " " + user.getSurname();

    }

    //localhost:8080/ornek3?isim=Burak/kutbay
    // http://localhost:8080/ornek3/kutbay?isim=Burak
    // Pathvariable önceliği var.
    @GetMapping("/ornek3/{soyad}")
    public String ornek3(@RequestParam(value = "isim") String isim, @PathVariable String soyad){
        User user = new User(1, isim, soyad);
        return user.getName() + " " + user.getSurname();
    }

}
