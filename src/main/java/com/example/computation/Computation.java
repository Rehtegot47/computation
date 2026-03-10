package com.example.computation;

public class Computation {
    public double compute(double... nums){
        double result =0.0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
        }
        if(result > 10){
            System.out.println("Result is greater than 10");
        }
        return result;
    }

}
