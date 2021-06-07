package com.muhammedtopgul.ticketservice.service;

/*
 * created by Muhammed Topgul
 * on 08/06/2021
 * at 00:16
 */

import com.muhammedtopgul.ticketservice.dto.TicketDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {

    TicketDto save(TicketDto dto);

    TicketDto update(String id, TicketDto dto);

    TicketDto getById(String id);

    Page<TicketDto> getPagination(Pageable pageable);
}
