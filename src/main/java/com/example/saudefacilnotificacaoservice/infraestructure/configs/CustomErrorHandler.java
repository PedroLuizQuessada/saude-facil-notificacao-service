package com.example.saudefacilnotificacaoservice.infraestructure.configs;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.context.annotation.Profile;
import org.springframework.util.ErrorHandler;

@Profile("rabbit")
public class CustomErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        throw new AmqpRejectAndDontRequeueException(t.getMessage());
    }
}
