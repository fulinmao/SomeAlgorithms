package com.fulin.offer.problem35;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstNotRepeatingCharTest {

    @Test
    public void test() {
        //存在只出现一个的字符串
        String str = "abaccdeff";
        char result = FirstNotRepeatingChar.firstNotRepeatingChar(str);
        if(result != 'b'){
            fail("method failed");

        }

        // 存在不止一个  出现一次的字符串
        str = "8776";
        result = FirstNotRepeatingChar.firstNotRepeatingChar(str);
        if(result != '8'){
            fail("method failed");

        }

        // 空字符串
        str = "";
        result = FirstNotRepeatingChar.firstNotRepeatingChar(str);
        if(result != ' '){
            fail("method failed");

        }

        // 字符串为null
        str = null;
        result = FirstNotRepeatingChar.firstNotRepeatingChar(str);
        if(result != ' '){
            fail("method failed");

        }

        // 不存在只出现一次的字符串
        str = "aabb";
        result = FirstNotRepeatingChar.firstNotRepeatingChar(str);
        if(result != ' '){
            fail("method failed");

        }
    }

}