package com.example.demo.cupon;

public interface CuponCache {
    Cupon get(long id);
    void set(long id, Cupon cupon);
}
