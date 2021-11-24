package com.loyalty.Reward.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_DETAILS",uniqueConstraints={
        @UniqueConstraint(columnNames = {"name", "surname"})
})
public class User {

    @Id  @GeneratedValue
    Integer id;
    String name;
    String surname;
}
