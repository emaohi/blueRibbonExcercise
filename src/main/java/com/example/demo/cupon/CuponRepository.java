package com.example.demo.cupon;

import java.util.Optional;

public interface CuponRepository {
    Optional<Cupon> getById(long cuponId);
}
