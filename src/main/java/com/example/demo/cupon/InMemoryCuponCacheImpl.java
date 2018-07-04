package com.example.demo.cupon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class InMemoryCuponCacheImpl implements CuponCache {

    private long expirationTime = System.currentTimeMillis();

    private Map<Long, Cupon> cache = new HashMap<>();
    private static final long timeOutMinutes = 1;
    private static final long millisInMinute = 60000;

    private void resetExpiration() {
        this.expirationTime = System.currentTimeMillis();
    }

    @Override
    public Cupon get(long id) {
        if (((System.currentTimeMillis() - expirationTime) / millisInMinute) > timeOutMinutes) {
            log.warn("cache expiration passed...resetting it");
            resetExpiration();
            return null;
        }
        return cache.get(id);
    }

    @Override
    public void set(long id, Cupon cupon) {
        cache.put(id, cupon);
    }
}
