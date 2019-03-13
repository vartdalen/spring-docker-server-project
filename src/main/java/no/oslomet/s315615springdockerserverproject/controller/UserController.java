package no.oslomet.s315615springdockerserverproject.controller;

import no.oslomet.s315615springdockerserverproject.model.User;
import no.oslomet.s315615springdockerserverproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;

@Transactional
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() { return userService.getAllUsers(); }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        try {
            int parsedId = Integer.parseInt(id);
            return userService.getUserById(parsedId);
        } catch (NumberFormatException e) {
            try {
                return userService.getUserByEmail(id);
            } catch (NoSuchElementException e2) {
                return new User();
            }
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable long id) {
         userService.deleteUserById(id);
    }

    @PostMapping("/users")
    public User saveUser( @RequestBody  User newUser) { return userService.saveUser(newUser); }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable long id,  @RequestBody  User newUser) {
        newUser.setId(id);
        return userService.saveUser(newUser);
    }
}
