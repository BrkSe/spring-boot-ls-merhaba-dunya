package com.burakkutbay.merhabadunya.service;

import com.burakkutbay.merhabadunya.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {

    private static List<User> userList = new ArrayList<>();

    public List<User> getUsers() {
        return userList;
    }

    public List<User> createUser(User user){
        userList.add(user);
        return userList;
    }

    public  ResponseEntity<String> updateUser(User user){
        if (user.getId() == null || user.getName() == "" || user.getSurname() == "") {
            return new ResponseEntity<>("Boş Alanları Doldur", HttpStatus.BAD_REQUEST);
        }

        // users Listesi 10 tane USER
        //0 eleman -  user.getId=1 burak kutbay
        // user.getId= 1 burak yavuz
        // user.getId=3
        // user.getId=4 ahmet
        for (int i = 0; i < userList.size(); i++) {


            if (userList.get(i).getId() == user.getId()) {

                if (userList.get(i).getName() != user.getName()) {
                    userList.get(i).setName(user.getName());
                }

                if (userList.get(i).getSurname() != user.getSurname()) {
                    userList.get(i).setSurname(user.getSurname());
                }

            }

        }
        return new ResponseEntity<>("Alanlar Başarılı Şekilde Güncellendi", HttpStatus.ACCEPTED);
    }

    public List<User> deleteUser(int id){

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {

                userList.get(i).setSurname(null);
                userList.get(i).setName(null);
            }
        }

        return userList;
    }


}
