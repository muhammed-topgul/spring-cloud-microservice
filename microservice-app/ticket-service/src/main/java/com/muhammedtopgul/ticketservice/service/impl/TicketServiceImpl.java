package com.muhammedtopgul.ticketservice.service.impl;

/*
 * created by Muhammed Topgul
 * on 08/06/2021
 * at 00:18
 */

import com.muhammedtopgul.ticketservice.dto.TicketDto;
import com.muhammedtopgul.ticketservice.service.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Override
    public TicketDto save(TicketDto dto) {
        return null;
    }

    @Override
    public TicketDto update(String id, TicketDto dto) {
        return null;
    }

    @Override
    public TicketDto getById(String id) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
