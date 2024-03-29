package com.shekhar.LmsPractice.controller;

import com.shekhar.LmsPractice.model.User;
import com.shekhar.LmsPractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("getAllUsers")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){
        User user=userService.findById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("addUser")
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/updateUserById/{userId}")
    public User updateUserById(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/deleteUserById/{userId}")
    public void deleteUserById(@PathVariable Long userId){
        userService.delete(userId);
    }

    @GetMapping("/getUserByFirstLetter")
    public List<User> getUserByFirstLetter(@RequestParam(name = "name") char firstLetter){
        return userService.findUserByFirstLetter(firstLetter);
    }

    @GetMapping("/getAllUsersWithSorted/{field}")
    public List<User> getUserWithSorted(@PathVariable String field){
        return userService.findUserWithSorted(field);
    }

    @GetMapping("/getAllUsersWithPagination/{pageNumber}/{pageSize}")
    public Page<User> getAllUsersWithPagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize)
    {
        return userService.findUsersWithPagination(pageNumber,pageSize);
    }

    @GetMapping("/getAllUsersWithPaginationAndSorting/{pageNumber}/{pageSize}/{field}")
    public Page<User> getAllUsersWithPaginationAndSorting(@PathVariable Integer pageNumber, @PathVariable Integer pageSize , @PathVariable String field)
    {
        return userService.findUsersWithPaginationAndSorting(pageNumber,pageSize,field);
    }
}
