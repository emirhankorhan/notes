package com.example.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.notes.entity.User;
import com.example.notes.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("Kullanıcı başarıyla kaydedildi.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Kullanıcı kaydedilemedi.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        try {
            boolean isAuthenticated = userService.authenticateUser(user.getUserName(), user.getUserPassword());
            if (isAuthenticated) {
                String token = userService.generateToken(user.getUserName(), user.getUserPassword());
                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Yanlış şifre veya kullanıcı adı girildi!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Giriş yapılamadı. Hata: " + e.getMessage());
        }
    }

    @PatchMapping("/paw/{userId}")
    @CrossOrigin(origins = "http://toddo.co", methods = {RequestMethod.POST, RequestMethod.PATCH}, allowCredentials = "true")
    public ResponseEntity<Integer> updateUserPaw(@PathVariable Integer userId, @RequestParam(name = "paw") Integer paw) {
        int userPawValue = userService.updateUserPaw(userId, paw);
        return ResponseEntity.ok(userPawValue);
    }

}
