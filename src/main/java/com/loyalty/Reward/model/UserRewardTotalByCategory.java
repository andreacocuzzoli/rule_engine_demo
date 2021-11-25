package com.loyalty.Reward.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRewardTotalByCategory {

    double totalSpent=0;
    double totalReward=0;
    String category="";
}
