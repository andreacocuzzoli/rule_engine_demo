package com.loyalty.Reward.kafkaModel;

import com.loyalty.Reward.model.Person;
import com.loyalty.Reward.model.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Event {


    private Person person;
    private LocalDateTime date;
    private Double amount;
    private Shop shop;


}
