package com.cershy.linyuminiserver.service;

import com.cershy.linyuminiserver.ssh.InteractionConnect;
import org.apache.sshd.common.keyprovider.KeyPairProvider;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.auth.password.PasswordAuthenticator;
import org.apache.sshd.server.channel.ChannelSession;
import org.apache.sshd.server.command.Command;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.nio.file.Paths;

@Component
public class SshServerService {
    private SshServer sshServer;

    @PostConstruct
    public void startServer() throws IOException {
        sshServer = SshServer.setUpDefaultServer();
        sshServer.setPort(2222);
        sshServer.setKeyPairProvider(createKeyPairProvider());
        sshServer.setPasswordAuthenticator(createPasswordAuthenticator());
        sshServer.setShellFactory(this::createShellCommand);
        sshServer.start();
        System.out.println("--------------SSH Server started--------------");
    }

    private Command createShellCommand(ChannelSession channelSession) {
        return new InteractionConnect();
    }

    @PreDestroy
    public void stopServer() throws IOException {
        if (sshServer != null) {
            sshServer.stop();
        }
    }

    private KeyPairProvider createKeyPairProvider() {
        return new SimpleGeneratorHostKeyProvider(Paths.get("hostkey.ser"));
    }

    private PasswordAuthenticator createPasswordAuthenticator() {
        return (username, password, session) -> {
            return true;
        };
    }
}
