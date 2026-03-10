package com.example.computation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputationTest {
    @Test
    public void computeTest(){
        Computation computation = new Computation();
        double result = computation.compute(1.0, 3.0, 5.0);
        Assertions.assertEquals(9.0, result);
    }
}