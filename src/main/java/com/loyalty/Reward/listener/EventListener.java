package com.loyalty.Reward.listener;


import com.loyalty.Reward.assembler.EventEnrichedAssembler;
import com.loyalty.Reward.assembler.RewardedEventAssembler;
import com.loyalty.Reward.assembler.UserAssembler;
import com.loyalty.Reward.entity.RewardedEvent;
import com.loyalty.Reward.entity.User;
import com.loyalty.Reward.kafkaModel.Event;
import com.loyalty.Reward.kafkaModel.EventEnriched;
import com.loyalty.Reward.model.Reward;
import com.loyalty.Reward.service.RewardService;
import com.loyalty.Reward.service.RewardedEventService;
import com.loyalty.Reward.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Component
public class EventListener {


    Logger logger = LoggerFactory.getLogger(EventListener.class);

    @Autowired
    private RewardService rewardService;
    @Autowired
    private UserService userService;
    @Autowired
    private RewardedEventService rewardedEventService;



    @KafkaListener(topics = "event", containerFactory = "kafkaListenerContainerFactory")
    public void receiveEvent(@Payload Event event) {
        logger.info("Received Event: {}", event.toString());
        EventEnrichedAssembler eventEnrichedAssembler = new EventEnrichedAssembler();
        EventEnriched eventEnriched = eventEnrichedAssembler.transform(event);
        logger.info("Enriched Event: {}",eventEnriched.toString());
        Reward reward = rewardService.calculateReward(eventEnriched);
        if(reward.getAmount() >0d){
            logger.info("Event Rewarded with: {} from promo/s: {}",reward.getAmount(),reward.getRewardedPromo());
            rewardedEventService.processReward(reward);

        }
    }
}
