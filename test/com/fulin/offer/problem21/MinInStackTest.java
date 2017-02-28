package com.fulin.offer.problem21;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinInStackTest {

    @Test
    public void test() {
        MinInStack stack = new MinInStack();
        stack.push(3);
        if(stack.min() != 3){
            fail("method: min error");
        }
        stack.push(4);
        if(stack.min() != 3){
            fail("method: min error");
        }
        stack.push(2);
        if(stack.min() != 2){
            fail("method: min error");
        }

        stack.push(1);
        if(stack.min() != 1){
            fail("method: min error");
        }
        stack.pop();
        if(stack.min() != 2){
            fail("method: min error");
        }

        stack.pop();
        if(stack.min() != 3){
            fail("method: min error");
        }
        stack.push(0);

        if(stack.min() != 0){
            fail("method: min error");
        }
    }

}