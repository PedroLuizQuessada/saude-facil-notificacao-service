package com.example.saudefacilnotificacaoservice.usecases;

import com.example.saudefacilnotificacaoservice.gateways.NotificacaoGateway;
import dtos.NotificacaoConsultaDto;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnviarNotificacaoConsultaUseCase {

    @Value("${notificacao.consulta.assunto}")
    private String assunto;

    @Value("${notificacao.consulta.mensagem}")
    private String mensagem;

    private final NotificacaoGateway notificacaoGateway;

    public EnviarNotificacaoConsultaUseCase(NotificacaoGateway notificacaoGateway) {
        this.notificacaoGateway = notificacaoGateway;
    }

    public void execute(NotificacaoConsultaDto notificacaoConsultaDto) {
        notificacaoGateway.enviarNotificacao(notificacaoConsultaDto.email(), assunto, montarMensagem(notificacaoConsultaDto.data(), notificacaoConsultaDto.nomeMedico()));
    }

    private String montarMensagem(LocalDateTime data, String medico) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataFormatada = formatter.format(data);

        return mensagem.replace("MEDICO", medico).replace("DATA", dataFormatada);
    }

}
