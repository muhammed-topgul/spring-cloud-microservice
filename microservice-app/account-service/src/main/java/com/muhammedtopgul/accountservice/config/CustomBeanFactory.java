package com.muhammedtopgul.accountservice.config;

/*
 * created by Muhammed Topgul
 * on 06/06/2021
 * at 22:34
 */

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeanFactory {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
