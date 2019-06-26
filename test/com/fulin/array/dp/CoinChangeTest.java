package com.fulin.array.dp;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class CoinChangeTest {

    @org.junit.Test
    public void coinChange() {
    }

    @org.junit.Test
    public void testSort() {
        Integer[] coins = {2,1,4};
        Arrays.sort(coins, Collections.reverseOrder());
        for(int coin : coins){
            System.out.print(coin +"\t");
        }
    }
}