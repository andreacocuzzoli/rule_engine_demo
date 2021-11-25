package com.loyalty.Reward.model;

import com.loyalty.Reward.kafkaModel.EventEnriched;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Reward {
    EventEnriched event;
    Double amount=0d;
    List<String> rewardedPromo=new ArrayList<>();
}
