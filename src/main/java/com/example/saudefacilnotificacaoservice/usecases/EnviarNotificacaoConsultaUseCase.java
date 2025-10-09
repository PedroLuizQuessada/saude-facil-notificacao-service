package com.example.saudefacilnotificacaoservice.usecases;

import com.example.saudefacilnotificacaoservice.gateways.NotificacaoGateway;
import dtos.NotificacaoConsultaDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnviarNotificacaoConsultaUseCase {

    private static final String ASSUNTO = "Nova consulta agendada";
    private static final String MENSAGEM = "Uma nova consulta foi agendada com o doutor MEDICO para a data DATA";
    private static final String REPLACE_MEDICO = "MEDICO";
    private static final String REPLACE_DATA = "DATA";

    private final NotificacaoGateway notificacaoGateway;

    public EnviarNotificacaoConsultaUseCase(NotificacaoGateway notificacaoGateway) {
        this.notificacaoGateway = notificacaoGateway;
    }

    public void execute(NotificacaoConsultaDto notificacaoConsultaDto) {
        notificacaoGateway.enviarNotificacao(notificacaoConsultaDto.email(), ASSUNTO, montarMensagem(notificacaoConsultaDto.data(), notificacaoConsultaDto.nomeMedico()));
    }

    private String montarMensagem(LocalDateTime data, String medico) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataFormatada = formatter.format(data);

        return MENSAGEM.replace(REPLACE_MEDICO, medico).replace(REPLACE_DATA, dataFormatada);
    }

}
