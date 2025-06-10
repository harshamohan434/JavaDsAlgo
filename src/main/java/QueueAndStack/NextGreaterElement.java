package QueueAndStack;

import java.util.*;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] input = {4, 5, 2, 10, 8};
        int[] result = nextGreaterElementRight(input);
    }

    private static int[] nextGreaterElementRight(int[] input){
        int[] output = new int[input.length];
        Stack<Integer> highestElements = new Stack<>();
        for (int i=input.length-1; i>=0;i--){

            while (!highestElements.isEmpty() && highestElements.peek() < input[i]){
                highestElements.pop();
            }

            if (highestElements.isEmpty()){
                output[i] = -1;
            }else {
                output[i] = highestElements.peek();
            }

            highestElements.push(input[i]);
        }
        return output;
    }
}
