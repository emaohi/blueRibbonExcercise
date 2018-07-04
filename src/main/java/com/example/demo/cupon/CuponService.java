package com.example.demo.cupon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CuponService {

    private CuponRepository cuponRepository;
    private CuponCache cuponCache;

    @Autowired
    public CuponService(CuponRepository cuponRepository, CuponCache cuponCache) {
        this.cuponRepository = cuponRepository;
        this.cuponCache = cuponCache;
    }

    public Double calculateDiscountFor(long cuponId, double amount) {
        Cupon cupon = cuponCache.get(cuponId);
        if (cupon == null) {
            log.info("cupon not in cache trying to get from data layer...");
            cupon = getCuponFromDataLayer(cuponId);
            cuponCache.set(cuponId, cupon);
        } else {
            log.info("Got cupon from cache");
        }
        return getPrice(cupon, amount);
    }

    private Double getPrice(Cupon cupon, double amount) {
        return (1 - cupon.getDiscount()) * amount;
    }

    private Cupon getCuponFromDataLayer(long cuponId) {
        Optional<Cupon> cuponOptional = cuponRepository.getById(cuponId);
        return cuponOptional.orElseThrow(CuponController.CuponNotFoundException::new);
    }

}
