package com.redhat.quarkus.reproducer.service.impl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;

import com.redhat.quarkus.reproducer.protobuf.Player;
import com.redhat.quarkus.reproducer.protobuf.PlayerRequest;
import com.redhat.quarkus.reproducer.protobuf.PlayerService;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import io.quarkus.test.junit.QuarkusTest;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusIntegrationTest
public class PlayerServiceImplIT extends PlayerServiceImplTest {
}
