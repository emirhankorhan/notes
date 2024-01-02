package com.example.notes.services;

import java.security.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.notes.entity.User;
import com.example.notes.repos.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    

    public void registerUser(User user) {
        String salt = BCrypt.gensalt();
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword() + salt));
        user.setUserSalt(salt);
        userRepository.save(user);
    }

    public Integer updateUserPaw(Integer userId, Integer paw){
        User user = userRepository.findByUserId(userId);
        user.setUserPaw(user.getUserPaw() + paw);
        userRepository.save(user);
        return user.getUserPaw();
    }

    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUserName(username);
        if (user != null) {
            String salt = user.getUserSalt();
            boolean passwordMatch = passwordEncoder.matches(password + salt, user.getUserPassword());
            return passwordMatch;
        }
        return false;
    }

    public String generateToken(String username, String password) {
        User user = userRepository.findByUserName(username);
        String userId = String.valueOf(user.getUserId());
        String userPaw = String.valueOf(user.getUserPaw());
        String userName = user.getName() + " " + user.getSurname();

     
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);


        return Jwts.builder()
                .setSubject("userToken")
                .claim("username", userName)
                .claim("userid", userId)
                .claim("userpaw", userPaw)
                .signWith(key)
                .compact();
    }
}

