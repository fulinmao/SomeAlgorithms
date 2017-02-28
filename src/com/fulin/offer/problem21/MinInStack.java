package com.fulin.offer.problem21;

import java.util.Stack;


/**
 *
 * 定义栈的数据结果，请在该类型中实现一个能够得到栈的最小元素的min函数
 *
 * 在该栈中调用min push pop 方法的时间复杂度都是O(1)
 * @author mfl4482
 *
 */
public class MinInStack {

    public Stack<Integer> dataStack = new Stack<Integer>();
    public Stack<Integer> helpStack = new Stack<Integer>();


    public  Integer min(){
        if(helpStack == null || helpStack.size() == 0){
            return null;
        }
        Integer result = helpStack.peek();
        return result;

    }

    public Integer pop(){
        if(dataStack == null || dataStack.size() == 0 || helpStack == null || helpStack.size() == 0){
            return null;
        }
        Integer result = dataStack.pop();
        helpStack.pop();
        return result;

    }

    public void push(Integer node){
        dataStack.push(node);

        Integer min = node;
        if(helpStack != null && helpStack.size() > 0){
            if(helpStack.peek() < min){
                min = helpStack.peek();
            }
        }
        helpStack.push(min);

    }

}