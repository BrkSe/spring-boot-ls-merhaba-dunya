package com.burakkutbay.merhabadunya.repository;

import com.burakkutbay.merhabadunya.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    List<User> createUser(User user);
    ResponseEntity<String> updateUser(User user);

    List<User> deleteUser(int id);

    User findUser(int id);


}
