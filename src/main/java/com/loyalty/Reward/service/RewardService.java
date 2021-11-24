package com.loyalty.Reward.service;

import com.loyalty.Reward.kafkaModel.EventEnriched;
import com.loyalty.Reward.model.Reward;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardService {

    @Autowired
    private KieContainer kieContainer;

    public Reward calculateReward(EventEnriched event) {
        Reward reward = new Reward();
        reward.setEvent(event);
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(event);
        kieSession.insert(reward);
        kieSession.fireAllRules();
        kieSession.dispose();
        return reward;
    }
}
