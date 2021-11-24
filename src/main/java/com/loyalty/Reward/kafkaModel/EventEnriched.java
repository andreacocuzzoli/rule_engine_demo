package com.loyalty.Reward.kafkaModel;


import com.loyalty.Reward.model.ShopCategory;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper=true, includeFieldNames=true)
@EqualsAndHashCode(callSuper = true)
public class EventEnriched extends Event {
    private Boolean isWeekend;

}
