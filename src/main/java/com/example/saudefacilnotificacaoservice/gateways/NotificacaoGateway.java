package com.example.saudefacilnotificacaoservice.gateways;

import com.example.saudefacilnotificacaoservice.datasources.NotificacaoDataSource;

public class NotificacaoGateway {

    private final NotificacaoDataSource notificacaoDataSource;

    public NotificacaoGateway(NotificacaoDataSource notificacaoDataSource) {
        this.notificacaoDataSource = notificacaoDataSource;
    }

    public void enviarNotificacao(String destinatario, String assunto, String mensagem) {
        notificacaoDataSource.enviarNotificacao(destinatario, assunto, mensagem);
    }
}
