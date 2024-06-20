package com.myapp.spring_myapp_service.impl;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.values.InstanceId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

public class InstanceRepositoryImpl implements InstanceRepository {
    @Override
    public Mono<Instance> save(Instance app) {
        return null;
    }

    @Override
    public Flux<Instance> findAll() {
        return null;
    }

    @Override
    public Mono<Instance> find(InstanceId id) {
        return null;
    }

    @Override
    public Flux<Instance> findByName(String name) {
        return null;
    }

    @Override
    public Mono<Instance> compute(InstanceId id, BiFunction<InstanceId, Instance, Mono<Instance>> remappingFunction) {
        return null;
    }

    @Override
    public Mono<Instance> computeIfPresent(InstanceId id, BiFunction<InstanceId, Instance, Mono<Instance>> remappingFunction) {
        return null;
    }
}
