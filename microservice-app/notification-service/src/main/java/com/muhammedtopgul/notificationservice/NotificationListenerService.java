package com.muhammedtopgul.notificationservice;

/*
 * created by Muhammed Topgul
 * on 10/06/2021
 * at 00:16
 */

import com.muhammedtopgul.servicecommon.messaging.TicketNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class NotificationListenerService {

    @StreamListener(Sink.INPUT)
    public void onNotificationListener(TicketNotification ticketNotification) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>----<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println(">>> Notification taken and sending to users <<<");
        System.out.println(ticketNotification.toString());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>----<<<<<<<<<<<<<<<<<<<<<<");
    }
}
