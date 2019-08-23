package com.m2.config;

import com.codingapi.txlcn.common.util.id.ModIdProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.UUID;

@Component
public class MyModIdProvider implements ModIdProvider {

    @Autowired(required = false)
    ServerProperties serverProperties;

    @Override
    public String modId() {

        String modId = "";

        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
            String hostAddress = address.getHostAddress();

            modId = hostAddress + ":" + (Objects.isNull(serverProperties) ? 0 : (Objects.isNull(serverProperties.getPort()) ? 8080 :
                    serverProperties.getPort()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            modId = UUID.randomUUID().toString().replace("-", "");
        }

        return modId;
    }
}
