package com.example.saudefacilnotificacaoservice.infraestructure.consumers;

import com.example.saudefacilnotificacaoservice.controllers.NotificacaoController;
import com.example.saudefacilnotificacaoservice.datasources.NotificacaoDataSource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dtos.NotificacaoConsultaDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Profile("rabbit")
public class NotificacoesConsultaConsumer {

    private final NotificacaoController notificacaoController;

    public NotificacoesConsultaConsumer(NotificacaoDataSource notificacaoDataSource) {
        this.notificacaoController = new NotificacaoController(notificacaoDataSource);
    }

    @RabbitListener(queues = "${rabbitmq.fila-notificacoes-consultas}")
    public void consumir(String mensagem) {
        ObjectMapper objectMapper = new ObjectMapper();
        NotificacaoConsultaDto notificacaoConsultaDto;
        try {
            notificacaoConsultaDto = objectMapper.readValue(mensagem, NotificacaoConsultaDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        log.info("Notificando e-mail {} sobre consulta com médico {}", notificacaoConsultaDto.email(), notificacaoConsultaDto.nomeMedico());
        log.info("------------------------------------------------------");

        notificacaoController.enviarNotificacaoConsulta(notificacaoConsultaDto);
    }

}
