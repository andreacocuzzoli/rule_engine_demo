package com.loyalty.Reward.controller;

import com.loyalty.Reward.exception.NotFoundException;
import com.loyalty.Reward.model.UserRewardTotals;
import com.loyalty.Reward.service.RewardedEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rewards/{userId}")
@CrossOrigin(origins = "*")
public class RewardController {

    @Autowired
    private RewardedEventService rewardEventService;

    @GetMapping
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<UserRewardTotals> getRewardByUserId(@PathVariable(value = "userId") Integer userId) {
        UserRewardTotals userRewardTotals = this.rewardEventService.rewardByUserId(userId);
        return ResponseEntity.ok(userRewardTotals);

    }

}