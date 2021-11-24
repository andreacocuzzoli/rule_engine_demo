package com.loyalty.Reward.repository;

import com.loyalty.Reward.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u from User u where u.name= :name and u.surname = :surname")
     Optional<User> findUserByNameAndSurname (@Param("name") String name, @Param("surname") String surname);
}
