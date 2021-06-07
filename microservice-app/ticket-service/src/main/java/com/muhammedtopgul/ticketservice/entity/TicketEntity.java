package com.muhammedtopgul.ticketservice.entity;

/*
 * created by Muhammed Topgul
 * on 08/06/2021
 * at 00:03
 */

import com.muhammedtopgul.ticketservice.enumeration.PriorityType;
import com.muhammedtopgul.ticketservice.enumeration.TicketStatus;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_tickets")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity extends BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "description", length = 600)
    private String description;

    @Column(name = "notes", length = 4000)
    private String notes;

    @Column(name = "assignee", length = 60)
    private String assignee;

    @Column(name = "ticket_date")
    private Date ticketDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "priority_type")
    private PriorityType priorityType;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ticket_status")
    private TicketStatus ticketStatus;
}
