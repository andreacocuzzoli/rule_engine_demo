package com.loyalty.Reward.assembler;

import com.loyalty.Reward.entity.RewardedEvent;
import com.loyalty.Reward.entity.User;
import com.loyalty.Reward.kafkaModel.Event;
import com.loyalty.Reward.kafkaModel.EventEnriched;
import com.loyalty.Reward.model.Reward;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class RewardedEventAssembler {

    public RewardedEvent transform(Reward reward, User user)  {
        RewardedEvent rewardedEvent = new RewardedEvent();
        rewardedEvent.setReward(reward.getAmount());
        rewardedEvent.setDate(reward.getEvent().getDate());
        rewardedEvent.setUser(user);
        rewardedEvent.setAmountSpent(reward.getEvent().getAmount());
        rewardedEvent.setShopName(reward.getEvent().getShop().getName());
        rewardedEvent.setShopAddress(reward.getEvent().getShop().getAddress());
        rewardedEvent.setShopCategory(reward.getEvent().getShop().getCategory().name());
        rewardedEvent.setRewardedPromos(reward.getRewardedPromo().toString());

        return rewardedEvent;

    }

}
