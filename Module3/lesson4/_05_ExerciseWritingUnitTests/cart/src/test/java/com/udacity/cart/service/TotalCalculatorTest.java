package com.udacity.cart.service;

import com.udacity.cart.model.CartItem;
import com.udacity.cart.model.CartTotals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TotalCalculatorTest {
    @Test
    public void totalCalculator_givenMultupleItems_sumPriceandTaxs() {
        TotalsCalculator totalsCalculator = new TotalsCalculator();
        List<CartItem> list = new ArrayList<>();
        list.add(new CartItem("A", 1, 2));
        list.add(new CartItem("B", 2.5, 3.001));
        list.add(new CartItem("C", 1, 9));

        CartTotals totals = totalsCalculator.getTotals(list);
        Assertions.assertAll("HI",
                () -> Assertions.assertEquals(4.0, totals.getSubtotal(), 0.0001),
                () -> Assertions.assertEquals(14, totals.getTaxes(), 0.0001));
    }
}
