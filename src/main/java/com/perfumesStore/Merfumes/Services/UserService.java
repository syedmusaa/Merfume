package com.perfumesStore.Merfumes.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.perfumesStore.Merfumes.Entities.User;
import com.perfumesStore.Merfumes.Repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add("USER");
        return userRepository.save(user);
    }
    
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = findUserById(id); // Ensure the user exists
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setUsername(userDetails.getUsername());
        return userRepository.save(user);
    }
    
    
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    public Optional<List<User>> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }
    
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    

//    public Optional<User> findByRoles(String roles) {
//        return userRepository.findByRoles(roles); 
//    } 

//    @Autowired
//    private PerfumeRepository perfumeRepository;
//
//    public List<Perfume> getAllPerfumes() {
//        return perfumeRepository.findAll();
//    }
//
//    public Optional<Perfume> getPerfumeById(Long id) {
//        return perfumeRepository.findById(id);
//    }
//
//    public Perfume savePerfume(Perfume perfume) {
//        return perfumeRepository.save(perfume);
//    }
//
    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }

}