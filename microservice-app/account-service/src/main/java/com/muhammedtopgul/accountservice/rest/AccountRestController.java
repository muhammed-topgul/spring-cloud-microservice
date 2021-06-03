package com.muhammedtopgul.accountservice.rest;

/*
 * created by Muhammed Topgul
 * on 02/06/2021
 * at 12:10
 */

import com.muhammedtopgul.accountservice.entity.AccountEntity;
import com.muhammedtopgul.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 ** localhost:8080/account
 */
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService service;

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountEntity> get(@PathVariable("accountId") String accountId) {
        return ResponseEntity.ok(service.get(accountId));
    }

    @GetMapping
    public ResponseEntity<List<AccountEntity>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<AccountEntity> save(@RequestBody AccountEntity entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<AccountEntity> update(@PathVariable("accountId") String accountId, @RequestBody AccountEntity entity) {
        return ResponseEntity.ok(service.update(accountId, entity));
    }

    @DeleteMapping("/{accountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("accountId") String accountId) {
        service.delete(accountId);
    }

    @GetMapping("/pageable")
    public ResponseEntity<AccountEntity> pagination() {
        return ResponseEntity.ok(service.pagination());
    }
}
