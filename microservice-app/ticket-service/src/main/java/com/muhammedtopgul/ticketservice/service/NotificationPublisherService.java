package com.muhammedtopgul.ticketservice.service;

/*
 * created by Muhammed Topgul
 * on 10/06/2021
 * at 00:22
 */

import com.muhammedtopgul.servicecommon.messaging.TicketNotification;
import com.muhammedtopgul.ticketservice.entity.TicketEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
@RequiredArgsConstructor
public class NotificationPublisherService {

    private final Source source;

    public void sendToQueue(TicketEntity ticketEntity) {
        TicketNotification ticketNotification = new TicketNotification();
        ticketNotification.setAccountId(ticketEntity.getAssignee());
        ticketNotification.setTicketId(ticketEntity.getId());
        ticketNotification.setTicketDescription(ticketEntity.getDescription());

        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }
}
