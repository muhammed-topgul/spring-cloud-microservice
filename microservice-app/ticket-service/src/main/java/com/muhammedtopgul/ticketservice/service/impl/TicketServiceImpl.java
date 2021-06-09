package com.muhammedtopgul.ticketservice.service.impl;

/*
 * created by Muhammed Topgul
 * on 08/06/2021
 * at 00:18
 */

import com.muhammedtopgul.servicecommon.client.AccountServiceClient;
import com.muhammedtopgul.servicecommon.client.contract.AccountDto;
import com.muhammedtopgul.ticketservice.dto.TicketDto;
import com.muhammedtopgul.ticketservice.entity.TicketEntity;
import com.muhammedtopgul.ticketservice.entity.es.TicketElasticEntity;
import com.muhammedtopgul.ticketservice.enumeration.PriorityType;
import com.muhammedtopgul.ticketservice.enumeration.TicketStatus;
import com.muhammedtopgul.ticketservice.repository.TicketRepository;
import com.muhammedtopgul.ticketservice.repository.es.TicketElasticRepository;
import com.muhammedtopgul.ticketservice.service.NotificationPublisherService;
import com.muhammedtopgul.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketElasticRepository elasticRepository;
    private final TicketRepository ticketRepository;
    private final NotificationPublisherService notificationPublisherService;
    private final AccountServiceClient accountServiceClient;

    @Transactional
    @Override
    public TicketDto save(TicketDto dto) {
        TicketEntity entity = new TicketEntity();
        // TODO ticketEntity.setAssignee(), make confirmation from Account API
        ResponseEntity<AccountDto> accountDto = accountServiceClient.get(dto.getAssignee());
        if (dto.getDescription() == null || dto.getDescription().trim().equals("")) {
            throw new IllegalArgumentException("Description cannot be null");
        }

        entity.setDescription(dto.getDescription());
        entity.setNotes(dto.getNotes());
        entity.setTicketDate(dto.getTicketDate());
        entity.setTicketStatus(TicketStatus.valueOf(dto.getTicketStatus()));
        entity.setPriorityType(PriorityType.valueOf(dto.getPriorityType()));
        entity.setAssignee(Objects.requireNonNull(accountDto.getBody()).getId());
        // 1. save to mysql
        entity = ticketRepository.save(entity);

        TicketElasticEntity elasticEntity = TicketElasticEntity.builder()
                .id(entity.getId())
                .assignee(Objects.requireNonNull(accountDto.getBody()).getNameAndSurname())
                .description(entity.getDescription())
                .notes(entity.getNotes())
                .ticketDate(entity.getTicketDate())
                .priorityType(entity.getPriorityType().getLabel())
                .ticketStatus(entity.getTicketStatus().getLabel())
                .build();

        // 2. save elastic
        elasticRepository.save(elasticEntity);

        dto.setId(entity.getId());

        // write to queue
        notificationPublisherService.sendToQueue(entity);
        return dto;
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
