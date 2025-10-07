package com.example.saudefacilnotificacaoservice.datasources;

public interface NotificacaoDataSource {
    void enviarNotificacao(String destinatario, String assunto, String mensagem);
}
