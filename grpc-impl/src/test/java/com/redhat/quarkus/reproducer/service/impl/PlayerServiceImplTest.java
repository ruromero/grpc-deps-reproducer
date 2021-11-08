package com.redhat.quarkus.reproducer.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.redhat.quarkus.reproducer.protobuf.Player;
import com.redhat.quarkus.reproducer.protobuf.PlayerRequest;
import com.redhat.quarkus.reproducer.protobuf.PlayerService;

import org.junit.jupiter.api.Test;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class PlayerServiceImplTest {

    @GrpcClient
    PlayerService svc;

    @Test
    void testGet() throws InterruptedException, ExecutionException, TimeoutException {
        assertThat(svc).isNotNull();
        CompletableFuture<Player> message = new CompletableFuture<>();
        PlayerRequest req = PlayerRequest.newBuilder().setId("abc").build();
        svc.get(req).subscribe().with(p -> message.complete(p));

        assertThat(message.get(5, TimeUnit.SECONDS)).extracting(Player::getId, Player::getUsername)
                .containsExactly("abc", "player-abc");
    }

}
