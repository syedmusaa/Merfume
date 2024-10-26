package com.perfumesStore.Merfumes.Controllers;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perfumesStore.Merfumes.Entities.Perfume;
import com.perfumesStore.Merfumes.Entities.User;
import com.perfumesStore.Merfumes.Services.PerfumeService;
import com.perfumesStore.Merfumes.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        User user = userService.findUserById(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
    
    
    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile(@RequestParam String email) {
        return userService.findByEmail(email)
                          .map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
//        return userService.getUserById(id)
//                .map(user -> {
//                	user.getUsername(userDetails.getUsername());
//                	user.setEmail(userDetails.getEmail());
//                	user.setPassword(userDetails.getPassword());
//                    return ResponseEntity.ok(UserService.saveUser(user));
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//    
    
    
    
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        Optional<User> existingUser = userService.getUserById(id);
//        if (existingUser.isPresent()) {
//            user.setId(id);
//            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(User -> {
                	userService.deleteUser(id);
                    return ResponseEntity.ok().<User>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Perfume> deletePerfume(@PathVariable Long id) {
//        Optional<Perfume> perfume = perfumeService.getPerfumeById(id);
//        if (perfume.isPresent()) {
//            perfumeService.deletePerfume(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}