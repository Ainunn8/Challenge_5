package org.Binar.Challenge.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class config {

    @Value("${BinarFud-1}")
    private String nameMerchant; // ""

    @Bean
    public String basicConfiguration() {
        log.info("Basic configuration is initializing. . .");
        log.info("Initialize success by {}", nameMerchant);
        return this.nameMerchant;
    }}
