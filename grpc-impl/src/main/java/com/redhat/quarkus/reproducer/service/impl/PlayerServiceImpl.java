package com.redhat.quarkus.reproducer.service.impl;

import com.redhat.quarkus.reproducer.protobuf.Player;
import com.redhat.quarkus.reproducer.protobuf.PlayerRequest;
import com.redhat.quarkus.reproducer.service.BasePlayerService;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

@GrpcService
public class PlayerServiceImpl extends BasePlayerService {

    @Override
    public Uni<Player> get(PlayerRequest request) {
        return Uni.createFrom().item(request).onItem()
                .transform(r -> Player.newBuilder().setId(r.getId()).setUsername("player-" + r.getId()).build());
    }
}
