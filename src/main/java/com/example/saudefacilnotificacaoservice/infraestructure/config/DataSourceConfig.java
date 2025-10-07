package com.example.saudefacilnotificacaoservice.infraestructure.config;

import com.example.saudefacilnotificacaoservice.datasources.NotificacaoDataSource;
import com.example.saudefacilnotificacaoservice.infraestructure.services.NotificacaoServiceJavaMailSenderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean
    public NotificacaoDataSource notificacaoDataSource() {
        return new NotificacaoServiceJavaMailSenderImpl();
    }

}
