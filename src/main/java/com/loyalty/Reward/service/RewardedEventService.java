package com.loyalty.Reward.service;

import com.loyalty.Reward.assembler.RewardedEventAssembler;
import com.loyalty.Reward.assembler.UserAssembler;
import com.loyalty.Reward.entity.RewardedEvent;
import com.loyalty.Reward.entity.User;
import com.loyalty.Reward.exception.NotFoundException;
import com.loyalty.Reward.model.Reward;
import com.loyalty.Reward.model.UserRewardTotalByCategory;
import com.loyalty.Reward.model.UserRewardTotals;
import com.loyalty.Reward.repository.RewardedEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
public class RewardedEventService {
    @Autowired
    private RewardedEventRepository rewardedEventRepository;

    @Autowired
    UserService userService;
    Logger logger = LoggerFactory.getLogger(RewardService.class);

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

    public UserRewardTotals rewardByUserId(Integer userId) {
        Optional<User> user = this.userService.getById(userId);
        if (user.isPresent()) {

            Double[][] totals = this.rewardedEventRepository.findTotalRewardByUserId(userId);
            UserRewardTotals userRewardTotals = UserRewardTotals.builder().totalSpent(totals[0][0]).totalReward(totals[0][1]).build();
            userRewardTotals.setTotalByCategory(new ArrayList<>());
            Object[][] res = rewardedEventRepository.findTotalRewardByUserIdGroupedByCategory(userId);
            Arrays.stream(res).forEach(x -> {
                userRewardTotals.getTotalByCategory().add(UserRewardTotalByCategory.builder()
                        .totalSpent((Double) x[0]).totalReward((Double) x[1]).category((String) x[2]).build());
            });
            return userRewardTotals;

        } else {
            logger.error("User with id {} doesn't exist");
            throw new NotFoundException("User does not exist");
        }

    }
}
