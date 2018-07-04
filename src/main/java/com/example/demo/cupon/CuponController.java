package com.example.demo.cupon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/cupons")
public class CuponController {

    private CuponService cuponService;

    @Autowired
    public CuponController(CuponService cuponService) {
        this.cuponService = cuponService;
    }

    @RequestMapping(value = "/{cuponId}", method = RequestMethod.GET)
    public ResponseEntity<Double> getDiscountWithCupon(@PathVariable long cuponId,
                                                       @RequestParam(name="amount") double amount) {
        log.info("Got request to check if discount for cupon id {} and amount {}", cuponId, amount);
        try {
            Double afterDiscount = this.cuponService.calculateDiscountFor(cuponId, amount);
            return ResponseEntity.ok().body(afterDiscount);
        } catch (CuponNotFoundException e) {
            log.warn("No matching id: {}", cuponId);
            return ResponseEntity.badRequest().build();
        }
    }

    static class CuponNotFoundException extends RuntimeException {
        CuponNotFoundException(){
            super();
        }
    }

}
