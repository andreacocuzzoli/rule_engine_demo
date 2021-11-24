package com.loyalty.Reward.repository;

import com.loyalty.Reward.entity.RewardedEvent;
import com.loyalty.Reward.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardedEventRepository extends JpaRepository<RewardedEvent, Integer> {
}
