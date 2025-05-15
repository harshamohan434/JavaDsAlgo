package SortingAlgorithems;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] input = new int[]{2,3,-1,0,0,1,5,2};

        int[] output = quickSort(input,0,input.length-1);

        System.out.println(Arrays.toString(output));
    }

    // select any element as pivot element probably last one
    // arrange array such that all element lesser than  pivot show place left and bigger than pivot will place right
    public static int[] quickSort(int[] input, int low, int high){

        if (low < high){
            int pi = arrangePivot(input , low, high);

            quickSort(input, low, pi-1);
            quickSort(input, pi+1, high);
        }

        return input;

    }

    public static int arrangePivot(int[] input, int low, int high){
        int pivot = input[high];
        int i = low;

        for (int j = low; j<high;j++){
            if (input[j] < pivot){
                int temp = input[j];
                input[j] = input[i];
                input[i] = temp;
                i++;
            }
        }

        input[high] = input[i];
        input[i] = pivot;
        return i;
    }
}
