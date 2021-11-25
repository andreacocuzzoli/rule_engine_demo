package com.loyalty.Reward.service;

import com.loyalty.Reward.entity.User;
import com.loyalty.Reward.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<User> getUsers(String query){
        return StringUtils.isNotEmpty(query) ? userRepository.findUserByQuery(query) : userRepository.findAll();
    }

    public Optional<User> getById(Integer userId){
        return userRepository.findById(userId);
    }
}
