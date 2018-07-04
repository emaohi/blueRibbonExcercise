package com.example.demo.cupon;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Getter
public class Cupon {

    private long id;
    private final static List<Double> discountOptions = Arrays.asList(0.1, 0.5, 0.6);
    private Double discount;

    public Cupon(long id) {
        this.id = id;
        this.discount = pickDiscount();
    }

    private Double pickDiscount() {
        int index = new Random().nextInt(discountOptions.size());
        return discountOptions.get(index);
    }

}
