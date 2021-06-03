package com.muhammedtopgul.accountservice.repository;

/*
 * created by Muhammed Topgul
 * on 02/06/2021
 * at 15:21
 */

import com.muhammedtopgul.accountservice.entity.AccountEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CassandraRepository<AccountEntity, String> {
}
