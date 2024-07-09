package com.api.magalu.service.strategy;

import com.api.magalu.model.Communication;

public interface ChannelServiceStrategy {
    void send(Communication communication);
}
