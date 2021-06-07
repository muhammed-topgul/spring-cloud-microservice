package com.muhammedtopgul.ticketservice.config;

/*
 * created by Muhammed Topgul
 * on 08/06/2021
 * at 00:20
 */

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicketConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
