package com.muhammedtopgul.accountservice.service;

/*
 * created by Muhammed Topgul
 * on 02/06/2021
 * at 12:12
 */

import com.muhammedtopgul.accountservice.dto.AccountDto;
import com.muhammedtopgul.accountservice.entity.AccountEntity;
import com.muhammedtopgul.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;
    private final ModelMapper mapper;

    public AccountDto getOne(String accountId) {
        AccountEntity entity = repository.findById(accountId).orElseThrow(IllegalArgumentException::new);
        return mapper.map(entity, AccountDto.class);
    }

    public AccountDto save(AccountDto dto) {
        AccountEntity entity = mapper.map(dto, AccountEntity.class);
        entity = repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public AccountDto update(String accountId, AccountDto dto) {
        Assert.isNull(accountId, "Id cannot be null");
        AccountEntity entity = repository.findById(accountId).orElseThrow(IllegalArgumentException::new);
        entity.setBirthDate(dto.getBirthDate());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        return mapper.map(repository.save(entity), AccountDto.class);
    }

    public void delete(String accountId) {
        Optional<AccountEntity> entity = repository.findById(accountId);
        if (entity.isPresent()) {
            repository.deleteById(accountId);
        }
    }

    public Slice<AccountDto> getAll(Pageable pageable) {
        Slice<AccountEntity> all = repository.findAll(pageable);
        return null;
    }
}
