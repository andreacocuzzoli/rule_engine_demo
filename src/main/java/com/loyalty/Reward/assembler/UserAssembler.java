package com.loyalty.Reward.assembler;

import com.loyalty.Reward.entity.User;
import com.loyalty.Reward.model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class UserAssembler {

    public User transform(Person person) {
        User user = new User();
        user.setName(person.getName());
        user.setSurname(person.getSurname());
        return user;
    }

    public List<User> transformAll(List<Person> persons) {

        return persons.stream().map(x -> this.transform(x)).collect(Collectors.toList());

    }
}
