package com.example.demo.cupon;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryCuponRepositoryImpl implements CuponRepository {

    private final static List<Cupon> AVAILABLE_CUPONS = Arrays.asList(
            new Cupon(123),
            new Cupon(124),
            new Cupon(125),
            new Cupon(126),
            new Cupon(127),
            new Cupon(128)
    );

    @Override
    public Optional<Cupon> getById(long cuponId) {
        return AVAILABLE_CUPONS.stream().filter(o -> o.getId() == cuponId).findFirst();
    }
}
