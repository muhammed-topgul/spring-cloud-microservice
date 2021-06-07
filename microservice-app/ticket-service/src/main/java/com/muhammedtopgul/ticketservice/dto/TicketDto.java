package com.muhammedtopgul.ticketservice.dto;

/*
 * created by Muhammed Topgul
 * on 08/06/2021
 * at 00:16
 */

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto {

    private String id;
    private String description;
    private String notes;
    private String assignee;
    private Date ticketDate;
    private String priorityType;
    private String ticketStatus;
    private Date createdAt;
    private Date updatedAt;
}
