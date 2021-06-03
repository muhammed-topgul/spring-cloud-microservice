package com.muhammedtopgul.accountservice.service;

/*
 * created by Muhammed Topgul
 * on 02/06/2021
 * at 12:12
 */

import com.muhammedtopgul.accountservice.entity.AccountEntity;
import com.muhammedtopgul.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public AccountEntity get(String accountId) {
        return repository.findById(accountId).orElseThrow(IllegalArgumentException::new);
    }

    public AccountEntity save(AccountEntity entity) {
        return repository.save(entity);
    }

    public AccountEntity update(String accountId, AccountEntity entity) {
        Assert.isNull(accountId, "Id cannot be null");
        return repository.save(entity);
    }

    public void delete(String accountId) {
        // TODO impl
    }

    public AccountEntity pagination() {
        // TODO impl
        return new AccountEntity();
    }

    public List<AccountEntity> getAll() {
        return repository.findAll();
    }
}
