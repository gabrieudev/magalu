package com.api.magalu.config.database;

import com.api.magalu.model.Channel;
import com.api.magalu.model.Status;
import com.api.magalu.model.enums.ChannelEnum;
import com.api.magalu.model.enums.StatusEnum;
import com.api.magalu.repository.ChannelRepository;
import com.api.magalu.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(ChannelEnum.values())
                .map(channelEnum -> new Channel(channelEnum.getId(), channelEnum.getDescription()))
                .forEach(channelRepository::save);

        Arrays.stream(StatusEnum.values())
                .map(statusEnum -> new Status(statusEnum.getId(), statusEnum.getDescription()))
                .forEach(statusRepository::save);
    }
}
