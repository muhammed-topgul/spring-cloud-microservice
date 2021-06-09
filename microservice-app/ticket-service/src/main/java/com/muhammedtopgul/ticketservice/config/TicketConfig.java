package com.muhammedtopgul.ticketservice.config;

/*
 * created by Muhammed Topgul
 * on 08/06/2021
 * at 00:20
 */

import com.muhammedtopgul.servicecommon.client.AccountServiceClient;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.muhammedtopgul.ticketservice.repository")
@EnableElasticsearchRepositories
@EnableFeignClients(basePackageClasses = AccountServiceClient.class)
public class TicketConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
