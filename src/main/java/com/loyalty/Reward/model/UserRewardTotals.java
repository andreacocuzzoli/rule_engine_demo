package com.loyalty.Reward.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRewardTotals {

    double totalSpent=0;
    double totalReward=0;
    List<UserRewardTotalByCategory> totalByCategory = new ArrayList<>();
}
