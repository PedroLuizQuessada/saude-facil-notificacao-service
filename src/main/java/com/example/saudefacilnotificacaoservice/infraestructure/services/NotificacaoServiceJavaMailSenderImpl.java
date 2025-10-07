package com.example.saudefacilnotificacaoservice.infraestructure.services;

import com.example.saudefacilnotificacaoservice.datasources.NotificacaoDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Profile("javamailsender")
public class NotificacaoServiceJavaMailSenderImpl implements NotificacaoDataSource {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${notificacao.consulta.mensagem}")
    private String remetente;

    @Override
    public void enviarNotificacao(String destinatario, String assunto, String mensagem) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(remetente);
        mailMessage.setTo(destinatario);
        mailMessage.setSubject(assunto);
        mailMessage.setText(mensagem);
        javaMailSender.send(mailMessage);
    }
}
