package com.perfumesStore.Merfumes.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.perfumesStore.Merfumes.Entities.User;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
	  Optional<User> findById(String id);
	Optional<List<User>> findByUsername(String username);
    Optional<User> findByEmail(String email);
//    Optional<User> findByRoles(String roles);
}