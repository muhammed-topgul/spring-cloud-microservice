package com.muhammedtopgul.servicecommon.messaging;

/*
 * created by Muhammed Topgul
 * on 10/06/2021
 * at 00:19
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TicketNotification {

    private String ticketId;
    private String accountId;
    private String ticketDescription;
}