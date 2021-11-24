package com.loyalty.Reward.service;

import com.loyalty.Reward.assembler.RewardedEventAssembler;
import com.loyalty.Reward.assembler.UserAssembler;
import com.loyalty.Reward.entity.RewardedEvent;
import com.loyalty.Reward.entity.User;
import com.loyalty.Reward.model.Reward;
import com.loyalty.Reward.repository.RewardedEventRepository;
import com.loyalty.Reward.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardedEventService {
    @Autowired
    private RewardedEventRepository rewardedEventRepository;

    @Autowired
    UserService userService;

    public RewardedEvent save(RewardedEvent rewardedEvent){
        return rewardedEventRepository
                .save(rewardedEvent);
    }

    public RewardedEvent processReward (Reward reward){

        UserAssembler userAssembler = new UserAssembler();
        User user = userService.save(userAssembler.transform(reward.getEvent().getPerson()));
        RewardedEventAssembler rewardedEventAssembler = new RewardedEventAssembler();
        return this.save(rewardedEventAssembler.transform(reward,user));

    }
}
