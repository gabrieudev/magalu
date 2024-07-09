package com.api.magalu.service.strategy;

import com.api.magalu.model.Communication;
import org.springframework.stereotype.Service;

@Service
public class EmailChannelService implements ChannelServiceStrategy {

    @Override
    public void send(Communication communication) {
        // TODO - send communication to email
    }
}