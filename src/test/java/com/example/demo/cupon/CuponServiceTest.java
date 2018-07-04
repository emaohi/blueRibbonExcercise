package com.example.demo.cupon;

import org.junit.Test;

import static java.util.Optional.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class CuponServiceTest {
    private CuponRepository cuponRepository = mock(CuponRepository.class);
    private CuponCache cuponCache = mock(CuponCache.class);
    private Cupon cupon = mock(Cupon.class);

    @Test
    public void calculateDiscountFor() throws Exception {

        doReturn(0.1).when(cupon).getDiscount();
        doReturn(cupon).when(cuponCache).get(any(long.class));

        CuponService cuponService = new CuponService(cuponRepository, cuponCache);


        assertEquals(ofNullable(cuponService.calculateDiscountFor(123, 30)), of(27.0));
    }

}