package SortingAlgorithems;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] input = new int[]{2,3,-1,0,0,1,5,2};

        int[] output = mergeSort(input,0,input.length-1);

        System.out.println(Arrays.toString(output));

    }

    public static int[] mergeSort(int[] input,int left, int right){

        if (left < right){
            int mid = (left + right)/2;

            mergeSort(input, left, mid);
            mergeSort(input, mid+1, right);

            merge(input, left, right, mid);
        }

        return input;
    }

    public static int[] merge(int[] input, int left, int right, int mid){

        int ln = mid-left+1;
        int rn = right-mid;

        int[] l =new int[ln];

        int[] r = new int[rn];

        for (int i = 0;i<ln;i++){
            l[i] = input[left+i];
        }

        for (int i= 0; i<rn;i++){
            r[i] = input[mid+i+1];
        }

        int i=0, j=0, k=left;

        while (i<ln && j<rn){
            if (l[i] < r[j]){
                input[left++] = l[i++];
            }else {
                input[left++] = r[j++];
            }
        }

        while (i<ln){
            input[left++] = l[i++];
        }

        while (j<rn){
            input[left++] = r[j++];
        }

        return input;
    }


}
