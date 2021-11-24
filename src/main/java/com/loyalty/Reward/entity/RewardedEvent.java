package com.loyalty.Reward.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Reward")
@Table(name = "REWARDED_EVENt")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RewardedEvent {

    @Id  @GeneratedValue
    Integer id;
    Double reward;
    @Column(name = "amount_spent")
    Double amountSpent;
    LocalDateTime date;
    @Column(name = "shop_name")
    String shopName;
    @Column(name = "shop_address")
    String shopAddress;
    @Column(name = "shop_category")
    String shopCategory;
    @Column(name = "rewarded_promos")
    String rewardedPromos;
    @OneToOne
    @JoinColumn(name="USER_ID")
    private User user;
}
