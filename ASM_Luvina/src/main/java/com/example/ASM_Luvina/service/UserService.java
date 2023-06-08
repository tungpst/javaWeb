package com.example.ASM_Luvina.service;

import com.example.ASM_Luvina.entity.User;
import com.example.ASM_Luvina.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public List<User> findAll(){
        return userRepo.findAll();
    }
    public User save(User user){
        return userRepo.save(user);
    }
    public User findById(Integer id){
        return userRepo.findById(id).get();
    }
    public void delete(Integer id){
        userRepo.deleteById(id);
    }
}
