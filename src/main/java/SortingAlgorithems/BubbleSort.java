package SortingAlgorithems;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] input = new int[]{2,5,1,6,-2};

        int[] output = bubbleSort(input);

        System.out.println(Arrays.toString(output));
    }

    //swap current element with smaller element and push bigger element to last
    //repeat untill we no elements present for swap
    public static int[] bubbleSort(int[] input){
        int len = input.length;

        for (int i =0; i<len-1;i++){
            boolean swapped = false;
            for (int j =0; j<len-i-1;j++){
                if (input[j] > input[j+1]){
                    int temp = input[j+1];
                    input[j+1] = input[j];
                    input[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }

        return input;

    }
}
