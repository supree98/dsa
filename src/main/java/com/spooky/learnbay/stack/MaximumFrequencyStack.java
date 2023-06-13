package com.spooky.learnbay.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// assignment leetcode 895. Maximum Frequency Stack
public class MaximumFrequencyStack {

    private int maxFrequency = 0;

    private Map<Integer, Integer> frequencyMap = new HashMap<>();

    private Map<Integer, Stack<Integer>> itemsStackMap = new HashMap<>();

    public void push(int val) {
        int frequency = frequencyMap.getOrDefault(val, 0);
        frequencyMap.put(val, ++frequency);

        if (frequency > maxFrequency) {
            maxFrequency = frequency;
        }
        Stack<Integer> frequencyStack = itemsStackMap.getOrDefault(frequency, new Stack<>());
        itemsStackMap.put(frequency, frequencyStack);
        frequencyStack.push(val);
    }

    public int pop() {
        Stack<Integer> itemsStack = itemsStackMap.get(maxFrequency);
        int val = itemsStack.pop();
        frequencyMap.put(val, frequencyMap.get(val) - 1);
        if (itemsStack.isEmpty()) {
            maxFrequency--;
        }
        return val;
    }

    // test examples
    public static void main(String[] args) {
        MaximumFrequencyStack freqStack = new MaximumFrequencyStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());

        MaximumFrequencyStack freqStack2 = new MaximumFrequencyStack();
        freqStack2.push(4);
        freqStack2.push(0);
        freqStack2.push(9);
        freqStack2.push(3);
        freqStack2.push(4);
        freqStack2.push(2);
        System.out.println(freqStack2.pop());
        freqStack2.push(1);
        System.out.println(freqStack2.pop());
        freqStack2.push(1);
        System.out.println(freqStack2.pop());
        freqStack2.push(4);
        System.out.println(freqStack2.pop());
        System.out.println(freqStack2.pop());
        System.out.println(freqStack2.pop());
        System.out.println(freqStack2.pop());
        System.out.println(freqStack2.pop());
        System.out.println(freqStack2.pop());
    }
}
