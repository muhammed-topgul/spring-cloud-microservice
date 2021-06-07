package com.muhammedtopgul.ticketservice.rest;

/*
 * created by Muhammed Topgul
 * on 08/06/2021
 * at 00:21
 */

import com.muhammedtopgul.ticketservice.dto.TicketDto;
import com.muhammedtopgul.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketRestController {

    private final TicketService service;

    @PostMapping
    public ResponseEntity<TicketDto> save(@RequestBody TicketDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDto> update(@PathVariable("id") String id, @RequestBody TicketDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<TicketDto>> getPagination(Pageable pageable) {
        return ResponseEntity.ok(service.getPagination(pageable));
    }
}
