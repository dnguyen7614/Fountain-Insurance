package com.revature.repository;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "Select * From users Where email=:email And password=:password", nativeQuery = true)
    ArrayList<User> getUsersByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query(value = "Select * From users Where firstName=:firstName And lastName=:lastName", nativeQuery = true)
    ArrayList<User> getUsersByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query
    Optional<User> findByEmail(String email);


}
