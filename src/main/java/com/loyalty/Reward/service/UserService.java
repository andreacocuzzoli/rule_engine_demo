package com.loyalty.Reward.service;

import com.loyalty.Reward.entity.User;
import com.loyalty.Reward.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        Optional<User> optUser = userRepository.findUserByNameAndSurname(user.getName(), user.getSurname());
        if (optUser.isPresent()){
            return optUser.get();
        }
        else return userRepository.save(user);
    }
}
