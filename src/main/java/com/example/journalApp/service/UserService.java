package com.example.journalApp.service;

import com.example.journalApp.entity.User;
import com.example.journalApp.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean saveNewUser(User user){
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(Arrays.asList("USER"));
            userRepo.save(user);
            return true;
        } catch (Exception e) {
            log.info("Error occurred for username: {} ", user.getUsername(),e);
            return false;
        }

    }


    public void saveUser(User user){

        userRepo.save(user);
    }

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public Optional<User> getById(ObjectId id){
        return userRepo.findById(id);
    }

    public void deleteByid(ObjectId myid){
        userRepo.deleteById(myid);
    }


    public User findByUsername(String username){
        return userRepo.findByUsername(username);
    }
}