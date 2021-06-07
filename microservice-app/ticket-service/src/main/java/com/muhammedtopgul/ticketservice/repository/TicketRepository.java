package com.muhammedtopgul.ticketservice.repository;

/*
 * created by Muhammed Topgul
 * on 08/06/2021
 * at 00:15
 */

import com.muhammedtopgul.ticketservice.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, String> {
}
