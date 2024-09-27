package com.scm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;

// Used for Database interaction
// Pass User Type and Type of ID that User has in JpaRepository
@Repository
public interface UserRepo extends JpaRepository<User,String>{
    
    // Additional database related operations
    Optional<User> findByEmail(String email);

}
