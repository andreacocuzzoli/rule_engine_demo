package com.loyalty.Reward.assembler;

import com.loyalty.Reward.kafkaModel.Event;
import com.loyalty.Reward.kafkaModel.EventEnriched;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class EventEnrichedAssembler {

    public EventEnriched transform(Event event)  {
        DayOfWeek dayOfWeek = event.getDate().getDayOfWeek();
        EventEnriched res = EventEnriched.builder()
                .date(event.getDate())
                .amount(event.getAmount())
                .person(event.getPerson())
                .shop(event.getShop())
                .isWeekend(dayOfWeek.equals(Calendar.SATURDAY) || dayOfWeek.equals(Calendar.SUNDAY)).build();

        return res;


    }

    public List<EventEnriched> transformAll(List<Event> events) {

        return  events.stream().map(x -> this.transform(x)).collect(Collectors.toList());

    }
}
