package com.reactive.demo;

import io.r2dbc.mssql.MssqlConnectionConfiguration;
import io.r2dbc.mssql.MssqlConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.time.Duration;

@Slf4j
@Configuration
@EnableR2dbcRepositories("com.reactive.repository")
public class DatabaseConfiguration extends AbstractR2dbcConfiguration {
    @Value("${spring.data.mssql.host}")
    private String host;

    @Value("${spring.data.mssql.port}")
    private Integer port;

    @Value("${spring.data.mssql.database}")
    private String database;

    @Value("${spring.data.mssql.username}")
    private String username;

    @Value("${spring.data.mssql.password}")
    private String password;

    @Bean
    @Override
    public MssqlConnectionFactory connectionFactory() {
        log.info("################### Connecting to database #####################");

        return new MssqlConnectionFactory(MssqlConnectionConfiguration.builder()
                .host(host)
                .port(port)
                .database(database)
                .username(username)
                .password(password)
                .connectTimeout(Duration.ofSeconds(3))
                .build());
    }
}