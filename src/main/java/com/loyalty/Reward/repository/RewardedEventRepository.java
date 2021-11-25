package com.loyalty.Reward.repository;

import com.loyalty.Reward.entity.RewardedEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardedEventRepository extends JpaRepository<RewardedEvent, Integer> {

    @Query("SELECT sum(u.amountSpent),sum(u.reward) from RewardedEvent u where u.user.id = :userId")
    Double[][] findTotalRewardByUserId (@Param("userId") Integer userId);
    @Query("SELECT sum(u.amountSpent) as amountSpent,sum(u.reward) as reward,u.shopCategory from RewardedEvent u where u.user.id = :userId group by u.shopCategory")
    Object[][] findTotalRewardByUserIdGroupedByCategory (@Param("userId") Integer userId);
}
