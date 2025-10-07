package com.example.saudefacilnotificacaoservice.controllers;

import com.example.saudefacilnotificacaoservice.datasources.NotificacaoDataSource;
import com.example.saudefacilnotificacaoservice.gateways.NotificacaoGateway;
import com.example.saudefacilnotificacaoservice.usecases.EnviarNotificacaoConsultaUseCase;
import dtos.NotificacaoConsultaDto;

public class NotificacaoController {

    private final NotificacaoDataSource notificacaoDataSource;

    public NotificacaoController(NotificacaoDataSource notificacaoDataSource) {
        this.notificacaoDataSource = notificacaoDataSource;
    }

    public void enviarNotificacaoConsulta(NotificacaoConsultaDto notificacaoConsultaDto) {
        NotificacaoGateway notificacaoGateway = new NotificacaoGateway(notificacaoDataSource);
        EnviarNotificacaoConsultaUseCase useCase = new EnviarNotificacaoConsultaUseCase(notificacaoGateway);
        useCase.execute(notificacaoConsultaDto);
    }
}
