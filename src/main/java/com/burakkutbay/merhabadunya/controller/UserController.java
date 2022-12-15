package com.burakkutbay.merhabadunya.controller;

import com.burakkutbay.merhabadunya.entity.User;
import com.burakkutbay.merhabadunya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//localhost:8080/crud/

//localhost:8080/crud/save
//localhost:8080/crud/delete

//MERHABA_WEB_SERVICE/crud/save
//MERHABA_WEB_SERVICE/crud/delete
@RestController
@RequestMapping("/crud")
public class UserController {


    // 2 yöntem daha mevcut
    // constructor injection
    // setter injection

    /*
      CONSTUROCT INJECTION
       final     UserService userService;
        public UserController(UserService userService) {
            this.userService = userService;
        }
    */

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> getUsers() {
        return  userService.getUsers();
    }

    @PostMapping("/save")
    public List<User> createUser(@RequestBody User user) {
        return  userService.createUser(user);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


    // localhost:8080/crud/delete/2
    @DeleteMapping("/delete/{id}")
    public List<User> deleteUser(@PathVariable(value = "id") int id) {

        return userService.deleteUser(id);
    }
/*
  //getter metotda var

    /**
     * Setter injection
     * @param userService

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

 */
}
