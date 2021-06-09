package com.muhammedtopgul.servicecommon.client;

/*
 * created by Muhammed Topgul
 * on 09/06/2021
 * at 22:31
 */

import com.muhammedtopgul.servicecommon.client.contract.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("account-service")
public interface AccountServiceClient {

    @GetMapping("/{accountId}")
    ResponseEntity<AccountDto> get(@PathVariable("accountId") String accountId);
}
