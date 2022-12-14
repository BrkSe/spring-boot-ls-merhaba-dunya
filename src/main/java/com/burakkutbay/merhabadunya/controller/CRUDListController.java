package com.burakkutbay.merhabadunya.controller;

import com.burakkutbay.merhabadunya.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;


//localhost:8080/crud/

//localhost:8080/crud/save
//localhost:8080/crud/delete

//MERHABA_WEB_SERVICE/crud/save
//MERHABA_WEB_SERVICE/crud/delete
@RestController
@RequestMapping("/crud")
public class CRUDListController {

    private static List<User> users = new ArrayList<>();

    @GetMapping("")
    public List<User> getUsers() {
        return users;
    }

    @PostMapping("/save")
    public List<User> createUser(@RequestBody User user) {
        users.add(user);
        return users;
    }

    @PutMapping("/update") //user - id 4 veli
    //public List<User> updateUser(@RequestBody User user) {
    public ResponseEntity<String> updateUser(@RequestBody User user) {

        if (user.getId() == null || user.getName() == "" || user.getSurname() == "") {
            return new ResponseEntity<>("Boş Alanları Doldur", HttpStatus.BAD_REQUEST);
        }

        // users Listesi 10 tane USER
        //0 eleman -  user.getId=1 burak kutbay
        // user.getId= 1 burak yavuz
        // user.getId=3
        // user.getId=4 ahmet
        for (int i = 0; i < users.size(); i++) {


            if (users.get(i).getId() == user.getId()) {

                if (users.get(i).getName() != user.getName()) {
                    users.get(i).setName(user.getName());
                }

                if (users.get(i).getSurname() != user.getSurname()) {
                    users.get(i).setSurname(user.getSurname());
                }

            }

        }
        return new ResponseEntity<>("Alanlar Başarılı Şekilde Güncellendi", HttpStatus.ACCEPTED);

//        return users;
    }


    // localhost:8080/crud/delete/2
    @DeleteMapping("/delete/{id}")
    public List<User> deleteUser(@PathVariable(value = "id") int id) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {

                users.get(i).setSurname(null);
                users.get(i).setName(null);
            }
        }

        return users;
    }



}
