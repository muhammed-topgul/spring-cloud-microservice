package com.muhammedtopgul.accountservice.rest;

/*
 * created by Muhammed Topgul
 * on 02/06/2021
 * at 12:10
 */

import com.muhammedtopgul.accountservice.dto.AccountDto;
import com.muhammedtopgul.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 ** localhost:8080/account
 */
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService service;

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDto> get(@PathVariable("accountId") String accountId) {
        return ResponseEntity.ok(service.getOne(accountId));
    }

    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<AccountDto> update(@PathVariable("accountId") String accountId, @RequestBody AccountDto dto) {
        return ResponseEntity.ok(service.update(accountId, dto));
    }

    @DeleteMapping("/{accountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("accountId") String accountId) {
        service.delete(accountId);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Slice<AccountDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }
}
