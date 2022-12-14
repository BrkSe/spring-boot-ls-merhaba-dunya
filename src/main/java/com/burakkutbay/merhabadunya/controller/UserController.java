package com.burakkutbay.merhabadunya.controller;

import com.burakkutbay.merhabadunya.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    // localhost:8080/ornek1/burak/kutbay
    @GetMapping("/ornek1/{isim}/{soyad}")
    public String orsadasdasdasdasdnek1(@PathVariable("isim") String isim, @PathVariable String soyad) {

        User user = new User(1, isim, soyad);
        return user.getName() + " " + user.getSurname();
    }

    // localhost:8080/ornek2?isim=burak&soyad=kutbay
    // localhost:8080/ornek2?isim=burak
    // localhost:8080/ornek2?
    @GetMapping("/ornek2")
    public String orntggsdffdsdek2(
            @RequestParam(value = "isim", required = false, defaultValue = "isim girilmedi") String isim,
            @RequestParam(value = "soyad", required = false, defaultValue = "soyad girilmedi") String soyad) {

        User user = new User(1, isim, soyad);
        return user.getName() + " " + user.getSurname();

    }

    //localhost:8080/ornek3?isim=Burak/kutbay
    // http://localhost:8080/ornek3/kutbay?isim=Burak
    // Pathvariable önceliği var.
    @GetMapping("/ornek3/{soyad}")
    public String ornek3(@RequestParam(value = "isim") String isim, @PathVariable String soyad) {
        User user = new User(1, isim, soyad);
        return user.getName() + " " + user.getSurname();
    }

    @GetMapping("/ornek4")
    public String ornek4(@RequestBody String isim) {

        return "Kullanıcı İsmi " + isim;
    }

    @GetMapping("/ornek5")
    public User ornek5(@RequestBody User user) {
        return user;
    }

    @GetMapping("/ornek6")
    public ResponseEntity<String> ornek6() {
        ResponseEntity responseEntity = new ResponseEntity("Metota gelindi cevap başarılı", HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @GetMapping("/ornek7")
    public ResponseEntity<String> ornek7(@RequestBody User user) {
        if (user.getName().equals("burak")) {
            return new ResponseEntity<>("BURAKLAR GİREMEZ", HttpStatus.INTERNAL_SERVER_ERROR);

        } else {
            return new ResponseEntity<>("Kullanıcı Kayıt Edilmiştir", HttpStatus.SERVICE_UNAVAILABLE);
        }

    }

    @GetMapping("/ornek8")
    public ResponseEntity<User> ornek8(@RequestBody User user) {

        if (user.getName().equals("burak")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } else {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }

    }


}
