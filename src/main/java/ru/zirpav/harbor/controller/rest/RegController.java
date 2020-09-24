package ru.zirpav.harbor.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.zirpav.harbor.model.User;
import ru.zirpav.harbor.service.UserService;

@RestController
public class RegController {

    private UserService userService;

    @Autowired
    public RegController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/regUser")
    public ResponseEntity<?> regUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
